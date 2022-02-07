package com.example.covid19_vaccine_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Otpverification extends AppCompatActivity {
    EditText otpnumber1,otpnumber2,otpnumber3,otpnumber4,otpnumber5,otpnumber6;
    Button backbutton,submitbutton;
    TextView mobilenumberforotp;
    String getotpbackend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        otpnumber1 = (EditText)findViewById(R.id.otpbox1);
        otpnumber2 = (EditText)findViewById(R.id.otpbox2);
        otpnumber3 = (EditText)findViewById(R.id.otpbox3);
        otpnumber4 = (EditText)findViewById(R.id.otpbox4);
        otpnumber5 = (EditText)findViewById(R.id.otpbox5);
        otpnumber6 = (EditText)findViewById(R.id.otpbox6);
        backbutton = (Button)findViewById(R.id.otpbackbtn);
        final Button submitbutton = findViewById(R.id.otpsubmitbtn);
        getotpbackend = getIntent().getStringExtra("backendotp");
       final ProgressBar progressbartoverifyotp =(ProgressBar)findViewById(R.id.progressbarverifyotp);

        mobilenumberforotp = (TextView)findViewById(R.id.phonenumber);
        mobilenumberforotp.setText(String.format(
                "+88-%s",getIntent().getStringExtra("mobile")
        ));

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!otpnumber1.getText().toString().trim().isEmpty() &&!otpnumber2.getText().toString().trim().isEmpty() && !otpnumber3.getText().toString().trim().isEmpty() && !otpnumber4.getText().toString().trim().isEmpty() && !otpnumber5.getText().toString().trim().isEmpty() && !otpnumber6.getText().toString().trim().isEmpty()){
                    String entercodeotp= otpnumber1.getText().toString()+otpnumber2.getText().toString()+otpnumber3.getText().toString()+otpnumber4.getText().toString()+otpnumber5.getText().toString()+otpnumber6.getText().toString();
                    if(getotpbackend!=null){
                        progressbartoverifyotp.setVisibility(View.VISIBLE);
                        submitbutton.setVisibility(View.INVISIBLE);

                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(getotpbackend,entercodeotp);

                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressbartoverifyotp.setVisibility(View.GONE);
                                submitbutton.setVisibility(View.VISIBLE);
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(getApplicationContext(),Main_menu.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(Otpverification.this,"Invalid OTP",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                    }

                    //Toast.makeText(Otpverification.this,"Verified",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Otpverification.this,"INVALID OTP",Toast.LENGTH_SHORT).show();
                }
            }
        });

        otpnumbermove();
        TextView resendlabel = findViewById(R.id.textresendotp);
        resendlabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+88" + getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        Otpverification.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                            }

                            @Override
                            public void onCodeSent(@NonNull String newbackendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                               getotpbackend = newbackendotp;
                               Toast.makeText(Otpverification.this,"Send again successful!!",Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }
        });

    }

    private void otpnumbermove() {
        otpnumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    otpnumber2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpnumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    otpnumber3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpnumber3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    otpnumber4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpnumber4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    otpnumber5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpnumber5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    otpnumber6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}