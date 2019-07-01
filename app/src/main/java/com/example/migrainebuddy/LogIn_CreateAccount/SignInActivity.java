package com.example.migrainebuddy.LogIn_CreateAccount;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.migrainebuddy.BottomNavigation.BottomNavigationActivity;
import com.example.migrainebuddy.Databases.MBDatabaseHelper;
import com.example.migrainebuddy.R;
import com.example.migrainebuddy.User.User;
import com.example.migrainebuddy.UserDataEncryption;

public class SignInActivity extends AppCompatActivity {

    EditText emailField, passwordField;
    Button signInButton;
    String email, password;
    String userFirstName;

    public static User signedInUser;
    MBDatabaseHelper mbDatabase;
    UserDataEncryption encryptor;

    public static Boolean signedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);
        signedIn = null;
        mbDatabase = new MBDatabaseHelper(this);

        emailField = findViewById(R.id.emailFieldSI);
        passwordField = findViewById(R.id.passwordFieldSI);
        signInButton = findViewById(R.id.signInButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                putFieldToVar();
                checkUserExistence();

            }
        });



    }





    public String getUserFirstName(String currentUserEmail)
    {
        mbDatabase = new MBDatabaseHelper(this);

        try {

            User currentUser = mbDatabase.getUser(currentUserEmail);

            return currentUser.getFirstName();
        }
        catch(Exception e) {

        }

        return null;

    }

    void putFieldToVar()
    {
        email = emailField.getText().toString();
        password = passwordField.getText().toString();
    }

    void checkUserExistence()
    {
        if(mbDatabase.userExists(encryptor.encrypt(email, "onhi2g4pojg"), encryptor.encrypt(password, "j5gij55k4k4om4wo"))) {
            Toast.makeText(SignInActivity.this, "Signed in. Welcome, " + getUserFirstName(email) + "!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignInActivity.this, BottomNavigationActivity.class);
            signedIn = true;
            signedInUser = new User(email, null, null, null, null, null, null, null);
            startActivity(intent);
        }
        else {
            Toast.makeText(SignInActivity.this, "Sign in failed. Try again!", Toast.LENGTH_SHORT).show();
        }

    }

    void showToast()
    {
        Toast toast = Toast.makeText(SignInActivity.this, "Signed in. Welcome!!", Toast.LENGTH_SHORT );
        View view = toast.getView();
        view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
        toast.show();


    }









}
