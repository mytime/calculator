package com.jikexueyuan.getsetmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetMessageActivity extends AppCompatActivity implements View.OnClickListener {

    //声明
    private EditText etMessage;
    private Intent intent;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_message);

        //查找
        btnSave = (Button) findViewById(R.id.btnSave);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        etMessage = (EditText) findViewById(R.id.etMessage);

        intent = new Intent();

        //监听器
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                intent.putExtra("data", etMessage.getText().toString());
                setResult(1, intent);
                break;
            case R.id.btnCancel:
                setResult(2, intent);
                break;
        }
        finish();
    }
}
