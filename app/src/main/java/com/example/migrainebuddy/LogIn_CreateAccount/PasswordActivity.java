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
import com.example.migrainebuddy.AgeActivity;
import com.example.migrainebuddy.Databases.MBDatabaseHelper;
import com.example.migrainebuddy.Profile_and_Settings.ProfileFragment;
import com.example.migrainebuddy.R;
import com.example.migrainebuddy.UserDataEncryption;

public class PasswordActivity extends AppCompatActivity
{

    //Widgets
    private TextView passwordText, signInInsteadText;
    private EditText passwordField1, passwordField2;
    private Button nextButton;

    //password and repeatedPassword variables
    public static String password, repeatedPassword;

    UserDataEncryption encryptor;
    MBDatabaseHelper mbDatabase;

    public static Boolean createdAccount;


    //Method: ON CREATE
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Creation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        mbDatabase =  new MBDatabaseHelper(this);
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
        initWidgets();
        createdAccount = null;


        //NextButton OnClickListener
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Sets password and repeatedPassword to field input
                fieldToStringVar();

                //Actions executed after animation delay
                Runnable r = new Runnable() {
                    @Override
                    public void run(){
                        Intent intent = new Intent(PasswordActivity.this, AgeActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                };


                //Conditional IF: Executed if log in is successful
                if(!fieldsAreEmpty() && passwordsMatch(password, repeatedPassword) && !passwordSameAsEmail(password, encryptor.decrypt(NameActivity.newUser.getEmail(), "onhi2g4pojg")) && passwordAtLeastSixtCharacters(password)) {
                    closeKeyboard();
                    String encryptedPassword = encryptor.encrypt(password, "j5gij55k4k4om4wo");
                    NameActivity.newUser.setPassword(encryptedPassword);

                    Handler h = new Handler();
                    h.postDelayed(r, 300);
                }

                //Conditional ELSE: Different executions if log in fails depending on nature of failure
                else {
                    if(fieldsAreEmpty()) {
                        Toast.makeText(PasswordActivity.this, "Make sure to repeat your password!", Toast.LENGTH_SHORT).show();
                        nextButton.startAnimation(animShake);
                    }
                    else if(!passwordsMatch(password, repeatedPassword)) {
                        Toast.makeText(PasswordActivity.this, "Passwords did not match. Try again!", Toast.LENGTH_SHORT).show();
                        nextButton.startAnimation(animShake);
                    }
                    else if(passwordSameAsEmail(password, encryptor.decrypt(NameActivity.newUser.getEmail(), "onhi2g4pojg"))) {
                        Toast.makeText(PasswordActivity.this, "Your email and password can't be the same!", Toast.LENGTH_SHORT).show();
                        nextButton.startAnimation(animShake);
                    }
                    else if(!passwordAtLeastSixtCharacters(password)) {
                        Toast.makeText(PasswordActivity.this, "Your password needs to be at least six characters!", Toast.LENGTH_SHORT).show();
                        nextButton.startAnimation(animShake);
                    }

                }

            }
        });


        //Sign-in-instead text OnClickListener
        signInInsteadText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });


    }







    //Method: Enables animation at start of activity
    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    //Method: Initializes all widgets in the view
    private void initWidgets()
    {
        passwordText = findViewById(R.id.passwordText);
        passwordField1 = findViewById(R.id.passwordField1);
        passwordField2 = findViewById(R.id.passwordField2);
        nextButton = findViewById(R.id.nextButton3);
        signInInsteadText = findViewById(R.id.signInText3);

    }

    //Method: Sets password and repeatedPassword equal to the input in passwordField1 and passwordField2
    private void fieldToStringVar()
    {
        password = passwordField1.getText().toString();
        repeatedPassword = passwordField2.getText().toString();
    }


    //Method: Checks if password and repeatedPassword match
    public Boolean passwordsMatch(String p1, String p2)
    {
        if(p1.equals(p2)) {
            return true;
        }
        return false;
    }


    //Method: Checks if passwordField1 and/or passwordField2 is empty
    private Boolean fieldsAreEmpty()
    {
        if(TextUtils.isEmpty(password) || TextUtils.isEmpty(repeatedPassword)) {
            return true;
        }
        return false;

    }


    //Method: Checks if password and email are the same
    private Boolean passwordSameAsEmail(String p, String e)
    {
        if(p.equals(e)) { return true; }
        return false;
    }


    //Method: Checks if password is at least six characters in length
    private Boolean passwordAtLeastSixtCharacters(String p)
    {
        if(p.length() >= 6) {
            return true;
        }
        return false;

    }


    //Method: Force hides the keyboard
    private void closeKeyboard()
    {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }





}
