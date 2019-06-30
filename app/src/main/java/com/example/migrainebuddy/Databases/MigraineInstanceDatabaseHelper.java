package com.example.migrainebuddy.Databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MigraineInstanceDatabaseHelper extends SQLiteOpenHelper
{

    public static final String database_name = "Migraine Instance Database";
    public static final String table_name = "migraine_instance_table";
    public static final int database_version = 1;
    public static final String col1 = "EMAIL";
    public static final String col2 = "PASSWORD";
    public static final String col3 = "FIRSTNAME";
    public static final String col4 = "LASTNAME";


    public MigraineInstanceDatabaseHelper(Context context)
    {
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE  migraine_instance_table (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "DATE TEXT, " +
                "EMAIL TEXT, " +
                "FIRSTNAME TEXT, " +
                "LASTNAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }









}
