package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button button2;
    Button button4;

    CheckBox checkBox;
    ProgressBar progressBar;
    TextView progressBarTextView;

    EditText editText;
    EditText editText2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //登录界面
        setContentView(R.layout.activity_login);

        button2 = (Button) findViewById(R.id.button2);
        button4 = (Button) findViewById(R.id.button4);

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        button2.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button2:
                String name = editText.getText().toString();
                String password = editText2.getText().toString();

                if(name.equals("")){
                    Toast.makeText(MainActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals("")){
                    Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (name.equals("cc") && password.equals("123")) {
                        if (checkBox.isChecked()) {
                            //Activity跳转
                            Intent intent = new Intent(MainActivity.this, loginActivity.class);
                            startActivity(intent);
                            //关闭自身
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "请勾选同意协议", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "账号密码错误,请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.button4:
                new AlertDialog.Builder(this)
                        .setTitle("请选择注册方式")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setItems(new String[]{"普通注册", "人脸注册"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case 1:
                                        Intent intent = new Intent(MainActivity.this, Main1Activity.class);
                                        startActivity(intent);
                                        break;
                                    case 0:
                                        Toast.makeText(MainActivity.this,"注册失败 = =",Toast.LENGTH_SHORT).show();
                                        break;
                                    default:;
                                }
                            }
                        })
                        .show();
                break;

        }

    }

}
