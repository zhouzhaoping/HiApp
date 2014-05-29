package com.example.hiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OneVoteActivity extends Activity {
	
    private ListView lv;
    private String[] strs;
    private ImageView submitButton;
    private ImageView gobackButton;
    private int numChoice;
    private int voting_id;
    private ImageView voting_image;
    private TextView voting_title;
    private TextView voting_from;    
    private TextView voting_description;
    
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_one_vote);
        Bundle bundle = getIntent().getExtras();
        voting_id = bundle.getInt("KEY_ID");
        getData(voting_id);
        findViews();
   	 	showResults();
		setListensers();
        
    } 
    
    private void getData(int id)
	{	    	
    	//从网络获取id的投票信息
    	numChoice = 6;
    	strs = new String[numChoice];
    	strs[0] = "太坑了";
    	strs[1] = "说敢说他不坑？";
    	strs[2] = "必须坑";
    	strs[3] = "顶楼上";
    	strs[4] = "1L说得有道理";
    	strs[5] = "坑得男默女泪";     	
	}  
    
    
    private void findViews()
	{	 
		 submitButton = (ImageView) findViewById(R.id.go_confirm_button);
		 gobackButton = (ImageView) findViewById(R.id.go_back_button);
    	 lv = (ListView) findViewById(R.id.choices_listview);//得到ListView对象的引用 /*为ListView设置Adapter来绑定数据*/ 
    	 voting_image = (ImageView) findViewById(R.id.voting_image);
    	 voting_title = (TextView) findViewById(R.id.voting_title);
    	 voting_from = (TextView) findViewById(R.id.voting_from);   
    	 voting_description = (TextView) findViewById(R.id.voting_description); 	 		
	}
   
    private void showResults()
    {  	
        lv.setAdapter(new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_checked, strs));
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        voting_image.setImageResource(R.drawable.vote_image);
        voting_title.setText("王世衡坑不坑");
        voting_from.setText("杨帅");
        voting_description.setText("大家都懂的");
    }
    
	 public void updateData()
	 {
		 //更新修改后的信息
	 }
	 
	 private void setListensers() {
		 submitButton.setOnClickListener(submitListener);
		 gobackButton.setOnClickListener(goBack);	
	 }
	 private Button.OnClickListener submitListener = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  new AlertDialog.Builder(OneVoteActivity.this).setTitle("确认提交选票吗？") 
			  .setIcon(android.R.drawable.ic_dialog_info)  
			  .setPositiveButton("确定", new DialogInterface.OnClickListener() { 
 
				  @Override 
				  public void onClick(DialogInterface dialog, int which) { 
					  OneVoteActivity.this.updateData();
					  Toast.makeText(OneVoteActivity.this, "提交选票成功", 
		                        Toast.LENGTH_SHORT).show();  
					  Intent intent = new Intent();
					  intent.setClass(OneVoteActivity.this, ShowVoteActivity.class);
					  Bundle bundle = new Bundle();		      	    			      	    
			      	  bundle.putInt("KEY_ID", voting_id);
			      	  intent.putExtras(bundle);
					  startActivity(intent);
					  OneVoteActivity.this.finish();					  
		        } 
			  })
			  .setNegativeButton("不是", new DialogInterface.OnClickListener() { 
				  @Override 
				  public void onClick(DialogInterface dialog, int which) { 					  
				  } 
			  }).show();
		 }
	 }; 
	 
	private Button.OnClickListener goBack = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			  OneVoteActivity.this.finish();
		}
	}; 	
}
