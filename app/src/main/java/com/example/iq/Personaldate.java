package com.example.iq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Objects;

public class Personaldate extends AppCompatActivity {
    Button proceed;
    int age;
    EditText agetext;
    RadioButton male;
    RadioButton female;
    RadioButton beginner;
    RadioButton intermediate;
    RadioButton expert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_personaldate);
        proceed = findViewById(R.id.button4);
        agetext = findViewById(R.id.age1);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        beginner = findViewById(R.id.beginner);
        intermediate = findViewById(R.id.intermediate);
        expert = findViewById(R.id.expert);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setChecked(false);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setChecked(false);
            }
        });
        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intermediate.setChecked(false);
                expert.setChecked(false);
            }
        });
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginner.setChecked(false);
                expert.setChecked(false);
            }
        });
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginner.setChecked(false);
                intermediate.setChecked(false);
            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = Integer.parseInt(String.valueOf(agetext.getText()));
                if (age<=10) {
                    Intent age = new Intent(getBaseContext(), verbal1.class);
                    age.putExtra("age", "y");
                    startActivity(age);
                }
                else {
                    Intent age = new Intent(getBaseContext(), verbal2.class);
                    age.putExtra("age", "o");
                    startActivity(age);
                }
            }
        });
    }
}