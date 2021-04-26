package com.example.mybiotope;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybiotope.adapter.BaiVietAdapter;
import com.example.mybiotope.adapter.ThongBaoAdapter;
import com.example.mybiotope.model.BaiVietModel;

public class BaiVietFragment extends Fragment {
    RecyclerView recyclerView;
    BaiVietAdapter baiVietAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_baiviet, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        baiVietAdapter = new BaiVietAdapter();
        recyclerView.setAdapter(baiVietAdapter);
        return view;
    }
}
