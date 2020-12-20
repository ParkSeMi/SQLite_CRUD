package com.android.teamcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//<<<<<<< .merge_file_a02340
    Button btn_Selectall, btn_Insert, btn_Update, btn_Delete;
//=======
//    Button btn_Selectall;
//    Button btn_Insert;
//>>>>>>> .merge_file_a10096
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Selectall = findViewById(R.id.btn_Selectall);
//<<<<<<< .merge_file_a02340
        btn_Delete = findViewById(R.id.btn_Delete);
        btn_Insert = findViewById(R.id.btn_Insert);
        btn_Update = findViewById(R.id.btn_Update);

        btn_Selectall.setOnClickListener(mClickListener);
        btn_Delete.setOnClickListener(mClickListener);
        btn_Insert.setOnClickListener(mClickListener);
        btn_Update.setOnClickListener(mClickListener);
//=======
        btn_Insert = findViewById(R.id.btn_Insert); //이강후

        btn_Selectall.setOnClickListener(mClickListener);
        btn_Insert.setOnClickListener(mClickListener2); //합칠때 충돌방지하고자 아래 method를 따로 빼놓았습니다 이강후
//>>>>>>> .merge_file_a10096
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
//                case R.id.btn_Insert:
//                    intent = new Intent(MainActivity.this, DeleteActivity.class);
//                    startActivity(intent);
//                    break;

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
    //InsetActivity로 이동. 이강후
    //합칠때 충돌을 우려해서 따로 만들었지만 합치는 사람이 다른 사람들것을 보고 위의 것과 합쳐되 됩니다.
    View.OnClickListener mClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent = new Intent(MainActivity.this, InsertActivity.class);
            startActivity(intent);
        }
    };



} // -----