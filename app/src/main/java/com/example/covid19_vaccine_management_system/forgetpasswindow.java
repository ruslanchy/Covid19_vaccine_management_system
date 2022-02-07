package com.example.covid19_vaccine_management_system;

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
import com.google.firebase.auth.FirebaseAuth;

public class forgetpasswindow extends AppCompatActivity {
    EditText forgetemail;
    Button sendemail;
   // TextView goback;
    private FirebaseAuth mauth;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpasswindow);

        //hook
         mauth = FirebaseAuth.getInstance();
        forgetemail = (EditText)findViewById(R.id.emailet);
        sendemail = (Button)findViewById(R.id.sendlinkbtn);
       // goback = (TextView)findViewById(R.id.backtologinbtn);



        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremailforget = forgetemail.getText().toString().trim();
                if(useremailforget.isEmpty()){
                    Toast.makeText(forgetpasswindow.this,"Please enter email",Toast.LENGTH_SHORT).show();
                }else{
                    mauth.sendPasswordResetEmail(useremailforget).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(forgetpasswindow.this,"Email Sent!!!",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(forgetpasswindow.this,LoginMain.class));

                            }else{
                                //String message = task.getException().getMessage();
                                Toast.makeText(forgetpasswindow.this,"Error!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });




    }
}