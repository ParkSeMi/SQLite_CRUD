package com.android.teamcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_Selectall, btn_Insert, btn_Update, btn_Delete;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Selectall = findViewById(R.id.btn_Selectall);
        btn_Delete = findViewById(R.id.btn_Delete);
        btn_Insert = findViewById(R.id.btn_Insert);
        btn_Update = findViewById(R.id.btn_Update);

        btn_Selectall.setOnClickListener(mClickListener);
        btn_Delete.setOnClickListener(mClickListener);
        btn_Insert.setOnClickListener(mClickListener);
        btn_Update.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                // selectall 클릭 시 페이지 이동.
                case R.id.btn_Selectall:
            intent = new Intent(MainActivity.this, SelectActivity.class);
            startActivity(intent);
            break;

                // insert 클릭 시 페이지 이동.
                case R.id.btn_Insert:
                    intent = new Intent(MainActivity.this, DeleteActivity.class);
                    startActivity(intent);
                    break;

                // Delete 클릭 시 Dialog
                case R.id.btn_Delete:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("잠깐!")
                            .setIcon(R.mipmap.ic_launcher_round)
                            .setMessage("Select All에서 길게 눌러서 삭제페이지로 이동해주세요.")
                            .setPositiveButton("확인", null)
                            .show();
                    break;

                // update 클릭 시 Dialog
                case R.id.btn_Update:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("잠깐!")
                            .setIcon(R.mipmap.ic_launcher_round)
                            .setMessage("Select All에서 짧게 눌러 수정 페이지로 이동해주세요.")
                            .setPositiveButton("확인", null)
                            .show();
                    break;

            }
        } // 20.12.18 세미 메인에서 버튼 클릭 시 기능 추가
    };


} // -----