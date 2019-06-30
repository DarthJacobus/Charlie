package com.example.migrainebuddy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ChangeUserInfoDialog extends AppCompatDialogFragment
{

    private UserDataEncryption encryptor;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog, null);


        builder.setView(view)
                .setTitle("Edit your name")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });

        EditText emailField = view.findViewById(R.id.emailFieldDialog);
        EditText passwordField = view.findViewById(R.id.passwordFieldDialog);

        //emailField.setText(encryptor.decrypt(ProfileFragment.currentUser.getFirstName(), "hgtkk5ok3o34o"));
        //passwordField.setText(encryptor.decrypt(ProfileFragment.currentUser.getLastName(), "lkj3h4fgerqf43u"));

        return builder.create();

    }






}
