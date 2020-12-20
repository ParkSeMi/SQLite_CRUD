package com.android.teamcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    TextView deId, deMajor, deName, dePw;
    Button deButton;
    Studentinfo studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        studentInfo = new Studentinfo(DeleteActivity.this);

        deId = findViewById(R.id.delete_id);
        deMajor = findViewById(R.id.delete_major);
        deName = findViewById(R.id.delete_name);
        dePw = findViewById(R.id.delete_pw);
        deButton = findViewById(R.id.deleteB);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다

        String id = Integer.toString(intent.getIntExtra("id", 0));
        deId.setText("학번 : "+id);
        deName.setText("이름 : "+intent.getStringExtra("username"));
        deMajor.setText("전공 : "+intent.getStringExtra("major"));
        String pass = Integer.toString(intent.getIntExtra("passwd", 0));
        dePw.setText("비밀 번호 : "+pass);


        deButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase DB;
                try{
                    DB = studentInfo.getWritableDatabase();
                    String query = "DELETE From student where id =" +id+";";
                    DB.execSQL(query);

                    studentInfo.close();
                    Toast.makeText(DeleteActivity.this, "Delete OK!", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(DeleteActivity.this, "Delete Error!", Toast.LENGTH_SHORT).show();
                }
                finish();
            }

        });
    }
}   //2020-12-18 19:30 지은