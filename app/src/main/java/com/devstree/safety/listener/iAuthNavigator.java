package com.devstree.safety.listener;

import android.support.annotation.Nullable;

import com.devstree.safety.enumeration.FragmentState;

import java.util.List;

/**
 * Created by Dhara on 29-09-2018.
 */

public interface iAuthNavigator {

    void openLoginFragment(FragmentState fragmentState);

    void openHomeFragment(FragmentState fragmentState);

}
