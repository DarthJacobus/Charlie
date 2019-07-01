package com.example.migrainebuddy.LogIn_CreateAccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.migrainebuddy.R;

public class AgeActivity extends AppCompatActivity
{

    //Widgets
    DatePicker datePicker;
    Button finishButton;

    public static String mm, dd, yy;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        initWidgets();



        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dateToStringVar();
                NameActivity.newUser.setMonthBorn(mm);
                NameActivity.newUser.setDayBorn(dd);
                NameActivity.newUser.setYearBorn(yy);


                Intent intent = new Intent(AgeActivity.this, GenderSpecificQuestions.class);
                startActivity(intent);





            }
        });









    }



    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    public void initWidgets()
    {
        datePicker = findViewById(R.id.datePickerAge);
        finishButton = findViewById(R.id.finishButton);

    }


    public void dateToStringVar()
    {
        mm = String.valueOf(datePicker.getMonth());
        dd = String.valueOf(datePicker.getDayOfMonth());
        yy = String.valueOf(datePicker.getYear());

    }


















}
