package com.example.modile_main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import okhttp.ok.ApiWrapperUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        try {
            ApiWrapperUtils.getmApiWrapperUtils().getUserInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
