package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private TextView numone;
    private TextView numtwo;
    private EditText input;

    public int correct = 0;
    public int count = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        numone = findViewById(R.id.input1);
        numtwo = findViewById(R.id.input2);
        input = findViewById(R.id.answer);

        int oone = randomInt();
        int ntwo = randomInt();

        numone.setText(String.valueOf(oone));
        numtwo.setText(String.valueOf(ntwo));

    }

    public int randomInt(){
        Random rn = new Random();
        return rn.nextInt(50);
    }

    public void assignVal(View view){
        if (count > 0) {

            String one = numone.getText().toString();
            String two = numtwo.getText().toString();
            int x = Integer.valueOf(one) + Integer.valueOf(two);

            count --;
            if (input.getText().toString().length() != 0){
                if (Integer.valueOf(input.getText().toString()) == x){
                    correct ++;
                }
                int new_one = randomInt();
                int new_two = randomInt();
                numone.setText(String.valueOf(new_one));
                numtwo.setText(String.valueOf(new_two));
                input.setText("");
            }


    }else{
            String print = "You got " + correct + " answer correct!";
            Toast.makeText(MainActivity.this, print,
                    Toast.LENGTH_LONG).show();

        }

    }
}