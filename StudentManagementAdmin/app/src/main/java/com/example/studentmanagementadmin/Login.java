package com.example.studentmanagementadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText userEmail, userPassword;
    private TextView tvShow;
    private RelativeLayout loginBtn;

    private String email, password;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("isLogin","false").equals("yes")){
            openDash();
        }

        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        loginBtn = findViewById(R.id.login_btn);
        tvShow = findViewById(R.id.show_password);

        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userPassword.getInputType() == 144){
                    userPassword.setInputType(129);
                    tvShow.setText("Show");
                }else {
                    userPassword.setInputType(144);
                    tvShow.setText("Hide");
                }
                userPassword.setSelection(userPassword.getText().length());
            }

        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

    }

    private void validateData() {
        email = userEmail.getText().toString();
        password = userPassword.getText().toString();

        if (email.isEmpty()){
            userEmail.setError("Empty");
            userEmail.requestFocus();
        }else if (password.isEmpty()){
            userPassword.setError("Empty");
            userPassword.requestFocus();
        }else if (email.equals("Admin@tpi.com") && password.equals("Admin@TpiPassword")){
            editor.putString("isLogin","yes");
            editor.commit();
            openDash();
        }else {
            Toast.makeText(this, "Please check User ID & Password again", Toast.LENGTH_LONG).show();
        }
    }

    private void openDash() {
        startActivity(new Intent(Login.this, MainActivity.class));
        finish();
    }
}