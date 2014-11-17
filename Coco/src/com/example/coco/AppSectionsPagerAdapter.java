package com.example.coco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class AppSectionsPagerAdapter extends FragmentPagerAdapter {

	//CocoActivity에서 가져온 FragmentManager
	public AppSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	 @Override
     public Fragment getItem(int i) {

		 //각 fragment를 정의하는 class이다.
         Fragment fragment = new DummySectionFragment();
         
         //각 탭에 대한 상태 정보를 저장하기 위해 Bundle이라는 class를 사용한다.
         //key,value 형태의 map class이다.
         Bundle args = new Bundle();

         /*
          * 이와 비슷한것으로 Intent라는 class가 있다. 
          * 
          * Bundle은 상태/ 등을 저장하기 위해 사용하는 객체이며,
          * Intentㅇ는 저장이 아닌 전달하는 수단으로 사용하기 위한 객체이다. 
          * 
          * 여기에서는 각 탭에 대한 정보를 담기 위해서 bundle을 사용한 것이며,
          * intent는 각 activity간에 메시지를 전달할 때 사용한다. 
          * 
          * 사용방법은 bundle과 유사하며,
          * intent.putExtra("key",value)
          
          * */
         args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
         fragment.setArguments(args);
         return fragment;
         
     }

     @Override
     public int getCount() {
         return 3;
     }

     @Override
     public CharSequence getPageTitle(int position) {
         return "Section " + (position + 1);
     }
     
 
     
     /*
      * 각 fragment를 정의하기 위한 inner class로 fragment를 extend한다. 
      * */
     public static class DummySectionFragment extends Fragment {
    		public static final String ARG_SECTION_NUMBER = "section_number";
    		//각 탭에 넣을 view를 정의하기 위한 함수이다. 
    		//LayoutInflater은 xml에 정의된 레이아웃들을 view의 형태로 반환해주는 역할을 한다. 
    	    @Override
    	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    	            Bundle savedInstanceState) {
    	    	//defaultf로	fragment_section_dummy.xml을 view로 불러온다.
    	    	View rootView = inflater.inflate(R.layout.fragment_section_dummy, container, false);
    	    	
    	    	//AppSectionsPagerAdapter에서 보낸 bundle을 가져온다.
    	    	Bundle args = getArguments();

    	    	// 첫번째 화면일 경우에 선언하는 화면 
    	    	if( args.getInt(ARG_SECTION_NUMBER)==1){
    	    		
    	    	 //	activity_coco.xml을 view로 불러온다.
    	    	 rootView = inflater.inflate(R.layout.activity_coco,container,false);
    	    	 final EditText startDateRange = ((EditText) rootView.findViewById(R.id.startDateRange));
    	    	 final EditText endDateRange = ((EditText) rootView.findViewById(R.id.endDateRange));
    	    	
    	    	 final Calendar myCalendar = Calendar.getInstance();

    	    	 final DatePickerDialog.OnDateSetListener startDate = new DatePickerDialog.OnDateSetListener() {

    	    		    @Override
    	    		    public void onDateSet(DatePicker view, int year, int monthOfYear,
    	    		            int dayOfMonth) {
    	    		        // TODO Auto-generated method stub
    	    		    	SimpleDateFormat sdf = setDateTimeOnAlertDialog(view,year,monthOfYear,dayOfMonth,myCalendar);
    	        	        startDateRange.setText(sdf.format(myCalendar.getTime()));
    	    		    }

    	    		};
    	    		
    	    		
    	    	  final DatePickerDialog.OnDateSetListener endDate = new DatePickerDialog.OnDateSetListener() {

    	    		    @Override
    	    		    public void onDateSet(DatePicker view, int year, int monthOfYear,
    	    		            int dayOfMonth) {
    	    		        // TODO Auto-generated method stub
    	    		        
    	    		    	SimpleDateFormat sdf = setDateTimeOnAlertDialog(view,year,monthOfYear,dayOfMonth,myCalendar);
    	        	        endDateRange.setText(sdf.format(myCalendar.getTime()));
    	    		    }

    	    		};
    	    		
    	    		
    	    		startDateRange.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							  new DatePickerDialog(v.getContext(), startDate, myCalendar
					                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
					                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
						}
					});
    	    		
    	    		endDateRange.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							  new DatePickerDialog(v.getContext(), endDate, myCalendar
					                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
					                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
						}
					});
    	    		
    	    		makeExpandableListViewData(rootView);
    	    	}else{
    	    		
        	        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
        	                getString(R.string.dummy_section_text, args.getInt(ARG_SECTION_NUMBER)));
    	    	}
    	      
    	      
    	        return rootView;
    	    }
    	    public SimpleDateFormat setDateTimeOnAlertDialog(DatePicker view, int year, int monthOfYear,int dayOfMonth,Calendar myCalendar){
    	    	myCalendar.set(Calendar.YEAR, year);
		        myCalendar.set(Calendar.MONTH, monthOfYear);
		        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		        String myFormat = "yyyy/MM/dd"; //In which you need put here
    	        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);
    	        
    	        return sdf;
    	    }
    	    public void makeExpandableListViewData(View rootView){
    	    	 ExpandableListView  mListView = (ExpandableListView) rootView.findViewById(R.id.cardItemExpandableList);
    	    	 
    	    	 
    	    	 ArrayList<String> mGroupList = null;
    	         ArrayList<ArrayList<String>> mChildList = null;
    	         ArrayList<String> mChildListContent = null;
    	         
    	    	 mGroupList = new ArrayList<String>();
    	         mChildList = new ArrayList<ArrayList<String>>();
    	         mChildListContent = new ArrayList<String>();
    	  
    	         mGroupList.add("Hyundai Card");
    	         mGroupList.add("Samsung Card");
    	         mGroupList.add("Total Amount");
    	         
    	         mChildListContent.add("할부액 :");
    	         mChildListContent.add("일시불 : ");
    	         mChildListContent.add("토   탈 :");
    	  
    	         mChildList.add(mChildListContent);
    	         mChildList.add(mChildListContent);
    	         mChildList.add(mChildListContent);
    	         
    	         mListView.setAdapter(new BaseExpandableAdapter(rootView.getContext(), mGroupList, mChildList));
    	    }
    	
    }


}
