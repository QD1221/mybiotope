package com.example.mybiotope;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybiotope.adapter.ThongBaoAdapter;
import com.example.mybiotope.model.ThongBaoModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ThongBaoFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ThongBaoModel> thongBaoModels;
    ThongBaoAdapter thongBaoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_thongbao, container, false);

        /*----Notification Recycler Code Here----*/
        recyclerView = view.findViewById(R.id.rvNotification);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        thongBaoModels = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("thongbaos");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapthongbao : snapshot.getChildren()){
                    ThongBaoModel thongBaoModel = snapthongbao.getValue(ThongBaoModel.class);
                    thongBaoModels.add(thongBaoModel);

                }
                thongBaoAdapter = new ThongBaoAdapter(getContext(), thongBaoModels);
                recyclerView.setAdapter(thongBaoAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }
}
