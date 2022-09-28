package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private String username = "test";
    private String password = "test";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /** Called when the user taps the Send button */
    public void login(View view) {
        EditText user = findViewById(R.id.user);
        EditText pass = findViewById(R.id.password);
        Intent intent = new Intent(this, MainActivity.class);
        if (user.getText().toString().equals(username) && pass.getText().toString().equals(password)) {
            startActivity(intent);
        } else{
            String print = "Incorrect Username or Password!";
            Toast.makeText(LoginActivity.this, print,
                    Toast.LENGTH_LONG).show();
        }
    }

}