package com.wangshy.androiddemo.xfermode;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Xfermode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wangshy.androiddemo.R;

public class XfermodeActivity extends AppCompatActivity {
    public static void XfermodeActivity(Context context) {
        context.startActivity(new Intent(context, XfermodeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xfermode);
    }
}
