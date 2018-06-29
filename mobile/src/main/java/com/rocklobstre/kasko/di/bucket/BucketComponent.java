package com.rocklobstre.kasko.di.bucket;

import com.rocklobstre.kasko.data.repositories.BucketRepository;
import com.rocklobstre.kasko.data.repositories.TaskRepository;
import com.rocklobstre.kasko.data.repositories.datasource.BucketDataSourceRemote;
import com.rocklobstre.kasko.data.repositories.datasource.TaskDataSourceRemote;
import com.rocklobstre.kasko.di.app.component.AppComponent;
import com.rocklobstre.kasko.di.scope.ActivityScope;
import com.rocklobstre.kasko.domain.interactors.bucket.GetBucketUseCase;
import com.rocklobstre.kasko.domain.interactors.task.DeleteTaskUseCase;
import com.rocklobstre.kasko.presentation.presenters.impl.BucketPresenter;
import com.rocklobstre.kasko.presentation.presenters.impl.CreateTaskPresenter;
import com.rocklobstre.kasko.presentation.ui.fragments.BucketFragment;
import com.rocklobstre.kasko.presentation.ui.fragments.CreateTaskFragment;

import dagger.Component;

/**
 * The role of the component is to inject the dependencies in the specified targets
 * Targets must ALL be added here
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = BucketModule.class
)
public interface BucketComponent {

    //Fragments
    void inject(BucketFragment view);

    // Presenters
    void inject(BucketPresenter presenter);

    // UseCases/Interactors
    void inject(GetBucketUseCase useCase);
    void inject(DeleteTaskUseCase useCase);

    // Repositories
    void inject(BucketRepository repository);
    void inject(TaskRepository repository);

    // DataSources
    void inject(BucketDataSourceRemote dataSource);
    void inject(TaskDataSourceRemote dataSource);
}