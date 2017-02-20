package com.wangshy.androiddemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DataActivity extends AppCompatActivity {
    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, DataActivity.class));
    }

    StringBuffer buffer = new StringBuffer();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        editText = (EditText) findViewById(R.id.edit_query);
    }

    public void commit(View view) {
        save();
    }

    /**
     * 读取数据
     */
    @Override
    protected void onResume() {
        super.onResume();
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = openFileInput("data");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = bufferedReader.readLine()) != null)
                buffer.append(line);

            Log.e("---------", "------" + buffer.toString());
            if (!TextUtils.isEmpty(buffer.toString())) {
                editText.setText(buffer.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * 存储数据
     */
    public void save() {
        String data = editText.getText().toString().trim();
        FileOutputStream outputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = openFileOutput("data", Context.MODE_PRIVATE);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
