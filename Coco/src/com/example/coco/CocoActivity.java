package com.example.coco;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

//tab layout�� �����ϱ� ���ؼ��� FragmentActivity�� Fragment�� �ʿ��ϴ�.
//FragmentActivity�� �ϳ��� Ʋ�̰�, Fragment�� �� �� ȭ�鿡 ���� �󼼼����� �����ϸ� �ȴ�.
public class CocoActivity extends FragmentActivity implements ActionBar.TabListener {
	
	//�� �ǿ� ���� ���̾ƿ��� ������ �� �ִ� class , �츮�� �����ؾ� �Ѵ�. 
	AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	
	//��������  view�� �¿�� ��ũ���Ҷ� ����ϴ� class , ���̺귯������ ���� 
    ViewPager mViewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*
		 * onCreate�Ҷ� Bundle�� �����ϴµ� �̴����μ����� �޸𸮺���������
		 * kill�� �Ŀ� �ٽ� ���� �ɶ�, �ش��ϴ� savedInstance ������ ������ �ڵ����� �������ش�. 
		 * */
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	
	    
	    //�� ���� �����ϰ�, �ǿ� ���� �ش��ϴ� ���̾ƿ��� ����� �����Ѵ�. 
	    //getSupportFragmentManager�� FragmentActivity �� fragment�� ������ �� �ִ� manager�� return���ش�. 
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // action Bar�� �����Ѵ�. 
        final ActionBar actionBar = getActionBar();

        actionBar.setHomeButtonEnabled(false);

        // display mode�� �����Ѵ�. 
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //activity_main���� ������ viewpager�� id�� ���ؼ� �����´�.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        
       //�� ���� �̵��Ҷ�, action�� ���� ���Ǹ� ���ش�.
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
