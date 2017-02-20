package com.wangshy.androiddemo.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wangshy.androiddemo.R;

public class MyViewActivity extends AppCompatActivity {
    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, MyViewActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
    }
}
