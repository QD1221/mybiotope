package com.example.mybiotope.model;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DanhMucModel {
    int madanhmuc, hinhdanhmuc;
    String tendanhmuc;

    public DanhMucModel(int madanhmuc, String tendanhmuc, int hinhdanhmuc) {
        this.madanhmuc = madanhmuc;
        this.tendanhmuc = tendanhmuc;
        this.hinhdanhmuc = hinhdanhmuc;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public int getHinhdanhmuc() {
        return hinhdanhmuc;
    }

    public void setHinhdanhmuc(int hinhdanhmuc) {
        this.hinhdanhmuc = hinhdanhmuc;
    }

    public int getMadanhmuc() {
        return madanhmuc;
    }

    public void setMadanhmuc(int madanhmuc) {
        this.madanhmuc = madanhmuc;
    }
}
