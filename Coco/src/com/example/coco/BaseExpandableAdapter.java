package com.example.coco;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseExpandableAdapter extends BaseExpandableListAdapter {
	  private ArrayList<String> groupList = null;
	    private ArrayList<ArrayList<String>> childList = null;
	    private LayoutInflater inflater = null;
	    private ViewHolder viewHolder = null;
	     
	    public BaseExpandableAdapter(Context c, ArrayList<String> groupList, 
	            ArrayList<ArrayList<String>> childList){
	        super();
	        this.inflater = LayoutInflater.from(c);
	        this.groupList = groupList;
	        this.childList = childList;
	    }
	     
	    // �׷� �������� ��ȯ�Ѵ�.
	    @Override
	    public String getGroup(int groupPosition) {
	        return groupList.get(groupPosition);
	    }
	 
	    // �׷� ����� ��ȯ�Ѵ�.
	    @Override
	    public int getGroupCount() {
	        return groupList.size();
	    }
	 
	    // �׷� ID�� ��ȯ�Ѵ�.
	    @Override
	    public long getGroupId(int groupPosition) {
	        return groupPosition;
	    }
	 
	    // �׷�� ������ ROW 
	    @Override
	    public View getGroupView(int groupPosition, boolean isExpanded,
	            View convertView, ViewGroup parent) {
	         
	    	 View v = convertView;
	         //ViewHolder��, �̸� �״�� ����� Ȧ���� �žƳ����� �����ϴ� ��ü�� ���Ѵ�. 
	    	 //������ ROW�� �׷��� ��, �� ���� �������� �Ӽ��� �����ϱ� ���� findViewById�� ȣ���ϴµ� �̰��� ����� ū ���� ���̱� ���� ����Ѵ�. 
	    	 
	    	 
	    	 //ĳ�õ� View�� ���� ��쿡�� ���� �����ϰ� ViewHolder�� �����Ѵ�. 
	         if(v == null){
	             viewHolder = new ViewHolder();
	             v = inflater.inflate(R.layout.list_row, parent, false);
	             viewHolder.tv_groupName = (TextView) v.findViewById(R.id.tv_group);
	            
	             v.setTag(viewHolder);
	         }else{
	        	 //ĳ�õ� View�� ���� ��쿡�� ����� ��Ȧ���� ����Ѵ�. 
	             viewHolder = (ViewHolder)v.getTag();
	         }

	         viewHolder.tv_groupName.setText(getGroup(groupPosition));
	        return v;
	    }
	     
	    // ���ϵ�並 ��ȯ�Ѵ�.
	    @Override
	    public String getChild(int groupPosition, int childPosition) {
	        return childList.get(groupPosition).get(childPosition);
	    }
	     
	    // ���ϵ�� ����� ��ȯ�Ѵ�.
	    @Override
	    public int getChildrenCount(int groupPosition) {
	        return childList.get(groupPosition).size();
	    }
	 
	    // ���ϵ�� ID�� ��ȯ�Ѵ�.
	    @Override
	    public long getChildId(int groupPosition, int childPosition) {
	        return childPosition;
	    }
	 
	    // ���ϵ�� ������ ROW
	    @Override
	    public View getChildView(int groupPosition, int childPosition,
	            boolean isLastChild, View convertView, ViewGroup parent) {
	         
	        View v = convertView;
	         
	        if(v == null){
	            viewHolder = new ViewHolder();
	            v = inflater.inflate(R.layout.list_row, null);
	            viewHolder.tv_childName = (TextView) v.findViewById(R.id.tv_child);
	            v.setTag(viewHolder);
	        }else{
	            viewHolder = (ViewHolder)v.getTag();
	        }
	         
	        viewHolder.tv_childName.setText(getChild(groupPosition, childPosition));
	         
	        return v;
	    }
	 
	    @Override
	    public boolean hasStableIds() { return true; }
	 
	    @Override
	    public boolean isChildSelectable(int groupPosition, int childPosition) { return true; }
	     
	    class ViewHolder {
	        public ImageView iv_image;
	        public TextView tv_groupName;
	        public TextView tv_childName;
	    }
	 
}
