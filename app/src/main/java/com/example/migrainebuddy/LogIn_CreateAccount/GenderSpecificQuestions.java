package com.example.migrainebuddy.LogIn_CreateAccount;

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
import com.example.migrainebuddy.LogIn_CreateAccount.NameActivity;
import com.example.migrainebuddy.Profile_and_Settings.ProfileFragment;
import com.example.migrainebuddy.R;

public class GenderSpecificQuestions extends AppCompatActivity
{

    RadioGroup radioGroupGenderChoice;
    RadioButton radioButton;

    ViewFlipper questionFlipper, questionFlipperFemale, questionFlipperMale;

    Boolean createdAccount;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_questions);

        radioGroupGenderChoice = findViewById(R.id.radioGroupGenderQuestion);

        questionFlipper = findViewById(R.id.questionFlipperGender);
        questionFlipper.setVisibility(View.VISIBLE);
        questionFlipperFemale= findViewById(R.id.questionFlipperFemale);
        questionFlipperFemale.setVisibility(View.GONE);
        questionFlipperMale = findViewById(R.id.questionFlipperMale);
        questionFlipperMale.setVisibility(View.GONE);








    }



    public void previousView(View v)
    {
        questionFlipper.showPrevious();
    }

    public void nextViewFemale(View v)
    {
        questionFlipperFemale.setInAnimation(this, R.anim.slide_in_right);
        questionFlipperFemale.setOutAnimation(this, R.anim.slide_out_left);
        questionFlipperFemale.showNext();
    }

    public void nextViewMale(View v)
    {
        questionFlipperMale.setInAnimation(this, R.anim.slide_in_right);
        questionFlipperMale.setOutAnimation(this, R.anim.slide_out_left);
        questionFlipperMale.showNext();
    }

    public void goToSpecificGenderFlipper(View v)
    {
        int radioID = radioGroupGenderChoice.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);

        if(radioButton.getText().equals("Female")) {
            NameActivity.newUser.setGender("Female");
            questionFlipper.setVisibility(View.GONE);
            questionFlipperFemale.setVisibility(View.VISIBLE);
        }

        if(radioButton.getText().equals("Male")) {
            NameActivity.newUser.setGender("Male");
            questionFlipper.setVisibility(View.GONE);
            questionFlipperMale.setVisibility(View.VISIBLE);
        }

    }



    public void checkButton(View v)
    {
        int radioID = radioGroupGenderChoice.getCheckedRadioButtonId();

        radioButton = findViewById(radioID);

        Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();


    }

    public void finishAccountCreation(View v)
    {
        Intent intent = new Intent(this, BottomNavigationActivity.class);

        createdAccount = true;

        Bundle bundle = new Bundle();
        bundle.putString("userEmail", NameActivity.newUser.getEmail());
        ProfileFragment profileFragment = new ProfileFragment();
        profileFragment.setArguments(bundle);

        startActivity(intent);

    }








}
