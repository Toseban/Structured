package com.toseban.structured;

import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class Timetable extends ActionBarActivity {

	ActionBar actionBar;

	DayviewFragmentAdapter myAdapter;
	ViewPager myPager;
	PageIndicator myIndicator;

	private DrawerLayout myDrawerLayout;
	private ListView myDrawerList;
	private ActionBarDrawerToggle myDrawerToggle;

	private CharSequence myDrawerTitle;
	private CharSequence myTitle;
	private String[] myDrawerFragmentTitles;

	Bundle mySavedInstanceState;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timetable);
		mySavedInstanceState = savedInstanceState;

		dayviewFragmentSetUp();
		actionBarSetUp();
		navigationDrawerSetUp();

	}

	private void navigationDrawerSetUp() {
		// TODO Auto-generated method stub
		myTitle = getTitle();
		myDrawerTitle = "Drawer";
		myDrawerFragmentTitles = getResources().getStringArray(
				R.array.drawer_fragment_titles_array);
		myDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		myDrawerList = (ListView) findViewById(R.id.left_drawer);
		myDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		myDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, myDrawerFragmentTitles));
		myDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);

		myDrawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(myTitle);
				supportInvalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(myDrawerTitle);
				supportInvalidateOptionsMenu(); // creates call to
				// onPrepareOptionsMenu()
			}

		};
		myDrawerLayout.setDrawerListener(myDrawerToggle);

		if (mySavedInstanceState == null) {
			selectItem(0);
		}
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = myDrawerLayout.isDrawerOpen(myDrawerList);
		// Hide action button related to the content view
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (myDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		switch (item.getItemId()) {
		// Handle ActionButtons
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void actionBarSetUp() {
		// TODO Auto-generated method stub
		actionBar = getSupportActionBar();
		actionBar.setLogo(R.drawable.png_structured);
		Resources res = getResources();
		Drawable actionbarBackground = res
				.getDrawable(R.drawable.actionbar_background);
		actionBar.setBackgroundDrawable(actionbarBackground);
		actionBar.setTitle(R.string.timetable_activity_title);
		actionBar.show();
	}

	private void dayviewFragmentSetUp() {
		// TODO Auto-generated method stub
		myAdapter = new DayviewFragmentAdapter(getSupportFragmentManager());
		myPager = (ViewPager) findViewById(R.id.pager);
		myPager.setAdapter(myAdapter);
		myIndicator = (TitlePageIndicator) findViewById(R.id.indicator);
		myIndicator.setViewPager(myPager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timetable, menu);
		return super.onCreateOptionsMenu(menu);
	}

	private class DrawerItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			selectItem(position);
		}
	}

	public void selectItem(int position) {
		// TODO Auto-generated method stub
		Fragment fragment = new Fragment();

	}

	@Override
	public void setTitle(CharSequence title) {
		myTitle = title;
		actionBar.setTitle(myTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		myDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		myDrawerToggle.onConfigurationChanged(newConfig);
	}

}
