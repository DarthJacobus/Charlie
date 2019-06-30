package com.example.migrainebuddy.Databases;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.migrainebuddy.User.User;

public class MBDatabaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "User Database";
    public static final String TABLE_NAME = "User table";
    public static final int DATABASE_VERSION = 1;
    public static final String COL1 = "EMAIL";
    public static final String COL2 = "PASSWORD";
    public static final String COL3 = "FIRSTNAME";
    public static final String COL4 = "LASTNAME";
    public static final String COL5 = "GENDER";
    public static final String TABLENAME = "userTable";

    private static String email, password, firstName, lastName;
    private static int gender;


    public MBDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE  userTable (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "EMAIL TEXT, " +
                "PASSWORD TEXT, " +
                "FIRSTNAME TEXT, " +
                "LASTNAME TEXT, " +
                "GENDER NUMBER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addUser(String email, String password, String firstName, String lastName, int gender)
    {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1, email);
        contentValues.put(COL2, password);
        contentValues.put(COL3, firstName);
        contentValues.put(COL4, lastName);
        contentValues.put(COL5, gender);

        long res = db.insert("userTable", null, contentValues);
        db.close();
        return res;
    }

    public Boolean userExists(String email, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from userTable where email=? and password=?", new String[]{email, password});
        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }


    }





    public User getUser(String userEmail)
    {
        String fetchedEmail = "";
        String fetchedPassword = "";
        String fetchedFirstName = "";
        String fetchedLastName = "";
        int fecthedGender = 0;


        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.rawQuery("select * from userTable where email='"+userEmail+"'",null);


        if (cursor.moveToFirst()) {
            do {
                {
                    fetchedEmail = cursor.getString(1);
                    fetchedPassword = cursor.getString(2);
                    fetchedFirstName = cursor.getString(3);
                    fetchedLastName = cursor.getString(4);
                    fecthedGender = cursor.getInt(5);
                }
            } while (cursor.moveToNext());
        }

        User user = new User(fetchedEmail, fetchedPassword, fetchedFirstName, fetchedLastName, fecthedGender);

        cursor.close();

        return user;



    }















}
