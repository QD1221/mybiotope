package com.example.mybiotope;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CuaHangActivity extends AppCompatActivity {
    Toolbar tbCuahang;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cuahang);

        tbCuahang = findViewById(R.id.tbCuahang);

        ActionToolbar();
    }

    private void ActionToolbar(){
        tbCuahang.setNavigationIcon(R.drawable.ic_arrow_back_ios_new_24);
        tbCuahang.setNavigationOnClickListener(v -> finish());
    }
}
