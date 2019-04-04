package com.example.thicuoiky_de2;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    CheckBox cbRemember;
    EditText edtusename;
    EditText edtmk;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String USERNAME = "userNameKey";
    public static final String PASS = "passKey";
    public static final String REMEMBER = "remember";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);

        btn_login= findViewById(R.id.btntdangnhap);
        cbRemember = findViewById(R.id.chec_kbox);
        edtusename = findViewById(R.id.login_edt_username);
        edtmk = findViewById(R.id.login_edt_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangnhap();
            }
        });


        loadData();


    }
    private void clearData() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }

    private void saveData(String username, String Pass) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USERNAME, username);
        editor.putString(PASS, Pass);
        editor.putBoolean(REMEMBER,cbRemember.isChecked());
        editor.commit();
    }

    private void loadData() {
        if(sharedpreferences.getBoolean(REMEMBER,false)) {
            edtusename.setText(sharedpreferences.getString(USERNAME, ""));
            edtmk.setText(sharedpreferences.getString(PASS, ""));
            cbRemember.setChecked(true);
            startActivity(new Intent(MainActivity.this,Main2Activity.class));

        }
        else
            cbRemember.setChecked(false);

    }
    public void dangnhap() {

        String user =edtusename.getText().toString();
        String pas =  edtmk.getText().toString();
        if (!user.equals("admin")|| !pas.equals("admin"))
        {
            Toast.makeText(this, "Tên tài khoản hoặc mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
        } else if (user.isEmpty() ||pas.isEmpty())
        {
            Toast.makeText(this, "vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(MainActivity.this,Main2Activity.class));
        }
        if (cbRemember.isChecked())
            //lưu lại thông tin đăng nhập
            saveData(edtusename.getText().toString(), edtmk.getText().toString());
        else
            clearData();

    }

}
