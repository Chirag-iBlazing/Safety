package com.devstree.safety.ui.fragment.auth;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devstree.safety.R;
import com.devstree.safety.base.BaseFragment;
import com.devstree.safety.model.BaseModel;
import com.devstree.safety.ui.presenter.LoginPresenter;
import com.devstree.safety.ui.view.LoginView;

import retrofit2.Call;

/**
 * Created by Dhara on 29-09-2018.
 */

public class LoginFragment extends BaseFragment<LoginView, LoginPresenter> implements LoginView {

    @Override
    public LoginPresenter initView() {
        return new LoginPresenter(this);
    }

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_login,container,false);
       return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
