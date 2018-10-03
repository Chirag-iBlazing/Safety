package com.devstree.safety.adapter.generic_adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by Chirag Solanki on 25-Sep-17.
 */

public abstract class SingleSelectionAdapter<T, VH extends RecyclerView.ViewHolder> extends GenericAdapter<T, VH> {


    public T getSelectedItem() throws NullPointerException {
        return selectedItem;
    }

    public void setSelectedItem(T selectedItem) {
        this.selectedItem = selectedItem;

    }

    private T selectedItem;

    public SingleSelectionAdapter(@LayoutRes int layout, Class<VH> mViewHolderClass, List<T> modelList) {
        super(layout, mViewHolderClass, modelList);
        if (modelList != null)
            selectedItem = modelList.get(0);
    }


}
