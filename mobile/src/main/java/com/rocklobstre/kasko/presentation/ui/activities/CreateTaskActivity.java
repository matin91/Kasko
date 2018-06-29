package com.rocklobstre.kasko.presentation.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.rocklobstre.kasko.R;
import com.rocklobstre.kasko.presentation.ui.base.BaseActivity;
import com.rocklobstre.kasko.presentation.ui.base.BaseFragment;
import com.rocklobstre.kasko.presentation.ui.fragments.CreateTaskFragment;
import com.rocklobstre.kasko.presentation.ui.fragments.LoginFragment;
import com.cremy.greenrobotutils.library.ui.SnackBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateTaskActivity extends BaseActivity {

    /**
     * Allows to start this activity
     * @param context
     */
    public static void startMe(Context context) {
        Intent intent = new Intent(context, CreateTaskActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        this.getExtras(getIntent());
        this.setUpToolbar();

        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, CreateTaskFragment.newInstance())
                .commit();
    }

    @Override
    public void getExtras(Intent _intent) {

    }

    @Override
    public void closeActivity() {
        this.finish();
    }

    @Override
    public void setUpToolbar() {

    }

    @Override
    public Fragment getAttachedFragment(int id) {
        return getSupportFragmentManager().findFragmentById(id);
    }

    @Override
    public Fragment getAttachedFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }
}