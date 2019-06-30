package com.example.migrainebuddy.Profile_and_Settings;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.migrainebuddy.Databases.MBDatabaseHelper;
import com.example.migrainebuddy.R;
import com.example.migrainebuddy.User.User;
import com.example.migrainebuddy.UserDataEncryption;

public class ProfileFragment extends Fragment
{

    private TextView nameText, emailText;
    private TextView settingsText, editProfileText;
    private Button viewPasswordButton;

    private MBDatabaseHelper mbDatabase;
    private UserDataEncryption encryptor;

    private User user;

    private static View view;

    Dialog showPasswordDialog;

    ImageView imageView;

    TextView countdownText;






    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        initWidgets();

        showPasswordDialog = new Dialog(getContext());

        //View.OnClick intents
        settingsOnClick();
        editProfileOnClick();
        viewPasswordOnClick();







        return view;
    }



    public void initWidgets()
    {
        nameText = view.findViewById(R.id.nameText);
        emailText = view.findViewById(R.id.emailText);
        settingsText = view.findViewById(R.id.settings);
        editProfileText = view.findViewById(R.id.editProfile);
        viewPasswordButton = view.findViewById(R.id.viewPasswordButton);

    }

    public void settingsOnClick()
    {
        settingsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

    public void editProfileOnClick()
    {
        editProfileText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });


    }

    public void viewPasswordOnClick()
    {
        viewPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPasswordDialog.setContentView(R.layout.password_popup);
                showPasswordDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                showPasswordDialog.show();

            }
        });


    }

























}
