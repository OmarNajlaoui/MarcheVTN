package com.marche.mvtn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText email = findViewById(R.id.email);
        final  EditText mdp = findViewById(R.id.mdp);
        final Button login_btn = findViewById(R.id.login_btn);
        final TextView register = findViewById(R.id.register);
        login_btn.setBackgroundColor(Color.WHITE);
        mAuth = FirebaseAuth.getInstance();
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String email_text = email.getText().toString();
                final  String password = mdp.getText().toString();
                if (email_text.isEmpty()||password.isEmpty()){
                    Toast.makeText(Login.this,"het mot de pass s7i7 3ad ",Toast.LENGTH_SHORT).show();

                }else {
                    login(email_text,password);


                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });

    }

    private void login(String email_text, String password) {
        mAuth.signInWithEmailAndPassword(email_text,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(Login.this,"MaraHbé bik Fil Marché ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this,"Zid thabet ",Toast.LENGTH_SHORT).show();

            }
        });
    }
}