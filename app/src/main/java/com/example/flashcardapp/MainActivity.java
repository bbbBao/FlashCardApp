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

    private static final String KEY_INPUT1 = "INPUT1";
    private static final String KEY_INPUT2 = "INPUT2";
    private static final String KEY_SIGN = "INPUT3";
    private static final String KEY_CORRECT = "CORRECT";
    private static final String KEY_COUNT = "COUNT";
    private static final String KEY_STATE = "STATE";
    private static final String KEY_ANSWER = "ANSWER";


    public int correct = 0;
    public int count = 10;
    public boolean generateState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numone = findViewById(R.id.input1);
        numtwo = findViewById(R.id.input2);
        signView = findViewById(R.id.signView);
        input = findViewById(R.id.answer);
        Button button = findViewById(R.id.generate);


        if (savedInstanceState != null) {
            CharSequence savedInput1 = savedInstanceState.getCharSequence(KEY_INPUT1);
            numone.setText(savedInput1);

            CharSequence savedInput2 = savedInstanceState.getCharSequence(KEY_INPUT2);
            numtwo.setText(savedInput2);

            CharSequence savedSign = savedInstanceState.getCharSequence(KEY_SIGN);
            signView.setText(savedSign);

            int savedCorrect = savedInstanceState.getInt(KEY_CORRECT);
            correct = savedCorrect;

            int savedCount = savedInstanceState.getInt(KEY_COUNT);
            count = savedCount;

            generateState = savedInstanceState.getBoolean(KEY_STATE);
            button.setEnabled(generateState);

            CharSequence savedInput = savedInstanceState.getCharSequence(KEY_ANSWER);
            input.setText(savedInput);
        }

    }

    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putCharSequence(KEY_INPUT1, numone.getText());
        savedInstanceState.putCharSequence(KEY_INPUT2, numtwo.getText());
        savedInstanceState.putCharSequence(KEY_SIGN, signView.getText());
        savedInstanceState.putInt(KEY_CORRECT, correct);
        savedInstanceState.putInt(KEY_COUNT, count);
        savedInstanceState.putBoolean(KEY_STATE, generateState);
        savedInstanceState.putCharSequence(KEY_ANSWER, input.getText());
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
        generateState = false;
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
            generateState = true;

        }

    }
}