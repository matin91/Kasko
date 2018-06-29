package com.rocklobstre.kasko.presentation.presenters;

import com.rocklobstre.kasko.domain.models.BucketModel;
import com.rocklobstre.kasko.domain.models.TagListModel;
import com.rocklobstre.kasko.domain.models.TaskModel;
import com.rocklobstre.kasko.presentation.ui.base.BaseMvpView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by remychantenay on 08/05/2016.
 */
public interface BucketMVP {

    interface View extends BaseMvpView {
        void showBucket(ArrayList<TaskModel> model);
        void showBucketEmpty();
        void showBucketEmptyFirstTime();
        void showBucketError();

        void showTaskDeleted();
        void showTaskDeletedError(String message);

        void onItemSwiped(int position);
    }

    interface Presenter {
        void getBucket();
        void onGetBucketSuccess(BucketModel bucketModel);
        void onGetBucketFailure(Throwable e);

        void onGetBucketSuccessTracking();
        void onGetBucketFailureTracking(Throwable e);

        void deleteTask(String taskId);
        void onDeleteTaskSuccess();
        void onDeleteTaskFailure(Throwable e);

        void onDeleteTaskSuccessTracking();
        void onDeleteTaskFailureTracking(Throwable e);
    }
}
