package com.example.covid19_vaccine_management_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class adminsearch extends AppCompatActivity {
    private Button searchbtn,button1;
    private EditText usersearchname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsearch);
        //hooks
        searchbtn = (Button)findViewById(R.id.adminsearchbtn);
        usersearchname = (EditText)findViewById(R.id.etusernamesearch);
        button1 = (Button)findViewById(R.id.adminsrchexitbtn);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(adminsearch.this,adminmenu.class);
                startActivity(intent2);
            }
        });


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                admintheboss();
            }
        });


    }

    private void admintheboss() {
        String userername1 = usersearchname.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkusername1 = reference.orderByChild("name").equalTo(userername1);

        checkusername1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if(datasnapshot.exists()){
                    usersearchname.setError(null);
                    String usernamefromdb1  = datasnapshot.child(userername1).child("name").getValue(String.class);
                    if(usernamefromdb1.equals(userername1)){
                        usersearchname.setError(null);
                        String usernamefromdb = datasnapshot.child(userername1).child("name").getValue(String.class);
                        String useremailfromdb = datasnapshot.child(userername1).child("email").getValue(String.class);
                        String useragefromdb = datasnapshot.child(userername1).child("age").getValue(String.class);
                        String userphonefromdb = datasnapshot.child(userername1).child("number").getValue(String.class);
                        String userfirstdosefromdb = datasnapshot.child(userername1).child("firstdose").getValue(String.class);
                        String userseconddosefromdb = datasnapshot.child(userername1).child("seconddose").getValue(String.class);
                        String uservaccinecenterfromdb = datasnapshot.child(userername1).child("vaccinecenter").getValue(String.class);
                        Intent intent1 = new Intent(adminsearch.this,Adminedit.class);

                        intent1.putExtra("name",usernamefromdb);
                        intent1.putExtra("email",useremailfromdb);
                        intent1.putExtra("age",useragefromdb);
                        intent1.putExtra("number",userphonefromdb);
                        intent1.putExtra("firstdose",userfirstdosefromdb);
                        intent1.putExtra("seconddose",userseconddosefromdb);
                        intent1.putExtra("vaccinecenter",uservaccinecenterfromdb);
                        startActivity(intent1);


                    }else{
                        usersearchname.setError("invalid name");
                       // usersearchname.requestFocus();
                    }
                }else{
                    usersearchname.setError("invalid name");
                    // usersearchname.requestFocus();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}