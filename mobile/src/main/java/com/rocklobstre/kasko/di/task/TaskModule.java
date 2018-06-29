package com.rocklobstre.kasko.di.task;

import android.support.v4.app.Fragment;

import com.rocklobstre.kasko.external.AnalyticsInterface;
import com.rocklobstre.kasko.data.repositories.TagListRepository;
import com.rocklobstre.kasko.data.repositories.TaskRepository;
import com.rocklobstre.kasko.data.repositories.datasource.TagListDataSourceRemote;
import com.rocklobstre.kasko.data.repositories.datasource.TaskDataSourceRemote;
import com.rocklobstre.kasko.domain.interactors.taglist.GetTagListUseCase;
import com.rocklobstre.kasko.domain.interactors.task.CreateTaskUseCase;
import com.rocklobstre.kasko.domain.interactors.task.DeleteTaskUseCase;
import com.rocklobstre.kasko.external.TaskReminderInterface;
import com.rocklobstre.kasko.presentation.presenters.impl.CreateTaskPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskModule {

    private Fragment fragment;

    public TaskModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    Fragment provideFragment() {
        return fragment;
    }

    @Provides
    CreateTaskPresenter provideCreateTaskPresenter(GetTagListUseCase getTagListUseCase,
                                                   CreateTaskUseCase createTaskUseCase,
                                                   AnalyticsInterface analyticsInterface,
                                                   TaskReminderInterface taskReminderInterface) {
        return new CreateTaskPresenter(getTagListUseCase,
                createTaskUseCase,
                analyticsInterface,
                taskReminderInterface);
    }

    @Provides
    GetTagListUseCase provideGetTagListUseCase(TagListRepository repository) {
        return new GetTagListUseCase(repository);
    }

    @Provides
    CreateTaskUseCase provideCreateTaskUseCase(TaskRepository repository) {
        return new CreateTaskUseCase(repository);
    }

    @Provides
    DeleteTaskUseCase provideDeleteTaskUseCase(TaskRepository repository) {
        return new DeleteTaskUseCase(repository);
    }

    @Provides
    TagListDataSourceRemote provideTagListDataSource(FirebaseDatabase firebaseDatabase) {
        return new TagListDataSourceRemote(firebaseDatabase);
    }

    @Provides
    TaskDataSourceRemote provideTaskDataSource(FirebaseAuth firebaseAuth,
                                           FirebaseDatabase firebaseDatabase) {
        return new TaskDataSourceRemote(firebaseAuth, firebaseDatabase);
    }

    @Provides
    TagListRepository provideTagListRepository(TagListDataSourceRemote dataSource) {
        return new TagListRepository(dataSource);
    }

    @Provides
    TaskRepository provideTaskRepository(TaskDataSourceRemote dataSource) {
        return new TaskRepository(dataSource);
    }

}