package com.devstree.safety.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.inputmethod.InputMethodManager;

import com.devstree.safety.activity.AuthenticationActivity;
import com.devstree.safety.activity.BaseActivity;
import com.devstree.safety.activity.HomeActivity;
import com.devstree.safety.model.BaseModel;
import com.devstree.safety.ui.fragment.HomeFragment;

import retrofit2.Call;

/**
 * Created by Chirag Solanki on 08-Aug-17.
 */

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment implements BaseView<P> {
    public P presenter;
    private BaseActivity baseActivity;

    protected AuthenticationActivity authActivity;
    protected HomeActivity homeActivity;

    public abstract P initView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initView();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            baseActivity = (BaseActivity) context;
        }

        if (context instanceof HomeActivity) {
            homeActivity = (HomeActivity) context;
        }

        if (context instanceof AuthenticationActivity) {
            authActivity = (AuthenticationActivity) context;
        }
    }

    @Override
    public void showSnackBar(String str) {
        if (baseActivity != null)
            baseActivity.showSnackBar(getView(), str);
    }


    @Override
    public void showToast(String str) {

    }

    @Override
    public void onFailure(BaseModel baseModel, int code) {

    }

    @Override
    public void onError(Call<? extends BaseModel> responseCall, Throwable t) {

    }

    @Override
    public void hideKeyBoard() {
        InputMethodManager imm;

        if ((getActivity()) != null) {
            imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            }
        }

    }


}
