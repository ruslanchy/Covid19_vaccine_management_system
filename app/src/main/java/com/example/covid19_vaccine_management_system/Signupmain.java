package com.example.covid19_vaccine_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class Signupmain extends AppCompatActivity {
    private Button button;
    private Button button2;
    private EditText Signupusername, Signupuserpass, Signupuseremail, Signupuseradress, Signupuserage,Signupuservaccinecenter, Signupuserfirstdose, Signupuserseconddose;
    private EditText Signupusernumber;
    //private EditText Signuploginname;
    RadioGroup radioGroup;
    RadioButton radioButton;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupmain);
        button = (Button) findViewById(R.id.backbtnsignup);
        button2 = (Button) findViewById(R.id.signupbtnfromsignup);
        //int radioid = radioGroup.getCheckedRadioButtonId();
        //hooks
       // radioButton = (RadioButton)findViewById(radioid);
        //radioGroup = (RadioGroup)findViewById(R.id.Radiogender);
        Signupusername = (EditText) findViewById(R.id.Signupetname);
        Signupuserpass = (EditText) findViewById(R.id.Signupetpass);
        Signupuseremail = (EditText) findViewById(R.id.Signupetemail);
        Signupuseradress = (EditText) findViewById(R.id.Signupetadress);
        Signupuserage = (EditText) findViewById(R.id.Signupetage);
        Signupusernumber = (EditText) findViewById(R.id.Signupetphone);
       Signupuservaccinecenter = (EditText)findViewById(R.id.etcentername);
        Signupuserfirstdose = (EditText)findViewById(R.id.etfirstdose);
       Signupuserseconddose = (EditText)findViewById(R.id.etseconddose);
       // Signuploginname = (EditText)findViewById(R.id.Signupetloginname);





        //Signupusernumber = (EditText) findViewById(R.id.Signupetphone);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                //String usernumber1 = Signupusernumber.getText().toString();
                //Intent intent2 = new Intent(Signupmain.this,Checkotp.class);
                //intent2.putExtra("Numberuser",usernumber1);
                showotp();


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMainmenufromsignup();
            }
        });

    }

    public void showotp() {
    if (!validatefullname() | !validateadress() | !validateage() | !validateemail() | !validatenumber() | !validatepassword() | !validatevaccinecenter() | !validatefirstdose() |!validateseconddose() ) {
                    return;
                }

        rootNode=FirebaseDatabase.getInstance();
        reference =rootNode.getReference("users");
        FirebaseAuth firebaseAuth;
        //getting the values
        String name = Signupusername.getText().toString();
        String email = Signupuseremail.getText().toString();
        String password = Signupuserpass.getText().toString();
        //String gender = radioButton.getText().toString();
        String number = Signupusernumber.getText().toString();
        String adress = Signupuseradress.getText().toString();
        String age = Signupuserage.getText().toString();
       String vaccinecenter = Signupuservaccinecenter.getText().toString();
        String firstdose = Signupuserfirstdose.getText().toString();
       String seconddose = Signupuserseconddose.getText().toString();

        //  String loginname = Signuploginname.getText().toString();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            userhelperclass helperclass = new userhelperclass(name,email,password,number,adress,age,vaccinecenter,firstdose,seconddose);
                                    rootNode.getInstance().getReference("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(helperclass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Intent intent = new Intent(Signupmain.this,Main_menu.class);
                                            startActivity(intent);
                                            Toast.makeText(Signupmain.this,"Registration Success!!!",Toast.LENGTH_SHORT).show();
                                            userhelperclass helperclass = new userhelperclass(name,email,password,number,adress,age,vaccinecenter,firstdose,seconddose);

                                            reference.child(name).setValue(helperclass);
                                        }
                                    });
                        } else {
                            // If sign in fails, display a message to the user.

                        }
                    }
                });
        Intent intent = new Intent(Signupmain.this,Main_menu.class);
        startActivity(intent);
        Toast.makeText(Signupmain.this,"Registration Success!!!",Toast.LENGTH_SHORT).show();
        userhelperclass helperclass = new userhelperclass(name,email,password,number,adress,age,vaccinecenter,firstdose,seconddose);

        reference.child(name).setValue(helperclass);

       // PhoneAuthProvider.getInstance().verifyPhoneNumber(
               // "+88" + Signupusernumber.getText().toString(),
              //  60,
              //  TimeUnit.SECONDS,
             //   Signupmain.this,
             //   new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
              //      @Override
                //    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
////
                //    }

                 //   @Override
                 //   public void onVerificationFailed(@NonNull FirebaseException e) {

                //    }

                 //   @Override
                   //ublic void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                        //intent.putExtra("mobile",Signupusernumber.getText().toString());
                       //ntent.putExtra("backendotp",backendotp);

                    //
              //  }
       // );






        //  String _usernumber = Signupusernumber.getEditableText().toString().trim();
        //Intent intent2 = new Intent(Signupmain.this,Checkotp.class);
        //intent2.putExtra("UserNumber",_usernumber);
        //startActivity(intent2);
    }

    public void showMainmenufromsignup() {
        Intent intent = new Intent(Signupmain.this, Main_menu.class);
        startActivity(intent);
    }

    private boolean validatefullname() {
        String val = Signupusername.getText().toString().trim();
        if (val.isEmpty()) {
            Signupusername.setError("Field cannot be empty");
            return false;
        } else {
            Signupusername.setError(null);
            // Signupusername.setErrorEnabled(false);
            return true;

        }

    }

    private boolean validateemail() {
        String val = Signupuseremail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            Signupuseremail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            Signupuseremail.setError("Invalid email!!!");
            return false;
        } else {
            Signupuseremail.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;

        }

    }

    private boolean validatepassword() {
        String val = Signupuserpass.getText().toString().trim();
        //String checkPass = "^";
        if (val.isEmpty()) {
            Signupuserpass.setError("Field cannot be empty");
            return false;
        }/*else if(!val.matches(checkPass)){
            Signupuserpass.setError("Invalid email!!!");
            return false;
        }*/ else {
            Signupuserpass.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;

        }

    }

    private boolean validateage() {
        String val = Signupuserage.getText().toString().trim();
        //String checkPass = "^";
        if (val.isEmpty()) {
            Signupuserage.setError("Field cannot be empty");
            return false;
        }/*else if(!val.matches(checkPass)){
            Signupuserpass.setError("Invalid email!!!");
            return false;
        }*/ else {
            Signupuserage.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;

        }

    }

    private boolean validateadress() {
        String val = Signupuseradress.getText().toString().trim();
        //String checkPass = "^";
        if (val.isEmpty()) {
            Signupuseradress.setError("Field cannot be empty");
            return false;
        }/*else if(!val.matches(checkPass)){
            Signupuserpass.setError("Invalid email!!!");
            return false;
        }*/ else {
            Signupuseradress.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;

        }

    }

    private boolean validatenumber() {
        String val = Signupusernumber.getText().toString().trim();
        //String checkPass = "^";
        if (val.isEmpty()) {
            Signupusernumber.setError("Field cannot be empty");
            return false;
        }/*else if(!val.matches(checkPass)){
            Signupuserpass.setError("Invalid email!!!");
            return false;
        }*/ else {
            Signupusernumber.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;

        }

    }
 /*   private boolean validateloginname() {
        String val = Signuploginname.getText().toString().trim();
        //String checkPass = "^";
        if (val.isEmpty()) {
            Signuploginname.setError("Field cannot be empty");
            return false;
        }/*else if(!val.matches(checkPass)){
            Signupuserpass.setError("Invalid email!!!");
            return false;
        }*//* else {
            Signuploginname.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;
        }
    }*/
 private boolean validatevaccinecenter() {
     String val = Signupuservaccinecenter.getText().toString().trim();
     //String checkPass = "^";
     if (val.isEmpty()) {
         Signupuservaccinecenter.setError("Field cannot be empty");
         return false;
     } else {
         Signupuservaccinecenter.setError(null);
         //Signupusername.setErrorEnabled(false);
         return true;
     }
 };

    private boolean validatefirstdose() {
        String val = Signupuserfirstdose.getText().toString().trim();
        //String checkPass = "^";
        if (val.isEmpty()) {
            Signupuserfirstdose.setError("Field cannot be empty");
            return false;
        } else {
            Signupuserfirstdose.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;
        }
    };
    private boolean validateseconddose() {
        String val = Signupuserseconddose.getText().toString().trim();
        //String checkPass = "^";
        if (val.isEmpty()) {
            Signupuserseconddose.setError("Field cannot be empty");
            return false;
        } else {
            Signupuserseconddose.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;
        }
    };
}