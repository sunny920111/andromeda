package com.example.coco;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

	public DemoCollectionPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int i) {
		// TODO Auto-generated method stub
		
		Fragment fragment = new DemoObjectFrament();
		Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(DemoObjectFrament.ARG_OBJECT, i + 1);
        fragment.setArguments(args);
        return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 100;
	}
	
	public CharSequence getPageTitle(int position){
		return "OBJECT "+(position+1);
	}

}
