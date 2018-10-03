package com.devstree.safety.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devstree.safety.R;
import com.devstree.safety.enumeration.FragmentState;

public class HomeActivity extends AppNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        openHomeFragment(FragmentState.REPLACE);

    }
}
