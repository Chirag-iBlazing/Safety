package com.devstree.safety.base;


import com.devstree.safety.model.BaseModel;

import retrofit2.Call;

/**
 * Created by Chirag Solanki on 08-Aug-17.
 */

public interface BaseView<P extends BasePresenter> {

    void showSnackBar(String str);

    void showToast(String str);

    void onFailure(BaseModel baseModel, int code);

    void onError(Call<? extends BaseModel> responseCall, Throwable t);
    void hideKeyBoard();
}
