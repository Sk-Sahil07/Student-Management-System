package com.example.tpiuserapp.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpiuserapp.MainActivity;
import com.example.tpiuserapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText regName, regEmail, regPassword;
    private Button reg_btn;
    private String name, email, password;
    private FirebaseAuth auth;
    private TextView openLog;

    private DatabaseReference reference;
    private DatabaseReference DbRef;
    private ProgressDialog pd;

    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser() != null){
            openMain();
        }
    }

    private void openMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        pd = new ProgressDialog(this);

        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        regName = findViewById(R.id.reg_user_name);
        regEmail = findViewById(R.id.reg_user_email);
        regPassword = findViewById(R.id.reg_user_password);
        reg_btn = findViewById(R.id.Reg_btn);
        openLog = findViewById(R.id.openLog);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

        openLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

    }

    private void openLogin() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }

    private void validateData() {
       name = regName.getText().toString();
       email = regEmail.getText().toString();
       password = regPassword.getText().toString();

       if (name.isEmpty()){
           regName.setError("Required");
           regName.requestFocus();
       }else if (email.isEmpty()) {
           regEmail.setError("Required");
           regEmail.requestFocus();
       }else if (password.isEmpty()) {
           regPassword.setError("Required");
           regPassword.requestFocus();
       }else {
           createUser();
       }
    }

    private void createUser() {
        pd.setTitle("please wait...");
        pd.setMessage("Account creating...");
        pd.show();
       auth.createUserWithEmailAndPassword(email, password)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                         uploadData();
                       }else {
                           Toast.makeText(RegisterActivity.this, "Error :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   }
               }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               pd.dismiss();
               Toast.makeText(RegisterActivity.this, "Error :"+e.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
    }

    private void uploadData() {
        DbRef = reference.child("users");
        String key = DbRef.push().getKey();


        HashMap<String, String> user = new HashMap<>();
        user.put("key", key);
        user.put("name",name);
        user.put("email",email);

        DbRef.child(key).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Account created", Toast.LENGTH_SHORT).show();
                            openMain();
                        }else{
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}