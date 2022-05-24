package com.ma.mafood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static boolean VALID_USER = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_area);

        //if (!VALID_USER) {
//            Intent intent = new Intent();
//            intent.setClass(this, TestingAreaActivity.class);
//            startActivity(intent);
        //}
    }
    public void gotoMainActivity(View v) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
    public void gotoLoginActivity(View v) {
        Intent it = new Intent(this, LoginActivity.class);
        startActivity(it);
    }
    public void gotoRegisterActivity(View v) {
        Intent it = new Intent(this, RegisterActivity.class);
        startActivity(it);
    }
    public void gotoStoreActivity(View v){
        Intent it = new Intent(this, StoreActivity.class);
        startActivity(it);
    }
    public void gotoHomeActivity(View v){
        Intent it = new Intent(this, HomeActivity.class);
        startActivity(it);
    }
    public void goBack(View v) {
        finish();
    }
}