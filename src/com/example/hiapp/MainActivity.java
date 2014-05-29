package com.example.hiapp;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;
	long firstTime=0;
	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showResults();
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	 private void showResults() {
		 Bundle bunde = this.getIntent().getExtras();
		 String username = bunde.getString("KEY_USERNAME");
		 String password = bunde.getString("KEY_PASSWORD");
		 String welcome = "Welcome, " + username + "!"; 
		 Toast.makeText(MainActivity.this, welcome, 
                 Toast.LENGTH_SHORT).show(); 
	 }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment;
			Bundle args;
			switch(position)
			{
			case 0:
				fragment = new MainFragment();
				args = new Bundle();
				args.putInt("KEY_TYPE", 0);
				fragment.setArguments(args);
				break;
			case 1:
				fragment = new MainFragment();
				args = new Bundle();
				args.putInt("KEY_TYPE", 1);
				fragment.setArguments(args);
				break;
			case 2:
				fragment = new MainFragment();
				args = new Bundle();
				args.putInt("KEY_TYPE", 2);
				fragment.setArguments(args);
				break;
			default:
				fragment = new MainFragment();
				args = new Bundle();
				args.putInt("KEY_TYPE", 0);
				fragment.setArguments(args);
			}
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}

	
	@Override 
    public boolean onKeyUp(int keyCode, KeyEvent event) { 
        if (keyCode == KeyEvent.KEYCODE_BACK) { 
            long secondTime = System.currentTimeMillis(); 
            if (secondTime - firstTime > 1600) {//������ΰ���ʱ��������1600���룬���˳� 
                Toast.makeText(MainActivity.this, "�ٰ�һ���˳�����...", 
                        Toast.LENGTH_SHORT).show(); 
                firstTime = secondTime;//����firstTime 
                return true; 
            } else { 
                System.exit(0);//�����˳����� 
            } 
        } 
        return super.onKeyUp(keyCode, event); 
    } 
	
}
