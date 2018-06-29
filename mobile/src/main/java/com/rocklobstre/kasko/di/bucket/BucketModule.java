package com.rocklobstre.kasko.di.bucket;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;

import com.rocklobstre.kasko.external.AnalyticsInterface;
import com.rocklobstre.kasko.data.repositories.BucketRepository;
import com.rocklobstre.kasko.data.repositories.TaskRepository;
import com.rocklobstre.kasko.data.repositories.datasource.BucketDataSourceRemote;
import com.rocklobstre.kasko.data.repositories.datasource.TaskDataSourceRemote;
import com.rocklobstre.kasko.domain.interactors.bucket.GetBucketUseCase;
import com.rocklobstre.kasko.domain.interactors.task.DeleteTaskUseCase;
import com.rocklobstre.kasko.presentation.presenters.impl.BucketPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class BucketModule {

    private Fragment fragment;

    public BucketModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    Fragment provideFragment() {
        return fragment;
    }

    @Provides
    BucketPresenter provideBucketPresenter(GetBucketUseCase getBucketUseCase,
                                           DeleteTaskUseCase deleteTaskUseCase,
                                           AnalyticsInterface analyticsInterface,
                                           SharedPreferences sharedPreferences) {
        return new BucketPresenter(getBucketUseCase,
                deleteTaskUseCase,
                analyticsInterface,
                sharedPreferences);
    }

    @Provides
    GetBucketUseCase provideGetBucketUseCase(BucketRepository repository) {
        return new GetBucketUseCase(repository);
    }

    @Provides
    BucketDataSourceRemote provideBucketDataSource(FirebaseAuth firebaseAuth,
                                             FirebaseDatabase firebaseDatabase) {
        return new BucketDataSourceRemote(firebaseAuth, firebaseDatabase);
    }

    @Provides
    BucketRepository provideBucketRepository(BucketDataSourceRemote dataSource) {
        return new BucketRepository(dataSource);
    }

    @Provides
    DeleteTaskUseCase provideDeleteTaskUseCase(TaskRepository repository) {
        return new DeleteTaskUseCase(repository);
    }

    @Provides
    TaskDataSourceRemote provideTaskDataSource(FirebaseAuth firebaseAuth,
                                             FirebaseDatabase firebaseDatabase) {
        return new TaskDataSourceRemote(firebaseAuth, firebaseDatabase);
    }

    @Provides
    TaskRepository provideTaskRepository(TaskDataSourceRemote dataSource) {
        return new TaskRepository(dataSource);
    }

}