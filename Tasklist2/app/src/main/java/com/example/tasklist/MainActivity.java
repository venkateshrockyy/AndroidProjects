package com.example.tasklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tasklist.Adapters.Myadapter;
import com.example.tasklist.Model.Tasks;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText Addtasktext;
    Button addtask;
    ListView list;
    ArrayList<Tasks> Listitem1;
    Myadapter adapter;
    Dbhelper db = new Dbhelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Listitem1 = new ArrayList<>();
        list =(ListView)findViewById(R.id.lvItems);
        Viewdata1();
        adapter.notifyDataSetChanged();

       list.setOnItemLongClickListener(new OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Tasks task =Listitem1.get(position);
        int ID = (task.getId());
        db.delete(ID);
        Listitem1.clear();
        Viewdata1();
        adapter.notifyDataSetChanged();

        Toast.makeText(MainActivity.this, "Task Finished", Toast.LENGTH_LONG).show();
        return  true;
    }
});
            }







    public void addtask(View view) {

      Addtasktext=(EditText) findViewById(R.id.etNewItem);
      String task = Addtasktext.getText().toString();
      if(Addtasktext.getText().toString().length() != 0)
      {
        long insert = db.insertdata(task);
        if(insert!=0 ){
            Toast.makeText(MainActivity.this,"Task Added",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(MainActivity.this,"Task is not added",Toast.LENGTH_LONG).show();
        Viewdata1();

        Addtasktext.setText("");
    }  adapter.notifyDataSetChanged();
    }

    public void Viewdata1() {


        Listitem1 = db.Viewdata();
        adapter = new Myadapter(this,Listitem1);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();




     }



}
