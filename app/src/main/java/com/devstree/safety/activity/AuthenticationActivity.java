package com.devstree.safety.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devstree.safety.R;
import com.devstree.safety.enumeration.FragmentState;

public class AuthenticationActivity extends AppNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        openLoginFragment(FragmentState.REPLACE);
    }
}
