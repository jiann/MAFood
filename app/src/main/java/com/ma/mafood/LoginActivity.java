package com.ma.mafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity
        implements OnCompleteListener<AuthResult> {

    private EditText etEmail;
    private EditText etPassword;
    FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onLogin(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, this);
    }

    public void onRegister(View view) {
        Intent intent = new Intent();
        intent.setClass(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show();
            MainActivity.VALID_USER = true;
            user = firebaseAuth.getCurrentUser();
            reference = FirebaseDatabase.getInstance().getReference("users");
            userID = user.getUid();

            reference.child(userID).child("identity").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>()
            {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, String.valueOf(task.getResult().getValue()), Toast.LENGTH_LONG).show();
                        if (String.valueOf(task.getResult().getValue()).matches("Buyer")){
                            jumpActivity(2);
                        }else if (String.valueOf(task.getResult().getValue()).matches("Seller")){
                            jumpActivity(1);
                        }else if (String.valueOf(task.getResult().getValue()).matches("Driver")){
                            jumpActivity(3);
                        }
                    }
                }
            });

        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show();
        }
    }
    private void jumpActivity(int i)
    {
        switch (i)
        {
            case 1:
                startActivity(new Intent(this, StoreActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, HomeActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, DriverActivity.class));
                break;
        }
    }
}