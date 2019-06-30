package com.example.migrainebuddy.LogIn_CreateAccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.migrainebuddy.Databases.MBDatabaseHelper;
import com.example.migrainebuddy.R;

public class MainActivity extends AppCompatActivity
{
    TextView MBtext;
    Button signInButton, createAccountButton;
    MBDatabaseHelper mbDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initWidgets();


        mbDatabase =  new MBDatabaseHelper(this);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                Animatoo.animateZoom(MainActivity.this);
                //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                startActivity(intent);
                Animatoo.animateZoom(MainActivity.this);
                //CustomIntent.customType(MainActivity.this, "up-to-bottom");
                //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


    }


    void initWidgets()
    {
        MBtext = findViewById(R.id.migraineBuddyText);
        signInButton = findViewById(R.id.signInButtonMainActivity);
        createAccountButton = findViewById(R.id.createAccountButton);
    }


   /*
    void createUser()
    {
        long val = mbDatabase.addUser(email, password, firstName, lastName);
        if(val > 0 ) {
            showToast("success");
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
        }
        else {
            showToast("failure");
        }
    }
    */



}
