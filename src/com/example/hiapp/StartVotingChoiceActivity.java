package com.example.hiapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.ClipData.Item;
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
import android.widget.TextView;

public class StartVotingChoiceActivity extends ListActivity {
	private SimpleAdapter adapter; 
	private ImageView choice_submit;
	private Integer numChoice;
	private Map<String,String> newVoting;
	private ImageView button_goBack;
	private String VotingName,VotingDescription;
	private List<Map<String, Object>> choiceList; 
	private ListView myListview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_begin_voting_choice);
		Bundle bundle = getIntent().getExtras();
		numChoice=Integer.parseInt((bundle.getString("KEY_NUMCHOICE")));
		VotingName=bundle.getString("KEY_VOTINGNAME");
		VotingDescription=bundle.getString("KEY_VOTINGDESCRIBE");
        adapter = new SimpleAdapter(this, getChoice(), R.layout.list_row_startvoting, 
        		new String[]{"choice_title"},
        		new int[]{R.id.textChoice});  
		setListAdapter(adapter);
		findViews();
		
		setListensers();
		
	}
	
	private void showResults() {
		newVoting=new HashMap<String,String>(); 
		newVoting.put("VotingName", VotingName);
		newVoting.put("VotingDescription", VotingDescription);
		newVoting.put("ChoiceNum", numChoice.toString());
		for(int i=0;i<numChoice;++i){
			TextView tv;
			tv=(TextView)(myListview.getChildAt(i)).findViewById(R.id.choiceContent);
			newVoting.put("Choice"+(i+1),(tv.getText()).toString() );
			
		}
		//int i=1;
	}

	private void findViews()
	{		
		choice_submit = (ImageView) findViewById(R.id.choice_submit_button);
		button_goBack =	(ImageView) findViewById(R.id.go_back_button);
		myListview=this.getListView();
		
		
	}
	private void setListensers() 
	{
		choice_submit.setOnClickListener(choiceSubmitListener);
		button_goBack.setOnClickListener(goBack);
	 }
	
	private Button.OnClickListener choiceSubmitListener = new Button.OnClickListener()
	
	{
		public void onClick(View v)
		{
			showResults();
			StartVotingChoiceActivity.this.finish();
		}
	}; 	
	   
	
	private List<Map<String, Object>> getChoice() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		for(int i=0;i<numChoice;++i){
			map.put("choice_title", "СЎПо"+i);
			list.add(map);
			map = new HashMap<String, Object>();
		}
		return list;
	}	
	private Button.OnClickListener goBack = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  // Close this Activity
			  StartVotingChoiceActivity.this.finish();
		 }
	 }; 

}
