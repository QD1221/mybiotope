package com.example.mybiotope.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.example.mybiotope.R;
import com.example.mybiotope.model.ThongBaoModel;

import java.util.ArrayList;
import java.util.List;


public class ThongBaoAdapter extends RecyclerSwipeAdapter<ThongBaoAdapter.SimpleViewHolder> {

    Context mContext;
    List<ThongBaoModel> thongBaoModelList;

    public ThongBaoAdapter(Context mContext, ArrayList<ThongBaoModel> models) {
        this.mContext = mContext;
        this.thongBaoModelList = models;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongbao, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder viewHolder, final int position) {
        ThongBaoModel thongBaoModel = thongBaoModelList.get(position);

        viewHolder.imgBanner.setImageResource(R.drawable.ic_launcher_background);
        viewHolder.tvTitle.setText(thongBaoModel.getNoidung());
        viewHolder.tvHours.setText(thongBaoModel.getThoigian());

        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);

        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, viewHolder.swipeLayout.findViewById(R.id.bottom_wraper));
        mItemManger.bindView(viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return thongBaoModelList.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public SwipeLayout swipeLayout;
        ImageView imgBanner;
        TextView tvTitle,tvHours;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            swipeLayout = itemView.findViewById(R.id.swipe);
            imgBanner = itemView.findViewById(R.id.imgBanner);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvHours = itemView.findViewById(R.id.tvHours);
        }
    }
}