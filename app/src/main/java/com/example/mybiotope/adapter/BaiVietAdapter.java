package com.example.mybiotope.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybiotope.R;

public class BaiVietAdapter extends RecyclerView.Adapter<BaiVietAdapter.BaiVietViewHolder> {
    @NonNull
    @Override
    public BaiVietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baiviet, parent, false);
        return new BaiVietViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiVietViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class BaiVietViewHolder extends RecyclerView.ViewHolder {
        public BaiVietViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
