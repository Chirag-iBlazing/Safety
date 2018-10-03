package com.devstree.safety.activity;

import android.app.ProgressDialog;
import android.content.Intent;

import com.devstree.safety.R;
import com.devstree.safety.enumeration.FragmentState;
import com.devstree.safety.listener.iActivityNavigator;
import com.devstree.safety.listener.iAuthNavigator;
import com.devstree.safety.listener.iHomeNavigator;
import com.devstree.safety.ui.fragment.HomeFragment;
import com.devstree.safety.ui.fragment.auth.LoginFragment;

/**
 * Created by Dhara on 29-09-2018.
 */

public class AppNavigationActivity extends BaseActivity implements iAuthNavigator, iHomeNavigator, iActivityNavigator {

    ProgressDialog dialog;

    @Override
    public void openLoginFragment(FragmentState fragmentState) {
        fragmentChange(LoginFragment.newInstance(), fragmentState);
    }

    @Override
    public void openHomeFragment(FragmentState fragmentState) {
        fragmentChange(HomeFragment.newInstance(),fragmentState);
    }

    @Override
    public void openHomeActivity() {
        Intent i = new Intent(this, HomeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    @Override
    public void showProgressDialog() {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setMessage(getString(R.string.loading));
            dialog.setCancelable(false);
            dialog.show();
        } else {
            dialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

}
