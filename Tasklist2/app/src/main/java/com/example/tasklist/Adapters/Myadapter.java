package com.example.tasklist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.tasklist.Model.Tasks;
import com.example.tasklist.R;

import java.util.ArrayList;

public class Myadapter extends BaseAdapter {


    Context context;
    ArrayList<Tasks> arrayList;

    public Myadapter(Context context,ArrayList<Tasks> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            LayoutInflater inflator =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView =inflator.inflate(R.layout.mylist,null);
            TextView id = (TextView)convertView.findViewById(R.id.Task_id);
            TextView task = (TextView)convertView.findViewById(R.id.Task);
            TextView Date = (TextView)convertView.findViewById(R.id.Date);


           Tasks tasks =arrayList.get(position);
           id.setText(String.valueOf(tasks.getId()));
           task.setText(tasks.getNotes());
           Date.setText(tasks.getDate());
        }

        return convertView;
    }
}
