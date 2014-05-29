package com.example.hiapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ShowVoteActivity extends ListActivity {

    private String[] strs;	
    private Integer[] nums;
    private ImageView button_back;
    private int numChoice;
    private ImageView voting_image;
    private TextView voting_title;
    private TextView voting_from;    
    private TextView voting_description;
	private SimpleAdapter adapter; 
    
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_vote_result);
        Bundle bundle = getIntent().getExtras();
        getData(bundle.getInt("KEY_ID"));
        adapter = new SimpleAdapter(this, getData(), R.layout.list_row_vote_item, 
        		new String[]{"voting_string","voting_num"},
        		new int[]{R.id.voting_string,R.id.voting_num});  
		setListAdapter(adapter);                
        findViews();
   	 	showResults();
		setListensers();        
    } 
    
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map;
		for(int i = 0; i < numChoice; i++)
		{
			map = new HashMap<String, Object>();
			map.put("voting_string", strs[i]);
			map.put("voting_num",nums[i]);
			list.add(map);
		}
		return list;
	}
	
    private void getData(int id)
	{	    	
    	//从网络获取id的投票信息
    	numChoice = 6;
    	strs = new String[numChoice];
    	nums = new Integer[numChoice];
    	strs[0] = "太坑了"; nums[0] = 10;
    	strs[1] = "说敢说他不坑？"; nums[1] = 29;
    	strs[2] = "必须坑"; nums[2] = 11;
    	strs[3] = "顶楼上"; nums[3] = 9;
    	strs[4] = "1L说得有道理"; nums[4] = 3;
    	strs[5] = "坑得男默女泪";  nums[5] = 2;  
    	
	}
    
    private void findViews()
	{	 
    	 button_back = (ImageView) findViewById(R.id.go_back_button);
    	 voting_image = (ImageView) findViewById(R.id.voting_image);
    	 voting_title = (TextView) findViewById(R.id.voting_title);
    	 voting_from = (TextView) findViewById(R.id.voting_from);   
    	 voting_description = (TextView) findViewById(R.id.voting_description); 	 		
	}  
    
    private void showResults()
    {  	
        voting_image.setImageResource(R.drawable.vote_image);
        voting_title.setText("王世衡坑不坑");
        voting_from.setText("杨帅");
        voting_description.setText("大家都懂的");
    }    
    
	private void setListensers() 
	{
		button_back.setOnClickListener(goBack);
	 }
	
	private Button.OnClickListener goBack = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			 ShowVoteActivity.this.finish();
		}
	}; 	
}
