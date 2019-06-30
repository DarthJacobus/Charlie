package com.example.migrainebuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.migrainebuddy.BottomNavigation.BottomNavigationActivity;

public class GenderSpecificQuestions extends AppCompatActivity
{

    RadioGroup radioGroup;
    RadioButton radioButton;

    ViewFlipper questionFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_gender_questions);

        questionFlipper = findViewById(R.id.questionFlipper);

        TextView textView = new TextView(this);

        questionFlipper.addView(textView);














    }



    public void previousView(View v)
    {
        questionFlipper.showPrevious();
    }

    public void nextView(View v)
    {
        questionFlipper.setInAnimation(this, R.anim.slide_in_right);
        questionFlipper.setOutAnimation(this, R.anim.slide_out_left);
        questionFlipper.showNext();
    }



    public void checkButton(View v)
    {
        int radioID = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioID);

        Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();


    }

    public void goToProfile(View v)
    {
                Intent intent = new Intent(this, BottomNavigationActivity.class);
        startActivity(intent);

    }








}
