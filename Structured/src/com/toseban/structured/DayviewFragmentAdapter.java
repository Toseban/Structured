package com.toseban.structured;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

public class DayviewFragmentAdapter extends FragmentPagerAdapter implements
		IconPagerAdapter {

	protected static final String[] contentArray = new String[] { "Monday",
			"Tuesday", "Wednesday", "Thursday", "Friday" };

	private int mCount = contentArray.length;

	Timetable timetable = new Timetable();

	public DayviewFragmentAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getIconResId(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = new FragmentMonday();
		switch (position) {
		case 0:
			fragment = new FragmentMonday();
			break;
		case 1:
			fragment = new FragmentTuesday();
			break;
		case 2:
			fragment = new FragmentWednesday();
			break;
		case 3:
			fragment = new FragmentThursday();
			break;
		case 4:
			fragment = new FragmentFriday();
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		String title = "";
		switch (position) {
		case 0:
			title = "Monday";
			break;
		case 1:
			title = "Tuesday";
			break;
		case 2:
			title = "Wednesday";
			break;
		case 3:
			title = "Thursday";
			break;
		case 4:
			title = "Friday";
		}

		title = contentArray[position];

		return title;
	}

	public void setCount(int count) {
		if (count > 0 && count < 10) {
			mCount = count;
			notifyDataSetChanged();
		}
	}

}
