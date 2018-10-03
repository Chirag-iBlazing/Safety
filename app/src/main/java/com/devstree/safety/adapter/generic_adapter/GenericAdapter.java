package com.devstree.safety.adapter.generic_adapter;


import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Chirag Solanki on 28-07-2017.
 */

public abstract class GenericAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected final Class<VH> mViewHolderClass;
    protected List<T> modelList;
    protected int layout;
    private boolean isLoadingAdded = false;

    public GenericAdapter(@LayoutRes int layout, Class<VH> mViewHolderClass, List<T> modelList) {
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
    }

    public abstract void setViewHolderData(VH viewHolderData, T data, int position);

    @Override
    public int getItemCount() {
        if (modelList != null)
            return modelList.size();
        else
            return 0;
    }

    public void add(T mc) {
        modelList.add(mc);
        notifyItemInserted(modelList.size() - 1);
    }

    public void addAll(List<T> mcList) {
        for (T mc : mcList) {
            add(mc);
        }
    }

    public void remove(T dataEntity) {
        int position = modelList.indexOf(dataEntity);
        if (position > -1) {
            modelList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        //add();
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = modelList.size() - 1;
        if (getItem(position) != null) {
            modelList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public T getItem(int position) {
        return modelList.get(position);
    }

}