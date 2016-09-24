package com.project.listviewdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper handler = new DBHelper(this);
        handler.insertItem("hello",1);
        handler.insertItem("hi",11);
        SQLiteDatabase db = handler.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM testTable",null);
        ListView listView = (ListView) findViewById(R.id.list_view);
        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(this, cursor);
        listView.setAdapter(customCursorAdapter);
    }
}
