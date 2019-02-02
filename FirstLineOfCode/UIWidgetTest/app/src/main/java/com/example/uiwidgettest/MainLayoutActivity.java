package com.example.uiwidgettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);

        button.setOnClickListener(this);

        // 事件监听方法1：匿名类
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainLayoutActivity.this, "You click this button", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    // 事件监听方法2：实现接口方法
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String inputText = editText.getText().toString();
                Toast.makeText(MainLayoutActivity.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
