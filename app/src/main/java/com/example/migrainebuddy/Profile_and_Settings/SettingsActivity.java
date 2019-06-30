package com.example.migrainebuddy.Profile_and_Settings;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.migrainebuddy.R;


public class SettingsActivity extends AppCompatActivity {

    Button deleteAccountButtonSettings;
    Dialog deleteAccountDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        deleteAccountButtonSettings = findViewById(R.id.deleteAccountButtonSettings);
        deleteAccountDialog = new Dialog(this);

        deleteAccountButtonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAccountDialog.setContentView(R.layout.delete_account_popup);
                deleteAccountDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                deleteAccountDialog.show();
            }
        });

















    }
}
