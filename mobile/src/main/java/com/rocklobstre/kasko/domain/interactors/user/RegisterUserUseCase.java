package com.rocklobstre.kasko.domain.interactors.user;

import com.rocklobstre.kasko.data.repositories.UserRepository;
import com.rocklobstre.kasko.domain.interactors.Params;
import com.rocklobstre.kasko.domain.interactors.base.BaseUseCase;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Implementation of {@link BaseUseCase} that represents a UseCase/Interactor
 */
public class RegisterUserUseCase extends BaseUseCase {

  private final UserRepository userRepository;

  private final static String PARAMS_KEY_EMAIL = "param_email";
  private final static String PARAMS_KEY_PASSWORD = "param_password";

  @Inject
  public RegisterUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override public Observable getObservable(Params params) {
    return this.userRepository.register(params.getString(PARAMS_KEY_EMAIL, null),
            params.getString(PARAMS_KEY_PASSWORD, null));
  }
}