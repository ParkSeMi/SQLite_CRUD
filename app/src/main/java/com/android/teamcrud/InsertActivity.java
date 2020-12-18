package com.android.teamcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InsertActivity extends AppCompatActivity { //이강후 시작12/18

    private String username;
    private String major;
    private String passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
    }
}