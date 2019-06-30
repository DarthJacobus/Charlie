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

    private Button nextButton;
    private TextView emailText, signInInsteadText;
    private EditText emailField1, emailField2;

    public static String email, repeatedEmail;

    UserDataEncryption encryptor;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);

        initWidgets();





        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Runnable r = new Runnable() {
                    @Override
                    public void run(){
                        Intent intent = new Intent(EmailActivity.this, PasswordActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                };

                fieldToStringVar();


                if(!fieldsAreEmpty() && emailsMatch(email, repeatedEmail) && emailPatternIsValid(email)) {
                    closeKeyboard();
                    String encryptedEmail = encryptor.encrypt(email, "onhi2g4pojg");
                    NameActivity.newUser.setEmail(encryptedEmail);
                    Handler h = new Handler();
                    h.postDelayed(r, 300);
                }

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


        signInInsteadText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailActivity.this, SignInActivity.class);
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
        nextButton = findViewById(R.id.nextButton2);
        signInInsteadText = findViewById(R.id.signInText2);
        emailField1 = findViewById(R.id.emailFieldCA);
        emailField2 = findViewById(R.id.emailFieldCA2);
        emailText = findViewById(R.id.emailText);

    }

    public void fieldToStringVar()
    {
        email = emailField1.getText().toString().toLowerCase();
        repeatedEmail = emailField2.getText().toString().toLowerCase();
    }

    public Boolean fieldsAreEmpty()
    {
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(repeatedEmail)) {
            return true;
        }
        return false;

    }

    public Boolean emailsMatch(String email1, String email2)
    {
        if(email1.equals(email2)) {return true;}
        return false;
    }

    public Boolean emailPatternIsValid(String emailStr) {
        final Pattern EMAIL_REGEX = Pattern
                .compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
                                          ")*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"
                                          , Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(emailStr).matches();
    }

    private void closeKeyboard()
    {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }







}
