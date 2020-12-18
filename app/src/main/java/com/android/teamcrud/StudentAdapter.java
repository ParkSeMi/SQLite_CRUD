package com.android.teamcrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    private Context mContext = null;
    private int layout = 0;

    //Bean
    private ArrayList<Student> data = null;

    private LayoutInflater inflater = null;


    public StudentAdapter(Context mContext, int layout, ArrayList<Student> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getId();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
        }
        TextView tv_id = convertView.findViewById(R.id.tv_id);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_major = convertView.findViewById(R.id.tv_major);
        TextView tv_passwd = convertView.findViewById(R.id.tv_passwd);

        tv_id.setText("학번 : " + data.get(position).getId());
        tv_name.setText("이름 : " + data.get(position).getUsername());
        tv_major.setText("전공 : " + data.get(position).getMajor());
        tv_passwd.setText("비밀번호 : " + data.get(position).getPasswd());

        if(position % 2 == 1){
            convertView.setBackgroundColor(0x5000ff00);
        }else {
            convertView.setBackgroundColor(0x2000ff00);
        }
        return convertView;


    }
}
