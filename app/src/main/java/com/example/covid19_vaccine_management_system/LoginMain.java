package com.example.covid19_vaccine_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginMain extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private EditText usermail, userpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        //hooks
        usermail=(EditText)findViewById(R.id.etloginemail);
        userpass= (EditText)findViewById(R.id.etloginpass);
        button = (Button)findViewById(R.id.loginbackbtn);
        button2 = (Button)findViewById(R.id.Loginbtntosign);
        button3 = (Button)findViewById(R.id.loginbtn);
        button4 = (Button)findViewById(R.id.forgotpassbtn);
        button5 = (Button)findViewById(R.id.adminbtnlogin);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(LoginMain.this,adminloginscn.class);
                startActivity(intent6);
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(LoginMain.this,forgetpasswindow.class);
                startActivity(intent5);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensigninfromlogin();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainmenu();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //isUser();
                loginuser();
            }
        });
    }
    public void openMainmenu(){
        Intent intent = new Intent(LoginMain.this,Main_menu.class);
        startActivity(intent);
    }
    public void opensigninfromlogin(){
        Intent intent2 = new Intent(LoginMain.this,Signupmain.class);
        startActivity(intent2);
    }
    private boolean validateusermaillogin(){
        String val = usermail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            usermail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            usermail.setError("Invalid email!!!");
            return false;
        } else {
            usermail.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;

        }
    }
    private boolean validateuserpasslogin(){
        String val = userpass.getText().toString().trim();
        //String checkPass = "^";
        if (val.isEmpty()) {
            userpass.setError("Field cannot be empty");
            return false;
        }/*else if(!val.matches(checkPass)){
            Signupuserpass.setError("Invalid email!!!");
            return false;
        }*/ else {
            userpass.setError(null);
            //Signupusername.setErrorEnabled(false);
            return true;

        }

    }
    public void loginuser(){
        
        isUser();



    }

    private void isUser() {
        String userenteredemail = usermail.getText().toString();
        String userenteredpass = userpass.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkusermail = reference.orderByChild("name").equalTo(userenteredemail);

        checkusermail.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists()){
                    usermail.setError(null);
                    //usermail.setErrorEnabled(false);
                    String passwordfromdb = datasnapshot.child(userenteredemail).child("password").getValue(String.class);

                    if(passwordfromdb.equals(userenteredpass)){
                        usermail.setError(null);
                       // String passwordfromdb = datasnapshot.child(userenteredemail).child("email").getValue(String.class);
                        String namefromdb = datasnapshot.child(userenteredemail).child("name").getValue(String.class);
                        String agefromdb = datasnapshot.child(userenteredemail).child("age").getValue(String.class);
                        String adressfromdb = datasnapshot.child(userenteredemail).child("adress").getValue(String.class);
                        String emailfromdb = datasnapshot.child(userenteredemail).child("email").getValue(String.class);
                        String numberfromdb = datasnapshot.child(userenteredemail).child("number").getValue(String.class);
                        String firstvaccinedatefromdb = datasnapshot.child(userenteredemail).child("firstdose").getValue(String.class);
                        String secondvaccinedatefromdb = datasnapshot.child(userenteredemail).child("seconddose").getValue(String.class);
                        String vaccinecenterfromdb = datasnapshot.child(userenteredemail).child("vaccinecenter").getValue(String.class);
                       Intent intent = new Intent(getApplicationContext(),Maindashboard.class);
                       intent.putExtra("name",namefromdb);
                        intent.putExtra("age",agefromdb);
                        intent.putExtra("adress",adressfromdb);
                        intent.putExtra("email",emailfromdb);
                        intent.putExtra("number",numberfromdb);
                        intent.putExtra("firstdose",firstvaccinedatefromdb);
                        intent.putExtra("seconddose",secondvaccinedatefromdb);
                        intent.putExtra("vaccinecenter",vaccinecenterfromdb);



                       startActivity(intent);
                        //Toast.makeText(LoginMain.this,"Done with active",Toast.LENGTH_SHORT).show();



                    }else{
                        userpass.setError("INVALID PASSWORD");
                        userpass.requestFocus();
                    }
                }else{
                    usermail.setError("INVALID USERNAME");
                    usermail.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}