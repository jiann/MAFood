package com.ma.mafood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {
    public static boolean VALID_USER = false;
    private StorageReference productImageRef;
    private DatabaseReference sellerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_area);

        if (!VALID_USER) {
            Intent intent = new Intent();
            intent.setClass(this, RegisterActivity.class);
            startActivity(intent);
        }
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
    public void gotoProfileActivity(View v){
        Intent it = new Intent(this, ProfileActivity.class);
        startActivity(it);
    }

    public void goBack(View v) {
        finish();
    }


}