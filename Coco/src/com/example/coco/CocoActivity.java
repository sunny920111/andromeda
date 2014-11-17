package com.example.coco;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

//tab layout을 구현하기 위해서는 FragmentActivity와 Fragment가 필요하다.
//FragmentActivity은 하나의 틀이고, Fragment는 각 탭 화면에 대한 상세설계라고 생각하면 된다.
public class CocoActivity extends FragmentActivity implements ActionBar.TabListener {
	
	//각 탭에 대한 레이아웃을 지정할 수 있는 class , 우리가 정의해야 한다. 
	AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	
	//수평으로  view를 좌우로 스크롤할때 사용하는 class , 라이브러리에서 제공 
    ViewPager mViewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*
		 * onCreate할때 Bundle을 저장하는데 이는프로세스가 메모리부족등으로
		 * kill된 후에 다시 복원 될때, 해당하는 savedInstance 정보를 가지고 자동으로 복원해준다. 
		 * */
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	
	    
	    //각 탭을 정의하고, 탭에 대한 해당하는 레이아웃과 기능을 정의한다. 
	    //getSupportFragmentManager은 FragmentActivity 각 fragment을 관리할 수 있는 manager를 return해준다. 
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // action Bar를 선언한다. 
        final ActionBar actionBar = getActionBar();

        actionBar.setHomeButtonEnabled(false);

        // display mode를 선언한다. 
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //activity_main에서 선언한 viewpager를 id를 통해서 가져온다.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        
       //각 탭이 이동할때, action에 애해 정의를 해준다.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
	}
	@Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.coco, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
