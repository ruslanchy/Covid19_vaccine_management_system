package com.example.covid19_vaccine_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int screenTime= 4000;
    Animation topAnim, botAnim;
    ImageView logo1;
    TextView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);


        logo1= findViewById(R.id.LOGO1);
        banner= findViewById(R.id.LOGO);

        logo1.setAnimation(topAnim);
        banner.setAnimation(botAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Main_menu.class);
                startActivity(intent);
                finish();
            }
        },screenTime);
    }
}