package com.devstree.safety.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.devstree.safety.R;
import com.devstree.safety.base.BaseFragment;
import com.devstree.safety.enumeration.FragmentState;

/**
 * Created by Dhara on 29-09-2018.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    void fragmentChange(Fragment fragment, FragmentState fragmentState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragmentState == FragmentState.ADD) {
            transaction.add(R.id.fragment_container, fragment);
        } else {
            transaction.replace(R.id.fragment_container, fragment);
        }
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
    }

    public void showSnackBar(View v, String str) {
        Snackbar snackbar = Snackbar.make(v, str, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public BaseFragment getCurrentFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        return (BaseFragment) fragment;
    }

    @Override
    public void onBackPressed() {

        int i = getSupportFragmentManager().getBackStackEntryCount();
        if (i > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            this.finish();
        }
    }

}
