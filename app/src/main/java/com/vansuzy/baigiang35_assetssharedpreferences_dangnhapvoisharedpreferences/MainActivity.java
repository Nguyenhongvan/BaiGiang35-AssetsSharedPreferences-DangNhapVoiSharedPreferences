package com.vansuzy.baigiang35_assetssharedpreferences_dangnhapvoisharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtUsername, txtPassword;
    CheckBox chkLuuThongTin;
    Button btnDangNhap, btnThoat;

    String tenThongTinDangNhap = "login";   // file xml được tự động tạo ra

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    private void addControls() {
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        chkLuuThongTin = (CheckBox) findViewById(R.id.chkLuuThongTin);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        btnThoat = (Button) findViewById(R.id.btnThoat);
    }

    // onPause(): dùng để lưu trạng thái (vì onPause() là bắt đầu tắt phần mềm)
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getSharedPreferences(tenThongTinDangNhap, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Username", txtUsername.getText().toString());
        editor.putString("Password", txtPassword.getText().toString());
        editor.putBoolean("SAVE", chkLuuThongTin.isChecked());
        editor.commit();
    }

    // onResume(): phục hồi trạng thái (vì onResume() là bắt đầu hiển thị lại phần mềm)

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(tenThongTinDangNhap, MODE_PRIVATE);
        String username = preferences.getString("Username", "");
        String password = preferences.getString("Password", "");
        boolean save = preferences.getBoolean("SAVE", false);
        if (save) {
            txtUsername.setText(username);
            txtPassword.setText(password);
        }
    }
}
