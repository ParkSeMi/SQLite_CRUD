package com.android.teamcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_Selectall;
    Button btn_Insert;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Selectall = findViewById(R.id.btn_Selectall);
        btn_Insert = findViewById(R.id.btn_Insert); //이강후

        btn_Selectall.setOnClickListener(mClickListener);
        btn_Insert.setOnClickListener(mClickListener2); //합칠때 충돌방지하고자 아래 method를 따로 빼놓았습니다 이강후
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent = new Intent(MainActivity.this, SelectActivity.class);
            startActivity(intent);
        }
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