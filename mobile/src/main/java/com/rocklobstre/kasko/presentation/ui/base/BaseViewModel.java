package com.rocklobstre.kasko.presentation.ui.base;

import android.databinding.BaseObservable;

import com.rocklobstre.kasko.utils.rx.RxEventBus;

import javax.inject.Inject;

public abstract class BaseViewModel
        extends BaseObservable {

    @Inject
    public RxEventBus<Object> rxEventBus;

    //region Constructor
    public BaseViewModel() {
        // To complete
    }
    //endregion

}