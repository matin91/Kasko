package com.rocklobstre.kasko.presentation.presenters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;

import com.rocklobstre.kasko.presentation.ui.base.BaseMvpView;

/**
 * Created by remychantenay on 08/05/2016.
 */
public interface OnBoardingMVP {

    interface View extends BaseMvpView {
        void userLogged();
    }

    interface Presenter {
        void goToBucket(Context context);
        void checkIfUserIsLogged();

        boolean isInMaintenance();
    }
}
