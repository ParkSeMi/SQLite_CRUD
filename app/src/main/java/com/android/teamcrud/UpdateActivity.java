package com.android.teamcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {  // 수정 차종한

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다

        EditText update_id = findViewById(R.id.update_id);
        EditText update_name = findViewById(R.id.update_name);
        EditText update_major = findViewById(R.id.update_major);
        EditText update_pw = findViewById(R.id.update_pw);


        String id = Integer.toString(intent.getIntExtra("id", 0));
        update_id.setText(id);

        update_name.setText(intent.getStringExtra("username"));

        update_major.setText(intent.getStringExtra("major"));

        String pass = Integer.toString(intent.getIntExtra("passwd", 0));
        update_pw.setText(pass);
    }
}