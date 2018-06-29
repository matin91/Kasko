package com.rocklobstre.kasko.di.app.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.rocklobstre.kasko.App;
import com.rocklobstre.kasko.external.AnalyticsInterface;
import com.rocklobstre.kasko.external.ConfigInterface;
import com.rocklobstre.kasko.di.app.module.AppModule;
import com.rocklobstre.kasko.di.scope.ApplicationScope;
import com.rocklobstre.kasko.external.TaskReminderInterface;
import com.rocklobstre.kasko.utils.rx.RxEventBus;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import dagger.Component;

/**
 * The role of the component is to inject the dependencies in the specified targets
 * Targets must ALL be added here
 */
@ApplicationScope
@Component(
        modules = {AppModule.class}
)
public interface AppComponent {

    // Allows to inject into the App
    void inject(App app);

    Context context();
    App app();
    RxEventBus<Object> rxEventBus();
    Gson gson();
    FirebaseDatabase firebaseDatabase();
    FirebaseAuth firebaseAuth();
    AnalyticsInterface analyticsHelper();
    ConfigInterface configHelper();
    TaskReminderInterface taskReminderHelper();
    SharedPreferences sharedPreferences();
}
