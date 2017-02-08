package com.wangshy.androiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.wangshy.androiddemo.activity.SecondActivity;
import com.wangshy.androiddemo.adapter.MainAdapter;
import com.wangshy.androiddemo.implement.IRecyclerView;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getName();
    private RecyclerView mreycler;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SecondActivity.SecondActivity(this);
        mreycler = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mreycler.setLayoutManager(linearLayoutManager);
        mainAdapter = new MainAdapter(Content.getList());
        mreycler.setAdapter(mainAdapter);
        mainAdapter.setOn(new IRecyclerView() {
            @Override
            public void onCheck(int position) {
                Log.e(TAG,"------"+position);
            }
        });
    }
}
