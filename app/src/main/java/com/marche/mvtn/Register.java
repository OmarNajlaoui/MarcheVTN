package com.marche.mvtn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private static final String TAG ="emailetPassword" ;
    private static final String TAG2 ="DataInsert" ;
    private FirebaseAuth mAuth;
    public   FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText name = findViewById(R.id.name);
        final EditText local = findViewById(R.id.local);
        final EditText tel = findViewById(R.id.tel);
        final EditText email = findViewById(R.id.email);
        final EditText mdp = findViewById(R.id.mdp);
        final EditText cmfmdp =findViewById(R.id.cmfmdp);
        final Button register_btn = findViewById(R.id.register_btn);
        final TextView login = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();

        db = FirebaseFirestore.getInstance();
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nameTxt = name.getText().toString();
                final String localTxt = local.getText().toString();
                final String telTxt = tel.getText().toString();
                final String emailtxt = email.getText().toString();
                final String mdpTxt = mdp.getText().toString();
                final String cmdpTxt= cmfmdp.getText().toString();
                 String Uid= "";

                if(nameTxt.isEmpty()||localTxt.isEmpty()||telTxt.isEmpty()||emailtxt.isEmpty()||mdpTxt.isEmpty()||cmdpTxt.isEmpty()){
                    Toast.makeText(Register.this,"svp rmeplir tt les champs",Toast.LENGTH_SHORT);

                }
                else if(!(mdpTxt.equals(cmdpTxt))){
                    Toast.makeText(Register.this,"Les mdps sont pas KIF KIF !",Toast.LENGTH_SHORT);

                }
                else {
                    Map<String,Object> userdata = new HashMap<>();
                    Uid = mAuth.getCurrentUser().getUid();

                    userdata.put("Email",emailtxt);userdata.put("Local",localTxt);userdata.put("Nom",nameTxt);userdata.put("Password",mdpTxt);userdata.put("Phone",telTxt);
                    registerUsr(emailtxt,mdpTxt,userdata);








                   /* Log.d(TAG2,userdata.toString());
                    CollectionReference reference = db.collection("USERS");
                    reference.document(Uid).set(userdata);
                    db.collection("USERS").document(Uid).set(userdata).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG2, "DocumentSnapshot successfully written!");
                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG2, "Error writing document", e);
                                }
                            });*/

                }
            }
        });

    }

    private void registerUsr(String emailtxt,String mdpTxt,Map map) {
        mAuth.createUserWithEmailAndPassword(emailtxt,mdpTxt).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(Register.this,"Matahbé bik fil marché",Toast.LENGTH_SHORT);
                map.put("Uid",authResult.getUser().getUid());
                CollectionReference reference = db.collection("USERS");
                reference.document(authResult.getUser().getUid()).set(map);
                Intent intent = new Intent(Register.this,MainActivity.class);
               startActivity(intent);
                finish();



            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register.this,"Thama Erreur 3awed",Toast.LENGTH_SHORT);

            }
        });



    }
}