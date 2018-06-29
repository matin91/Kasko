package com.rocklobstre.kasko.di.user;

import com.rocklobstre.kasko.data.repositories.UserRepository;
import com.rocklobstre.kasko.data.repositories.datasource.UserDataSourceRemote;
import com.rocklobstre.kasko.di.app.component.AppComponent;
import com.rocklobstre.kasko.di.scope.ActivityScope;
import com.rocklobstre.kasko.domain.interactors.user.CheckUserUseCase;
import com.rocklobstre.kasko.domain.interactors.user.LoginUserUseCase;
import com.rocklobstre.kasko.domain.interactors.user.LogoutUserUseCase;
import com.rocklobstre.kasko.domain.interactors.user.RegisterUserUseCase;
import com.rocklobstre.kasko.domain.interactors.user.WriteUserUseCase;
import com.rocklobstre.kasko.presentation.presenters.impl.LoginPresenter;
import com.rocklobstre.kasko.presentation.presenters.impl.OnBoardingPresenter;
import com.rocklobstre.kasko.presentation.presenters.impl.RegisterPresenter;
import com.rocklobstre.kasko.presentation.ui.fragments.LandingFragment;
import com.rocklobstre.kasko.presentation.ui.fragments.LoginFragment;
import com.rocklobstre.kasko.presentation.ui.fragments.RegisterFragment;

import dagger.Component;

/**
 * The role of the component is to inject the dependencies in the specified targets
 * Targets must ALL be added here
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = UserModule.class
)
public interface UserComponent {

    //Fragments
    void inject(LandingFragment view);
    void inject(LoginFragment view);
    void inject(RegisterFragment view);

    // Presenters
    void inject(OnBoardingPresenter presenter);
    void inject(LoginPresenter presenter);
    void inject(RegisterPresenter presenter);

    // UseCases/Interactors
    void inject(CheckUserUseCase useCase);
    void inject(LoginUserUseCase useCase);
    void inject(LogoutUserUseCase useCase);
    void inject(RegisterUserUseCase useCase);
    void inject(WriteUserUseCase useCase);

    // Repositories
    void inject(UserRepository repository);

    // DataSources
    void inject(UserDataSourceRemote dataSource);
}