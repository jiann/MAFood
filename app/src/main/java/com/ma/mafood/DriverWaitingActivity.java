package com.ma.mafood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DriverWaitingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_waiting);
    }
    public void gotoDriverProfile(View v){
        Intent it = new Intent(this, DriverActivity.class);
        startActivity(it);
    }
}