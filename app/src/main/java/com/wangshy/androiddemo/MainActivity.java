package com.wangshy.androiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wangshy.androiddemo.activity.SecondActivity;
import com.wangshy.androiddemo.activity.XfermodeActivity;
import com.wangshy.androiddemo.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getName();
    private RecyclerView mreycler;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mreycler = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mreycler.setLayoutManager(linearLayoutManager);
        mainAdapter = new MainAdapter(Content.getList());
        mreycler.setAdapter(mainAdapter);

        mainAdapter.setOn(new MainAdapter.IRecyclerView() {
            @Override
            public void onCheck(int position) {
                toActivity(position);
            }
        });
    }

    private void toActivity(int position) {
        switch (position) {
            case 0:
                SecondActivity.SecondActivity(this);
                break;
            case 1:
                XfermodeActivity.XfermodeActivity(this);
                break;
        }
    }
}
