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

	public AppSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	 @Override
     public Fragment getItem(int i) {

         Fragment fragment = new DummySectionFragment();
         Bundle args = new Bundle();
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
     
     public static class DummySectionFragment extends Fragment {
    		public static final String ARG_SECTION_NUMBER = "section_number";
    
    	    @Override
    	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    	            Bundle savedInstanceState) {
    	    	 
    	    	View rootView = inflater.inflate(R.layout.fragment_section_dummy, container, false);
    	    	Bundle args = getArguments();

    
    	    	if( args.getInt(ARG_SECTION_NUMBER)==1){
    	    		
    	    		
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

    	        	        if("".equals(startDateRange.getText())){
    	        	        	
    	        	        }else{
    	        	        	
    	        	        }
    	        	    
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
    	    	}else if( args.getInt(ARG_SECTION_NUMBER)==2){
    	    		 rootView = inflater.inflate(R.layout.activity_coco,container,false);
    	    		 
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
