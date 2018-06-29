package com.rocklobstre.kasko.di.task;

import com.rocklobstre.kasko.data.repositories.TagListRepository;
import com.rocklobstre.kasko.data.repositories.TaskRepository;
import com.rocklobstre.kasko.data.repositories.datasource.TagListDataSourceRemote;
import com.rocklobstre.kasko.data.repositories.datasource.TaskDataSourceRemote;
import com.rocklobstre.kasko.di.app.component.AppComponent;
import com.rocklobstre.kasko.di.scope.ActivityScope;
import com.rocklobstre.kasko.domain.interactors.taglist.GetTagListUseCase;
import com.rocklobstre.kasko.domain.interactors.task.CreateTaskUseCase;
import com.rocklobstre.kasko.domain.interactors.task.DeleteTaskUseCase;
import com.rocklobstre.kasko.presentation.presenters.impl.CreateTaskPresenter;
import com.rocklobstre.kasko.presentation.ui.fragments.CreateTaskFragment;

import dagger.Component;

/**
 * The role of the component is to inject the dependencies in the specified targets
 * Targets must ALL be added here
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = TaskModule.class
)
public interface TaskComponent {

    //Fragments
    void inject(CreateTaskFragment view);

    // Presenters
    void inject(CreateTaskPresenter presenter);

    // UseCases/Interactors
    void inject(GetTagListUseCase useCase);
    void inject(CreateTaskUseCase useCase);
    void inject(DeleteTaskUseCase useCase);

    // Repositories
    void inject(TaskRepository repository);
    void inject(TagListRepository repository);

    // DataSources
    void inject(TaskDataSourceRemote dataSource);
    void inject(TagListDataSourceRemote dataSource);
}