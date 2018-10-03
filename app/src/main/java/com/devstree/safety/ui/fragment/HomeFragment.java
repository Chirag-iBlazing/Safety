package com.devstree.safety.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devstree.safety.R;
import com.devstree.safety.base.BaseFragment;
import com.devstree.safety.base.BaseView;
import com.devstree.safety.ui.presenter.HomePresenter;
import com.devstree.safety.ui.view.HomeView;

/**
 * Created by Dhara on 29-09-2018.
 */

public class HomeFragment extends BaseFragment<HomeView,HomePresenter> implements HomeView {
    @Override
    public HomePresenter initView() {
        return new HomePresenter(this);
    }

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_home,container,false);
       return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
