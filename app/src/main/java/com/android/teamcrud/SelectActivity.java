package com.android.teamcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {


    final static  String TAG = "Status";

    Studentinfo studentinfo;

    private ArrayList<Student> data = null;
    private StudentAdapter adapter = null;
    private ListView listView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        SelectAll();

        listView.setOnItemLongClickListener(onItemLongClickListener);
        listView.setOnItemClickListener(onItemClickListener);

    }
    // 리스트 클릭하 수정페이지
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
            intent.putExtra("id", data.get(position).getId());
            intent.putExtra("username", data.get(position).getUsername());
            intent.putExtra("major", data.get(position).getMajor());
            intent.putExtra("passwd", data.get(position).getPasswd());

            startActivity(intent);
        }
    };

    // 리스트 길게 클릭하면 삭제페이
    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(SelectActivity.this, DeleteActivity.class);
            intent.putExtra("id", data.get(position).getId());
            intent.putExtra("username", data.get(position).getUsername());
            intent.putExtra("major", data.get(position).getMajor());
            intent.putExtra("passwd", data.get(position).getPasswd());

            startActivity(intent);

            Toast.makeText(SelectActivity.this, "LongClick", Toast.LENGTH_SHORT).show();

            return false;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        SelectAll();

    }//onResume





    //----------------------------

    public void SelectAll(){
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
    }





}//2020-12-18 19:30 세미(메소드 분리)
// 2020-12-18 16:30 조원 전체