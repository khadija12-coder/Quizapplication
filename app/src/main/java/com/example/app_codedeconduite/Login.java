package com.example.app_codedeconduite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    // Declaration

    EditText etpLogin,etpPassword;
    Button bLogin;
    TextView tvRegister;
     FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // Step 2 : Recuperation des ids
        fAuth = FirebaseAuth.getInstance();
        etpLogin=(EditText) findViewById(R.id.etLogin);
        etpPassword=(EditText) findViewById(R.id.etPassword);
        bLogin=(Button) findViewById(R.id.bLogin);
        tvRegister=(TextView) findViewById(R.id.tvRegister);


        // Step 3 : Assoctiation Listeners

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =etpLogin.getText().toString().trim();
                String password =etpPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    etpLogin.setError("Email is Required");

                }
                if(TextUtils.isEmpty(password)){
                    etpPassword.setError("Password is Required");
                }
              if(password.length()<6){
                  etpPassword.setError("Password must be >= characters");
              }
              fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          Toast.makeText(Login.this,"Logged is Successfully",Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(Login.this,Quiz1.class));
                      }
                      else{
                          Toast.makeText(Login.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                      }
                  }
              });

            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });




      }





    }
