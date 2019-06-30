package com.example.migrainebuddy.LogIn_CreateAccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.migrainebuddy.GenderSpecificQuestions;
import com.example.migrainebuddy.MaleQuestionsActivity;
import com.example.migrainebuddy.R;

public class GenderActivity extends AppCompatActivity
{
    Button femaleButton, maleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);


        femaleButton = findViewById(R.id.femaleButton);
        maleButton = findViewById(R.id.maleButton);

        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GenderActivity.this, GenderSpecificQuestions.class);
                startActivity(intent);
            }
        });

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GenderActivity.this, MaleQuestionsActivity.class);
                startActivity(intent);
            }
        });
















    }








}
