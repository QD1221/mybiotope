package com.example.mybiotope;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;


public class TaiKhoanFragment extends Fragment {
    FirebaseAuth firebaseAuth;
    SharedPreferences sharedPreferences;
    LinearLayout lldangxuat, lllienhe, llquanlydiachi, lldieukhoan;
    SwitchCompat switchCompattk;
    RoundedImageView rivuser;
    TextView tvtenuser, tvmauser, tvsua;

    public static final String NIGHT_MODE = "NIGHT_MODE";
    private static final String PREF = "AppSettingsPrefs";
    private static final String FIRST_START = "FirstStart";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_taikhoan, container, false);

        rivuser = view.findViewById(R.id.rivuser);
        tvtenuser = view.findViewById(R.id.tvtenuser);
        tvmauser = view.findViewById(R.id.tvmauser);

        sharedPreferences = getActivity().getSharedPreferences("luudangnhap", getActivity().MODE_PRIVATE);

        String tenuser = sharedPreferences.getString("tenuser", "");
        if (!tenuser.equals("")||tenuser.length()!= 0){
            tvtenuser.setText(tenuser);
        }else {
            tvtenuser.setText("Thành viên");
        }

        String mauser = sharedPreferences.getString("mauser", "");
        if (!mauser.equals("")||mauser.length()!= 0){
            tvmauser.setText(mauser);
        }else {
            tvmauser.setText("");
        }

        String hinhuser = sharedPreferences.getString("hinhuser", "");
        Picasso.get().load(hinhuser).error(getActivity().getDrawable(R.drawable.user)).into(rivuser);

        tvsua = view.findViewById(R.id.tvsua);
        tvsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SuaThongTinActivity.class);
                startActivity(intent);
            }
        });

        lldangxuat = view.findViewById(R.id.lldangxuat);
        lldangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                Intent intent = new Intent(getActivity(), DangNhapActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        lllienhe = view.findViewById(R.id.lllienhe);
        lllienhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LienHeActivity.class);
                startActivity(intent);
            }
        });

        llquanlydiachi = view.findViewById(R.id.llquanlydiachi);
        llquanlydiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddAddress.class);
                startActivity(intent);
            }
        });

        lldieukhoan = view.findViewById(R.id.lldieukhoan);
        lldieukhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PrivacyPolicy.class);
                startActivity(intent);
            }
        });

        switchCompattk = view.findViewById(R.id.switchCompattk);

        final SharedPreferences appSettingsPrefs = getActivity().getSharedPreferences(PREF,0);
        final boolean isNightModeOn = appSettingsPrefs.getBoolean(NIGHT_MODE, true);
        boolean isFirstStart = appSettingsPrefs.getBoolean(FIRST_START, true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && isFirstStart ){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        } else {
            if (isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            switchCompattk.setChecked(true);

        switchCompattk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = appSettingsPrefs.edit();
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putBoolean(FIRST_START, false);
                    editor.putBoolean(NIGHT_MODE, true);
                    editor.apply();

                    }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putBoolean(FIRST_START, false);
                    editor.putBoolean(NIGHT_MODE, false);
                    editor.apply();

                }
            }
        });
        return view;
    }


}




