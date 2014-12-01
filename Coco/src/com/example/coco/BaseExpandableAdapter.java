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
	     
	    // 그룹 포지션을 반환한다.
	    @Override
	    public String getGroup(int groupPosition) {
	        return groupList.get(groupPosition);
	    }
	 
	    // 그룹 사이즈를 반환한다.
	    @Override
	    public int getGroupCount() {
	        return groupList.size();
	    }
	 
	    // 그룹 ID를 반환한다.
	    @Override
	    public long getGroupId(int groupPosition) {
	        return groupPosition;
	    }
	 
	    // 그룹뷰 각각의 ROW 
	    @Override
	    public View getGroupView(int groupPosition, boolean isExpanded,
	            View convertView, ViewGroup parent) {
	         
	    	 View v = convertView;
	         //ViewHolder란, 이름 그대로 뷰들을 홀더에 꼽아놓듯이 보관하는 객체를 말한다. 
	    	 //각각의 ROW를 그려낼 때, 그 안의 위젯들의 속성을 변경하기 위해 findViewById를 호충하는데 이것의 비용이 큰 것을 줄이기 위해 사용한다. 
	    	 
	    	 
	    	 //캐시된 View가 없을 경우에는 새로 생성하고 ViewHolder를 생성한다. 
	         if(v == null){
	             viewHolder = new ViewHolder();
	             v = inflater.inflate(R.layout.list_row, parent, false);
	             viewHolder.tv_groupName = (TextView) v.findViewById(R.id.tv_group);
	            
	             v.setTag(viewHolder);
	         }else{
	        	 //캐시된 View가 있을 경우에는 저장된 뷰홀더를 사용한다. 
	             viewHolder = (ViewHolder)v.getTag();
	         }

	         viewHolder.tv_groupName.setText(getGroup(groupPosition));
	        return v;
	    }
	     
	    // 차일드뷰를 반환한다.
	    @Override
	    public String getChild(int groupPosition, int childPosition) {
	        return childList.get(groupPosition).get(childPosition);
	    }
	     
	    // 차일드뷰 사이즈를 반환한다.
	    @Override
	    public int getChildrenCount(int groupPosition) {
	        return childList.get(groupPosition).size();
	    }
	 
	    // 차일드뷰 ID를 반환한다.
	    @Override
	    public long getChildId(int groupPosition, int childPosition) {
	        return childPosition;
	    }
	 
	    // 차일드뷰 각각의 ROW
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
