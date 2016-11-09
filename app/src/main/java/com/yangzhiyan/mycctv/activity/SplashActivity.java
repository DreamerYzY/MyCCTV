package com.yangzhiyan.mycctv.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yangzhiyan.mycctv.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp = getSharedPreferences("firstkey", Context.MODE_PRIVATE);
        isFirst = sp.getBoolean("firstuse",true);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                if (isFirst){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("firstuse",false);
                    editor.commit();
                    intent.setClass(SplashActivity.this,GuideActivity.class);
                }else {
                    intent.setClass(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
                SplashActivity.this.finish();
            }
        },2000);

    }
}
