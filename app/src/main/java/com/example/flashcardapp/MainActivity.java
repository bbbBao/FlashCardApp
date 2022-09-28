package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private TextView numone;
    private TextView numtwo;
    private EditText input;
    private TextView signView;



    public int correct = 0;
    public int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

    }

    public int randomInt(int min, int max){
        Random rn = new Random();
        return rn.nextInt(max - min) + min;
    }

    public void generateSign(){
        int sign = randomInt(0, 2);
        signView = findViewById(R.id.signView);
        if (sign == 0){
            signView.setText("+");

        } else {
            signView.setText("-");

        }
    }

    public void generateTen(View view){
        Button button = findViewById(R.id.generate);
        count = 10;
        correct = 0;


        numone = findViewById(R.id.input1);
        numtwo = findViewById(R.id.input2);
        input = findViewById(R.id.answer);

        int oone = randomInt(1, 100);
        int ntwo = randomInt(1, 21);

        numone.setText(String.valueOf(oone));
        numtwo.setText(String.valueOf(ntwo));

        generateSign();
        button.setEnabled(false);
    }




    public void assignVal(View view){
        Button button = findViewById(R.id.generate);
        if (count > 0) {

            String one = numone.getText().toString();
            String two = numtwo.getText().toString();
            int x = 0;

            if (signView.getText().toString().equals("+")) {
                x = Integer.valueOf(one) + Integer.valueOf(two);
            } else{
                x = Integer.valueOf(one) - Integer.valueOf(two);
            }

            count --;
            if (input.getText().toString().length() != 0){
                if (Integer.valueOf(input.getText().toString()) == x){
                    correct ++;
                }
                int new_one = randomInt(1, 100);
                int new_two = randomInt(1, 21);
                numone.setText(String.valueOf(new_one));
                numtwo.setText(String.valueOf(new_two));
                input.setText("");

                generateSign();

            } else{
                String print = "Answer can't be empty!";
                Toast.makeText(MainActivity.this, print,
                        Toast.LENGTH_LONG).show();
            }


    }else{
            String print = correct + " out of 10";
            Toast.makeText(MainActivity.this, print,
                    Toast.LENGTH_LONG).show();
            button.setEnabled(true);

        }

    }
}