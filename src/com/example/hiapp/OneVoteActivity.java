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
    	//�������ȡid��ͶƱ��Ϣ
    	numChoice = 6;
    	strs = new String[numChoice];
    	strs[0] = "̫����";
    	strs[1] = "˵��˵�����ӣ�";
    	strs[2] = "�����";
    	strs[3] = "��¥��";
    	strs[4] = "1L˵���е���";
    	strs[5] = "�ӵ���ĬŮ��";     	
	}  
    
    
    private void findViews()
	{	 
		 submitButton = (ImageView) findViewById(R.id.go_confirm_button);
		 gobackButton = (ImageView) findViewById(R.id.go_back_button);
    	 lv = (ListView) findViewById(R.id.choices_listview);//�õ�ListView��������� /*ΪListView����Adapter��������*/ 
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
        voting_title.setText("������Ӳ���");
        voting_from.setText("��˧");
        voting_description.setText("��Ҷ�����");
    }
    
	 public void updateData()
	 {
		 //�����޸ĺ����Ϣ
	 }
	 
	 private void setListensers() {
		 submitButton.setOnClickListener(submitListener);
		 gobackButton.setOnClickListener(goBack);	
	 }
	 private Button.OnClickListener submitListener = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  new AlertDialog.Builder(OneVoteActivity.this).setTitle("ȷ���ύѡƱ��") 
			  .setIcon(android.R.drawable.ic_dialog_info)  
			  .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() { 
 
				  @Override 
				  public void onClick(DialogInterface dialog, int which) { 
					  OneVoteActivity.this.updateData();
					  Toast.makeText(OneVoteActivity.this, "�ύѡƱ�ɹ�", 
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
			  .setNegativeButton("����", new DialogInterface.OnClickListener() { 
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
