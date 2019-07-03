package com.example.migrainebuddy.Databases;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.migrainebuddy.User.User;

public class MBDatabaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "Charlie Database: Users";
    public static final String TABLE_NAME = "UserDataTable";
    public static final int DATABASE_VERSION = 1;
    public static final String COL1 = "EMAIL";
    public static final String COL2 = "PASSWORD";
    public static final String COL3 = "FIRSTNAME";
    public static final String COL4 = "LASTNAME";
    public static final String COL5 = "MONTHBORN";
    public static final String COL6 = "DAYBORN";
    public static final String COL7 = "YEARBORN";
    public static final String COL8 = "GENDER";

    private static String email, password, firstName, lastName, monthBorn, dayBorn, yearBorn, gender;


    public MBDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE  UserDataTable (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "EMAIL TEXT, " +
                "PASSWORD TEXT, " +
                "FIRSTNAME TEXT, " +
                "LASTNAME TEXT, " +
                "MONTHBORN TEXT, " +
                "DAYBORN TEXT, " +
                "YEARBORN TEXT, " +
                "GENDER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addUser(String email, String password, String firstName, String lastName, String monthBorn, String dayBorn,
                                    String yearBorn, String gender)
    {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthBorn = monthBorn;
        this.dayBorn = dayBorn;
        this.yearBorn = yearBorn;
        this.gender = gender;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1, email);
        contentValues.put(COL2, password);
        contentValues.put(COL3, firstName);
        contentValues.put(COL4, lastName);
        contentValues.put(COL5, monthBorn);
        contentValues.put(COL6, dayBorn);
        contentValues.put(COL7, yearBorn);
        contentValues.put(COL8, gender);


        long res = db.insert("UserDataTable", null, contentValues);
        db.close();
        return res;
    }

    public Boolean userExists(String email, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from UserDataTable where email=? and password=?", new String[]{email, password});
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
        String fetchedMonthBorn = "";
        String fetchedDayBorn = "";
        String fetchedYearBorn = "";
        String fetchedGender = "";


        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.rawQuery("select * from UserDataTable where email='"+userEmail+"'",null);


        if (cursor.moveToFirst()) {
            do {
                {
                    fetchedEmail = cursor.getString(1);
                    fetchedPassword = cursor.getString(2);
                    fetchedFirstName = cursor.getString(3);
                    fetchedLastName = cursor.getString(4);
                    fetchedMonthBorn = cursor.getString(5);
                    fetchedDayBorn = cursor.getString(6);
                    fetchedYearBorn = cursor.getString(7);
                    fetchedGender = cursor.getString(8);
                }
            } while (cursor.moveToNext());
        }

        User user = new User(fetchedEmail, fetchedPassword, fetchedFirstName, fetchedLastName, fetchedMonthBorn,
                                           fetchedDayBorn, fetchedYearBorn, fetchedGender);

        cursor.close();

        return user;



    }















}
