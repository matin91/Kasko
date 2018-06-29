package com.rocklobstre.kasko.di.user;

import android.support.v4.app.Fragment;

import com.rocklobstre.kasko.external.AnalyticsInterface;
import com.rocklobstre.kasko.external.ConfigInterface;
import com.rocklobstre.kasko.data.repositories.UserRepository;
import com.rocklobstre.kasko.data.repositories.datasource.UserDataSourceRemote;
import com.rocklobstre.kasko.domain.interactors.user.CheckUserUseCase;
import com.rocklobstre.kasko.domain.interactors.user.LoginUserUseCase;
import com.rocklobstre.kasko.domain.interactors.user.LogoutUserUseCase;
import com.rocklobstre.kasko.domain.interactors.user.RegisterUserUseCase;
import com.rocklobstre.kasko.domain.interactors.user.WriteUserUseCase;
import com.rocklobstre.kasko.presentation.presenters.impl.LoginPresenter;
import com.rocklobstre.kasko.presentation.presenters.impl.OnBoardingPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    private Fragment fragment;

    public UserModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    Fragment provideFragment() {
        return fragment;
    }

    @Provides
    OnBoardingPresenter provideOnBoardingPresenter(CheckUserUseCase checkUserUseCase,
                                                   AnalyticsInterface analyticsInterface,
                                                   ConfigInterface configInterface) {
        return new OnBoardingPresenter(checkUserUseCase,
                analyticsInterface,
                configInterface);
    }

    @Provides
    LoginPresenter provideLoginPresenter(LoginUserUseCase loginUserUseCase,
                                         AnalyticsInterface analyticsInterface) {
        return new LoginPresenter(loginUserUseCase, analyticsInterface);
    }

    @Provides
    CheckUserUseCase provideCheckUserUseCase(UserRepository repository) {
        return new CheckUserUseCase(repository);
    }

    @Provides
    LoginUserUseCase provideLoginUserUseCase(UserRepository repository) {
        return new LoginUserUseCase(repository);
    }

    @Provides
    LogoutUserUseCase provideLogoutUserUseCase(UserRepository repository) {
        return new LogoutUserUseCase(repository);
    }

    @Provides
    RegisterUserUseCase provideRegisterUserUseCase(UserRepository repository) {
        return new RegisterUserUseCase(repository);
    }

    @Provides
    WriteUserUseCase provideWriteUserUseCase(UserRepository repository) {
        return new WriteUserUseCase(repository);
    }

    @Provides
    UserDataSourceRemote provideDataSource(FirebaseAuth firebaseAuth,
                                                  FirebaseDatabase firebaseDatabase) {
        return new UserDataSourceRemote(firebaseAuth, firebaseDatabase);
    }

    @Provides
    UserRepository provideRepository(UserDataSourceRemote dataSource) {
        return new UserRepository(dataSource);
    }

}