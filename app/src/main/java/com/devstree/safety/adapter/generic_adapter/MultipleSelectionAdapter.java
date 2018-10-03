package com.devstree.safety.adapter.generic_adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chirag Solanki on 25-Sep-17.
 */

public abstract class MultipleSelectionAdapter<T, VH extends RecyclerView.ViewHolder> extends GenericAdapter<T, VH> {

    public List<T> getSelectedItemList() {
        return selectedItemList;
    }

    private List<T> selectedItemList;

    public MultipleSelectionAdapter(@LayoutRes int layout, Class<VH> mViewHolderClass, List<T> modelList) {
        super(layout, mViewHolderClass, modelList);
        selectedItemList = new ArrayList<>();
    }

    public void selectItem(T data) {
        selectedItemList.add(data);
    }

    public void unSelectItem(T data) {
        selectedItemList.remove(data);
    }
}
