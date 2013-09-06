package com.toseban.structured;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class Timetable extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.png_structured);
        actionBar.setTitle(R.string.timetable_activity_title);
        actionBar.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timetable, menu);
        return true;
    }
    
}
