package com.example.amit.musicplayingusingservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void StartService(View view){
        Intent intent=new Intent(getApplicationContext(),MyService.class);
        startService(intent);
    }
    public void StopService(View view){
        Intent intent=new Intent(getApplicationContext(),MyService.class);
        stopService(intent);
    }
}
