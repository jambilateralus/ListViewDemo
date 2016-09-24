package com.project.listviewdemo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by sushil on 9/24/16.
 */

class CustomCursorAdapter extends CursorAdapter {

    CustomCursorAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView comp1 = (TextView) view.findViewById(R.id.component1);
        TextView comp2 = (TextView) view.findViewById(R.id.component2);

        // Extract properties from cursor
        String dbColumnName1 = cursor.getString(cursor.getColumnIndexOrThrow("item1"));
        int dbColumnName2 = cursor.getInt(cursor.getColumnIndexOrThrow("item2"));

        // Populate fields with extracted properties
        comp1.setText(dbColumnName1);
        comp2.setText(String.valueOf(dbColumnName2));
    }

}
