package com.example.chapter_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){
       if(view.getId() == R.id.button1) {
           Intent intent = new Intent(this, TestActivity.class);
           startActivity(intent);
           overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
       }else if (view.getId() == R.id.button2) {
           Intent intent = new Intent(this, DemoActivity_1.class);
           startActivity(intent);
       } else if(view.getId() == R.id.button3){
           Intent intent = new Intent(this, DemoActivity_2.class);
           startActivity(intent);
       }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.d(TAG, "onWindowFocusChanged, focus:" + hasFocus);
        super.onWindowFocusChanged(hasFocus);
    }
}
