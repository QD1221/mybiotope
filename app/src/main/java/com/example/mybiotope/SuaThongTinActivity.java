package com.example.mybiotope;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

public class SuaThongTinActivity extends AppCompatActivity {
    /*------Variable Define----*/
    SharedPreferences sharedPreferences;
    ImageView imgBack;
    TextView tvTitle;
    RoundedImageView rivuser;
    EditText etten, etmail, etsdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thongtin);


        /*-------Status Color Code To Change--------*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.green));
        }
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Edit Profile");

        rivuser = findViewById(R.id.rivuser);
        etten = findViewById(R.id.etten);
        etmail = findViewById(R.id.etmail);
        etsdt = findViewById(R.id.etsdt);

        sharedPreferences = getSharedPreferences("luudangnhap", MODE_PRIVATE);

        String tenuser = sharedPreferences.getString("tenuser", "");
        if (!tenuser.equals("")||tenuser.length()!= 0){
            etten.setText(tenuser);
        }else {
            etten.setText("Thành viên");
        }

        String hinhuser = sharedPreferences.getString("hinhuser", "");
        Picasso.get().load(hinhuser).error(getDrawable(R.drawable.user)).into(rivuser);
    }
}