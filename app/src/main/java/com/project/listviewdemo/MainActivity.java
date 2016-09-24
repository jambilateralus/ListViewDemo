package com.project.listviewdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper handler = new DBHelper(this);

        // Insert items to database
        handler.insertItem("hello",1);
        handler.insertItem("hi",11);

        SQLiteDatabase db = handler.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM testTable",null);

        // ListView with onItemClickListener
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You clicked on Item: "+position, Toast.LENGTH_SHORT).show();
            }
        });

        // ListView longClick listener
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Long clicked: "+position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        // Set custom adapter to listView
        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(this, cursor);
        listView.setAdapter(customCursorAdapter);
    }
}
