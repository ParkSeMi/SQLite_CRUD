package com.android.teamcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {


    final static  String TAG = "Status";
    TextView tvResult;

    Studentinfo studentinfo;

    private ArrayList<Student> data = null;
    private StudentAdapter adapter = null;
    private ListView listView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        studentinfo = new Studentinfo(SelectActivity.this);

        listView = findViewById(R.id.lv_student);

        SQLiteDatabase DB;

        try {
            DB = studentinfo.getReadableDatabase();
            String query = "SELECT id, username, major, passwd FROM student;";
            Cursor cursor = DB.rawQuery(query, null);

            data = new ArrayList<Student>();
            while(cursor.moveToNext()){
                 int id = cursor.getInt(0);
                 String username = cursor.getString(1);
                 String major = cursor.getString(2);
                 int passwd = cursor.getInt(3);

                 Student student = new Student(id, username, major, passwd);

                 data.add(student);
            }

            adapter = new StudentAdapter(SelectActivity.this, R.layout.custom_layout, data);
            listView.setAdapter(adapter);

            cursor.close();
            studentinfo.close();
            Toast.makeText(SelectActivity.this, "Select OK!", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Log.v(TAG, String.valueOf(e));
            Toast.makeText(SelectActivity.this, "Select Error!", Toast.LENGTH_SHORT).show();
        }




        listView.setOnLongClickListener(new View.OnLongClickListener() {
                Intent intent = null;
            @Override
            public boolean onLongClick(View v) {

                return true;
            }
        });





    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}