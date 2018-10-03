package com.devstree.safety.adapter.generic_adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


public abstract class GenericAdapterWithPagination<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected final Class<VH> mViewHolderClass;
    protected List<T> modelList;
    protected int layout;

    public GenericAdapterWithPagination(@LayoutRes int layout, Class<VH> mViewHolderClass, List<T> modelList) {
        this.modelList = modelList;
        this.layout = layout;
        this.mViewHolderClass = mViewHolderClass;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        try {
            Constructor<VH> constructor = mViewHolderClass.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        T model = modelList.get(position);
        setViewHolderData(holder, model, position);

        if (position == modelList.size() - 1)
            loadMore();
    }

    public abstract void setViewHolderData(VH viewHolderData, T data, int position);

    public abstract void loadMore();

    @Override
    public int getItemCount() {
        return modelList.size();
    }

}