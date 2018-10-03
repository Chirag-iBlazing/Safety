package com.devstree.safety.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devstree.safety.R;

public class SplashActivity extends AppNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
