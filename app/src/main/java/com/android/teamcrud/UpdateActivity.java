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

public class UpdateActivity extends AppCompatActivity {  // 수정 차종한

    final static String TAG = "Status";

    EditText update_id;
    EditText update_name;
    EditText update_major;
    EditText update_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다

        update_id = findViewById(R.id.update_id);
        update_name = findViewById(R.id.update_name);
        update_major = findViewById(R.id.update_major);
        update_pw = findViewById(R.id.update_pw);


        String id = Integer.toString(intent.getIntExtra("id", 0));
        update_id.setText(id);

        update_name.setText(intent.getStringExtra("username"));

        update_major.setText(intent.getStringExtra("major"));

        String pass = Integer.toString(intent.getIntExtra("passwd", 0));
        update_pw.setText(pass);
        // -----------------------------------------------------------------------------------

        Button update_btn = findViewById(R.id.updateB);
        update_btn.setOnClickListener(mClickListener);



    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Studentinfo studentinfo = new Studentinfo(UpdateActivity.this);
            SQLiteDatabase DB = studentinfo.getWritableDatabase();

            try {
                DB = studentinfo.getWritableDatabase(); // 입력이라 writable
                String query = "UPDATE student SET username = '" + update_name.getText().toString().trim() + "'," +
                        " major = '" + update_major.getText().toString().trim() + "'," +
                        " passwd = '" + update_pw.getText().toString().trim() + "'" +
                        " WHERE id = '" + update_id.getText() + "';";
                Log.v(TAG, query);
                DB.execSQL(query);

                studentinfo.close(); // memberInfo 종료
                Toast.makeText(UpdateActivity.this, "Update OK!", Toast.LENGTH_SHORT).show();

            }catch (Exception e){
                e.printStackTrace();
                Log.v(TAG, String.valueOf(e));
                Toast.makeText(UpdateActivity.this, "Update Error!", Toast.LENGTH_SHORT).show();
            }
        }
    };
}