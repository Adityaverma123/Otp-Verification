package com.example.ml_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PlacesActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    TextView name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        if(user!=null){
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(user==null){
            startActivity(new Intent(PlacesActivity.this,SignActivity.class));
            finish();
        }
    }
}