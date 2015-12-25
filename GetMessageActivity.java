package com.jikexueyuan.getsetmessage;

/**
 * 作业要求：
 * 启动一个Activity用于输入信息并获取其返回值和返回状态
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GetMessageActivity extends AppCompatActivity implements View.OnClickListener {

    //声明
    private Button btnGetMessage;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_message);
        //查找
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        btnGetMessage = (Button) findViewById(R.id.btnGetMessage);

        btnGetMessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGetMessage:
                //启动另一个Activity
                Intent i = new Intent(GetMessageActivity.this, SetMessageActivity.class);
                startActivityForResult(i, 0);
            break;
        }
    }

    //获取返回值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //接收确定消息
        if (resultCode == 1) {
            try {
                tvMessage.setText("今日工作计划是：" + data.getStringExtra("data"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //接收取消消息
        if (resultCode == 2) {
            Toast.makeText(GetMessageActivity.this
                    , "已取消计划"
                    , Toast.LENGTH_SHORT).show();
            tvMessage.setText("");
        }

    }
}
