package com.example.nguyenvancong_1706020007;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText tname,tpass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    public void init() {
        tname = (EditText)findViewById(R.id.edtname);
        tpass = (EditText)findViewById(R.id.edtpass);
        login = (Button)findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname = tname.getText().toString();
                String spass = tpass.getText().toString();

                if (sname.equals("1706020007") && spass.equals("123456"))
                {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công !", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(in);
                }
                else if (sname.equals("") || spass.equals(""))
                {
                    Toast.makeText(getBaseContext(),"Vui lòng nhập đủ tên đăng nhập & pass",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Sai tên đăng nhập hoặc pass",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
