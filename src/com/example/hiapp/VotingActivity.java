package com.example.hiapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class VotingActivity extends ListActivity {
	private SimpleAdapter adapter; 
	private ImageView button_back;
	private ImageView button_new;
	private ListView listview;
	private List<Integer> idList;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vote);
        adapter = new SimpleAdapter(this, getData(), R.layout.list_row_votelist, 
        		new String[]{"voting_title","voting_from","voting_description","voting_image"},
        		new int[]{R.id.voting_title,R.id.voting_from,R.id.voting_description,R.id.voting_image});  
		setListAdapter(adapter);
		findViews();
		setListensers();
	}
	
	private void findViews()
	{		
		button_back = (ImageView) findViewById(R.id.go_back_button);
		button_new = (ImageView) findViewById(R.id.go_add_button);
		listview = getListView(); 
	}
	private void setListensers() 
	{
		button_back.setOnClickListener(goBack);
		button_new.setOnClickListener(Newvote);
	 }
	
	private Button.OnClickListener goBack = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			 VotingActivity.this.finish();
		}
	}; 	
	private Button.OnClickListener Newvote = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			Intent intent = new Intent();
	        intent.setClass(VotingActivity.this, StartVotingActivity.class);
	        Bundle bundle = new Bundle();      
		  	intent.putExtras(bundle);
		  	startActivity(intent);     
			//VotingActivity.this.finish();
		}
	};
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		idList = new ArrayList<Integer>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("voting_title", "王尼玛坑不坑");
		map.put("voting_from", "杨帅");
		map.put("voting_description", "大家都懂的");
		map.put("voting_image", R.drawable.vote_image);
		list.add(map);
		idList.add(10);
		list.add(map);
		idList.add(1);
		list.add(map);
		idList.add(24);
		return list;
	}	
	
	
    @Override   
    protected void onListItemClick(ListView l, View v, int position, long id) {  
        
    	int ID = idList.get(position);
        Intent intent = new Intent();
        intent.setClass(VotingActivity.this, OneVoteActivity.class);
        Bundle bundle = new Bundle();      
        bundle.putInt("KEY_ID", ID);
	  	intent.putExtras(bundle);
	  	startActivity(intent);     
        super.onListItemClick(l, v, position, id);  
    }  
}
