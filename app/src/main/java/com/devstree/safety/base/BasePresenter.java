package com.devstree.safety.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chirag Solanki on 08-Aug-17.
 */

public abstract class BasePresenter<V extends BaseView> {
    public V baseView;

    public BasePresenter(V mView) {
        this.baseView = mView;
    }

    public abstract void start();

    public abstract void stop();

    public abstract void detechView();


 /*   public void setAdapter(Context context, @LayoutRes int layout, RecyclerView recyclerView, int noOfRecord) {
        GenericTemporaryAdapter adapter = new GenericTemporaryAdapter(layout, noOfRecord);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void setAdapterTemp(Context context, @LayoutRes int layout, RecyclerView recyclerView, List<String> datalist) {
        GenericTemporaryWithDataAdapter adapter = new GenericTemporaryWithDataAdapter(layout, datalist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }*/


    public List<String> getStringList(int norecord, String DisplayContent) {
        List<String> datalist = new ArrayList<>();
        for (int i = 1; i <= norecord; i++) {
            datalist.add(DisplayContent);
        }
        return datalist;
    }

}
