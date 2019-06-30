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
import java.util.regex.Pattern;
import com.example.migrainebuddy.R;
import com.example.migrainebuddy.UserDataEncryption;

public class EmailActivity extends AppCompatActivity
{

    //Widgets
    private Button nextButton;
    private TextView emailText, signInInsteadText;
    private EditText emailField1, emailField2;

    //email and repeatedEmail variables
    public static String email, repeatedEmail;

    UserDataEncryption encryptor;


    //Method: ON CREATE
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Creation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);

        initWidgets();

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
                        Intent intent = new Intent(EmailActivity.this, PasswordActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                };

                //Conditional IF: Executed if email and repeatedEmail do not match and fields are not empty
                if(!fieldsAreEmpty() && emailsMatch(email, repeatedEmail) && emailPatternIsValid(email)) {
                    closeKeyboard();
                    String encryptedEmail = encryptor.encrypt(email, "onhi2g4pojg");
                    NameActivity.newUser.setEmail(encryptedEmail);
                    Handler h = new Handler();
                    h.postDelayed(r, 300);
                }

                //Conditional ELSE: Executed when email input fails depending on nature of failure
                else {
                    if(fieldsAreEmpty()) {
                        Toast.makeText(EmailActivity.this, "Make sure to repeat your email! Try again!", Toast.LENGTH_SHORT).show();
                        nextButton.startAnimation(animShake);
                    }
                    else if(!emailsMatch(email, repeatedEmail)) {
                        Toast.makeText(EmailActivity.this, "Emails did not match. Try again!", Toast.LENGTH_SHORT).show();
                        nextButton.startAnimation(animShake);
                    }
                    else if(!emailPatternIsValid(email)) {
                        Toast.makeText(EmailActivity.this, "Email format is not correct. Try again!", Toast.LENGTH_SHORT).show();
                        nextButton.startAnimation(animShake);
                    }


                }

            }
        });


        //Sign-in-instead text OnClickListener
        signInInsteadText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailActivity.this, SignInActivity.class);
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
    public void initWidgets()
    {
        nextButton = findViewById(R.id.nextButton2);
        signInInsteadText = findViewById(R.id.signInText2);
        emailField1 = findViewById(R.id.emailFieldCA);
        emailField2 = findViewById(R.id.emailFieldCA2);
        emailText = findViewById(R.id.emailText);

    }


    //Method: Sets email and repeatedEmail equal to the input in emailField1 and emailField2
    public void fieldToStringVar()
    {
        email = emailField1.getText().toString().toLowerCase();
        repeatedEmail = emailField2.getText().toString().toLowerCase();
    }


    //Method: Checks if emailField1 and/or emailField2 is empty
    public Boolean fieldsAreEmpty()
    {
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(repeatedEmail)) {
            return true;
        }
        return false;

    }


    //Method: Checks if email and repeatedEmail match
    public Boolean emailsMatch(String email1, String email2)
    {
        if(email1.equals(email2)) {return true;}
        return false;
    }


    //Method: Checks if email follows the standard email address pattern
    public Boolean emailPatternIsValid(String emailStr) {
        final Pattern EMAIL_REGEX = Pattern
                .compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
                                          ")*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"
                                          , Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(emailStr).matches();
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
