package com.example.migrainebuddy.LogIn_CreateAccount;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.migrainebuddy.R;
import com.example.migrainebuddy.User.User;
import com.example.migrainebuddy.UserDataEncryption;

public class NameActivity extends AppCompatActivity
{

    //Widgets
    TextView nameQuestionText, signInInsteadText;
    EditText firstNameField, lastNameField;
    Button nextButton;

    //firstName and lastName variables
    public static String firstName, lastName;

    //New User instance newUser
    public static User newUser;

    //Encryption manager
    UserDataEncryption encryptor;


    //Method: ON CREATE
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Creation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        //final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
        initWidgets();
        encryptor = new UserDataEncryption();

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);


        //NextButton OnClickListener
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                fieldToStringVar();

                //Actions executed after animation delay
                Runnable r = new Runnable() {
                    @Override
                    public void run(){
                        Intent intent = new Intent(NameActivity.this, EmailActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                };

                //Conditional: Executed if firstName and lastName input is successful
                if(!fieldsAreEmpty()) {
                    closeKeyboard();
                    String decFirstName = encryptor.encrypt(firstName, "hgtkk5ok3o34o");
                    String decLastName = encryptor.encrypt(lastName, "lkj3h4fgerqf43u");
                    newUser = new User(null, null, decFirstName, decLastName, 0);

                    Handler h = new Handler();
                    h.postDelayed(r, 300);
                }

                //Conditional: Executed if firstName and lastName input fails
                else {
                    Toast.makeText(NameActivity.this, "Make sure your name is complete!", Toast.LENGTH_SHORT).show();
                    nextButton.startAnimation(animShake);
                }
            }
        });

        //Sign-in-instead text OnClickListener
        signInInsteadText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NameActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });






    }


    /*
    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    */

    //Method: Initializes all widgets in the view
    public void initWidgets()
    {
        nameQuestionText = findViewById(R.id.nameQuestion);
        signInInsteadText = findViewById(R.id.signInText1);
        firstNameField = findViewById(R.id.firstNameFieldCA);
        lastNameField = findViewById(R.id.lastNameFieldCA);
        nextButton = findViewById(R.id.nextButton);
    }


    //Method: Sets firstName and lastName equal to the input in firstNameField and lastNameField
    public void fieldToStringVar()
    {
        firstName = firstNameField.getText().toString();
        lastName = lastNameField.getText().toString();
    }


    //Method: Checks if firstNameField and/or lastNameField is empty
    public Boolean fieldsAreEmpty()
    {
        if(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName)) {
            return true;
        }
        return false;
    }


    //Method: Force hides keyboard
    private void closeKeyboard()
    {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }









}
