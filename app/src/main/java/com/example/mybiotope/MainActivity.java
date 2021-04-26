package com.example.mybiotope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    public static final String NIGHT_MODE = "NIGHT_MODE";
    private static final String PREF = "AppSettingsPrefs";
    private static final String FIRST_START = "FirstStart";

    BottomNavigationView bnv;
    FloatingActionButton fab;


    Toolbar toolbar;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences appSettingsPrefs = MainActivity.this.getSharedPreferences(PREF,0);
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

        bnv = findViewById(R.id.bnv);
        fab = findViewById(R.id.fab);
        toolbar = findViewById(R.id.tbnav);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        bnv.setOnNavigationItemSelectedListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CuaHangActivity.class);
                startActivity(intent);

            }
        });
        toolbar.setTitle("Home");
        loadFragment(new TrangChuFragment());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navHome:
                fragment = new TrangChuFragment();
                toolbar.setTitle("Home");
                loadFragment(fragment);
                return true;
            case R.id.navPost:
                fragment = new BaiVietFragment();
                toolbar.setTitle("Posts");
                loadFragment(fragment);
                return true;
            case R.id.navNotif:
                fragment = new ThongBaoFragment();
                toolbar.setTitle("Notification");
                loadFragment(fragment);
                return true;
            case R.id.navUser:
                fragment = new TaiKhoanFragment();
                toolbar.setTitle("Account");
                loadFragment(fragment);
                return true;
        }

        return false;
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        }

    }

