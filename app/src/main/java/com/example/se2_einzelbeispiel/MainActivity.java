package com.example.se2_einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button buttonCalculate;
    TextView calculateAnswer;
    EditText editText;


    public static final String EXTRA_MESSAGE = "com.example.SE2_Einzelbeispiel.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculate=findViewById(R.id.button2);
        calculateAnswer=findViewById(R.id.calculateAnswer);



        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.editTextNumber);
                String input = editText.getText().toString();
                String output = calculate(input);
                calculateAnswer.setText(output);
            }
        });
    }

    public String calculate(String s){
        ArrayList arrayList=new ArrayList();
        int j=2;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c<=1){
                arrayList.add(c);
            } else if (c%j==0){
                arrayList.add(c);
            }
        }
        Collections.sort(arrayList);
        String list= arrayList.toString();
        return list;
    }

    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMatrNrInOrderNoPrime.class);
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
    /*public void sendToServer(){

        EinzelBspThread t= new EinzelBspThread();
        t.start();

        try {
            t.join();
        } catch (InterruptedException ie){

        }

    }*/





}