package com.wangshy.androiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.wangshy.androiddemo.adapter.MainAdapter;
import com.wangshy.androiddemo.broadcast.BroadcastActivity;
import com.wangshy.androiddemo.md.MDActivity;
import com.wangshy.androiddemo.view.MyViewActivity;
import com.wangshy.androiddemo.xfermode.XfermodeActivity;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getName();
    private RecyclerView mreycler;
    private MainAdapter mainAdapter;
    private Button search_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mreycler = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mreycler.setLayoutManager(linearLayoutManager);

        mreycler.setAdapter(new MainAdapter(Content.getList(Content.type.ACTIVITY))
                .setOn(new MainAdapter.IRecyclerView() {
                    @Override
                    public void onCheck(int position) {
                        toActivity(position);
                    }
                }));
    }

    private void toActivity(int position) {
        switch (position) {
            case 0:
                SecondActivity.SecondActivity(this);
                break;
            case 1:
                XfermodeActivity.XfermodeActivity(this);
                break;
            case 2:
                BroadcastActivity.actionStart(this);
                break;
            case 3:
                DataActivity.actionStart(this);
                break;
            case 4:
                MyViewActivity.actionStart(this);
                break;
            case 5:
                MDActivity.actionStart(this);
                break;
            case 6:
                PngActivity.actionStart(this);
                break;
            case 7:
                Image_CroppingActivity.actionStart(this);
                break;
        }
    }
}
