/*
package com.example.migrainebuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilePage extends AppCompatActivity {


    private TextView firstNameText, lastNameText, emailText, passwordText;
    private TextView firstNameTitle, lastNameTitle, emailTitle, passwordTitle;
    private Button editNameButton, editEmailButton, changePasswordButton;

    public static User currentUser;
    private MBDatabaseHelper mbDatabase;
    private UserDataEncryption encryptor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page_activity);
        initWidgets();

        mbDatabase = new MBDatabaseHelper(this);
        String currentUserEmail = getIntent().getStringExtra("userEmail");

        try {
            currentUser = mbDatabase.getUser(currentUserEmail);
            setFieldToStringVar();
        }
        catch(Exception e) {
            Toast.makeText(ProfilePage.this, "This did not work yet!", Toast.LENGTH_SHORT).show();
        }


        editNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        editEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });



    }







}
*/
