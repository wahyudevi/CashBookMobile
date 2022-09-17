package com.example.cashbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class Pengaturan extends AppCompatActivity implements View.OnClickListener {
    private static final String MY_PREFS_NAME = "MyPreferences";
    Button simpan_password, kembali;
    EditText passwordBaru, passwordSekarang;
    DBHelper DB;
    String password;

    TextView text_ganti_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);
        DB = new DBHelper(this);

        text_ganti_password = findViewById(R.id.text_gantipassword);
        text_ganti_password.setPaintFlags(text_ganti_password.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        passwordBaru = findViewById(R.id.passwordBaru);
        passwordSekarang = findViewById(R.id.passwordSekarang);
        simpan_password = findViewById(R.id.simpan_password);
        kembali = findViewById(R.id.kembali);

        SharedPreferences preferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        password = preferences.getString("password", "user");

        simpan_password.setOnClickListener(this);
        kembali.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.simpan_password :
                if (passwordSekarang.getText().toString().equals(password)) {
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putString("username", "user");
                    editor.putString("password", passwordBaru.getText().toString());
                    editor.apply();
                    Toast.makeText(getBaseContext(), "Password berhasil diubah!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), "Password tidak sama!", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.kembali :
                i = new Intent(this, HomeActivity.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}