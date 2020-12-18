package com.android.teamcrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Studentinfo extends SQLiteOpenHelper {

    final static String TAG = "StudentInfo";

    public Studentinfo(@Nullable Context context) {
        super(context, "StudentInfo.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v(TAG, "onCreate()");
        String query = "CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, major TEXT, passwd INTEGER);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(TAG, "upgrade()");
        String query = "DROP TABLE IF EXISTS student;";
        db.execSQL(query);
        onCreate(db);
    }
}
