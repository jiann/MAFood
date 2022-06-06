package com.ma.mafood;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity
        implements OnCompleteListener {

    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhone;
    Spinner spinnerRegister;
    String identity = "none";

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etPhone = findViewById(R.id.et_phone);
        spinnerRegister = findViewById(R.id.spinner_register);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onRegister(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, this);
    }

    public void onCancel(View view) {
        finish();
    }


    @Override
    public void onComplete(@NonNull Task task) {
        if (task.isSuccessful()) {
            Toast.makeText(this, "註冊成功", Toast.LENGTH_LONG).show();
            addUser();
            finish();
        } else {
            Toast.makeText(this, "註冊失敗", Toast.LENGTH_LONG).show();
        }
    }

    private void addUser() {
        String[] identity_temp = getResources().getStringArray(R.array.identify);
        int index = spinnerRegister.getSelectedItemPosition();
        identity = identity_temp[index];

        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = firebaseDatabase.getReference("users");
        DatabaseReference phoneRef = usersRef.child(phone);
        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("phone", phone);
        phoneRef.updateChildren(user);
    }
}
