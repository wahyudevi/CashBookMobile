package com.example.cashbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "MyPreferences";
    EditText username, password;
    Button login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
//        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String user = username.getText().toString();
//                String pass = password.getText().toString();
//
//                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
//                    Toast.makeText(MainActivity.this, "Isi Username dan Password", Toast.LENGTH_SHORT).show();
//                }else {
//                    Boolean checkLogin = DB.checkLogin(user, pass);
//                    if(checkLogin == true) {
//                        Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                        startActivity(intent);
//                    }else {
//                        Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
//                    }
//                }

                String usernameLog = username.getText().toString();
                String passwordLog = password.getText().toString();

                SharedPreferences preferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                String prefsUsername = preferences.getString("username", "user");
                String prefsPassword = preferences.getString("password", "user");

                if (usernameLog.equals(prefsUsername) && passwordLog.equals(prefsPassword)) {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(getBaseContext(), "Username atau password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}