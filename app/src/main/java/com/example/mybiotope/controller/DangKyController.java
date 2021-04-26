package com.example.mybiotope.controller;

import com.example.mybiotope.model.ThanhVienModel;

public class DangKyController {
    ThanhVienModel thanhVienModel;

    public DangKyController(){
        thanhVienModel = new ThanhVienModel();
    }

    public void ThemThongTinThanhVienController(ThanhVienModel thanhVienModel, String uid){
        thanhVienModel.ThemThongTinThanhVien(thanhVienModel, uid);
    }
}
