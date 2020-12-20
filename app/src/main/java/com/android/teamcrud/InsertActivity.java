package com.android.teamcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Queue;

public class InsertActivity extends AppCompatActivity { //이강후 시작12/18

    final static String TAG = "Status";
    EditText et_insertName;
    EditText et_insertMajor;
    EditText et_insertPasswd;
    Button btn_insertButton;
    Studentinfo studentinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        studentinfo = new Studentinfo(InsertActivity.this); //DB
        findViewById(R.id.btn_insertButton).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        SQLiteDatabase DB;

        @Override
        public void onClick(View v) {

            Intent intent = null;
            intent = new Intent(InsertActivity.this, SelectActivity.class);

            et_insertName = findViewById((R.id.et_insertName));
            et_insertMajor = findViewById(R.id.et_insertMajor);
            et_insertPasswd = findViewById(R.id.et_insertPasswd);

            if (et_insertName.length() == 0) {
                Toast.makeText(InsertActivity.this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
            } else if (et_insertMajor.length() == 0) {
                Toast.makeText(InsertActivity.this, "학과을 입력하세요.", Toast.LENGTH_SHORT).show();
            } else if (et_insertPasswd.length() == 0) {
                Toast.makeText(InsertActivity.this, "패스워드를 입력하세요.", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    DB = studentinfo.getWritableDatabase();
                    String query = "INSERT INTO student (username, major, passwd) VALUES ('" + et_insertName.getText().toString().trim() + "'," +
                            "'" + et_insertMajor.getText().toString().trim() + "','" + String.valueOf(et_insertPasswd.getText()).trim() + "');";

                    Log.v(TAG, query);
                    DB.execSQL(query);
                    studentinfo.close();
                    Toast.makeText(InsertActivity.this, "Insert OK", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.v(TAG, String.valueOf(e));
                    Toast.makeText(InsertActivity.this, "Insert Error", Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
            }
        }

        ;
    };
}