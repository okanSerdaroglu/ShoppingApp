package com.okanserdaroglu.shoppingapp.ui.Base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<T, V extends BaseViewHolder<T>> extends
        RecyclerView.Adapter<V> {

    private MutableLiveData<List<T>> items = new MutableLiveData<>();

    public BaseRecyclerViewAdapter() {
    }

    protected void setItems(MutableLiveData<List<T>> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, getItemLayoutId(viewType), parent, false);
        return getViewHolder(binding, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull V holder, int position) {
        holder.bind(items.getValue().get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.getValue().size();
    }

    @LayoutRes
    protected abstract int getItemLayoutId(int viewType);

    protected abstract V getViewHolder(ViewDataBinding binding, int viewType);
}