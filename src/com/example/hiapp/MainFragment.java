package com.example.hiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainFragment extends Fragment {
	public MainFragment() {		
	}
	
	private int type;
	private ImageView button0;
	private ImageView button1;
	private ImageView button2;
	private ImageView button3;
	private TextView hint;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main_dummy,
				container, false);
		
		findViews(rootView);
		showResults();
		setListensers();
		return rootView;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    type = getArguments().getInt("KEY_TYPE");
	}
	
	private void findViews(View rootView)
	{		
		button0 = (ImageView) rootView.findViewById(R.id.button_main_1);
		button1 = (ImageView) rootView.findViewById(R.id.button_main_2);
		button2 = (ImageView) rootView.findViewById(R.id.button_main_3);
		button3 = (ImageView) rootView.findViewById(R.id.button_main_4);
		hint = (TextView) rootView.findViewById(R.id.jisuanji_hint_main);
	}
	private void showResults() 
	{
		switch(type)
		{
		case 1:
			button0.setBackgroundResource(R.drawable.button_getmsg_background);
			button1.setBackgroundResource(R.drawable.button_sendmsg_background);
			button2.setBackgroundResource(R.drawable.button_tobecontinued_on);
			button3.setBackgroundResource(R.drawable.button_tobecontinued_on);
			button3.setVisibility(View.INVISIBLE);
			hint.setText("这里是消息区，你可以查看新消息");
			break;
		case 2:
			button0.setBackgroundResource(R.drawable.button_contact_background);
			button1.setBackgroundResource(R.drawable.button_info_background);
			button2.setBackgroundResource(R.drawable.button_tobecontinued_on);
			button3.setBackgroundResource(R.drawable.button_tobecontinued_on);
			button3.setVisibility(View.INVISIBLE);
			hint.setText("这里是通讯录，你可以查阅好友信息");
			break;
		case 0:
		default:
			button0.setBackgroundResource(R.drawable.button_activity_background);
			button1.setBackgroundResource(R.drawable.button_group_background);
			button2.setBackgroundResource(R.drawable.button_vote_background);
			button3.setBackgroundResource(R.drawable.button_tobecontinued_on);
			hint.setText("这里是活动区，你可以完成各种交互");
		}
	}	
	
	 private void setListensers() {
		 switch(type)
		 {
		 case 0:
			 button0.setOnClickListener(goActivity);
			 button2.setOnClickListener(goVoting);
			 break;
		 case 1:
			 button0.setOnClickListener(goGetMsg);
			 button1.setOnClickListener(goSendMsg);
			 button2.setOnClickListener(goSendAct);
			 break;
		 case 2:
			 button0.setOnClickListener(goContact);
			 button1.setOnClickListener(goInfor);
			 break;
		 }
	 }

	 private Button.OnClickListener goContact = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  // Close this Activity
			  Intent intent = new Intent();
			  intent.setClass(getActivity(), ContactActivity.class);
			  Bundle bundle = new Bundle();
			  intent.putExtras(bundle);
			  startActivity(intent);
		 }
	 }; 
	 
	 private Button.OnClickListener goActivity = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  // Close this Activity
			  Intent intent = new Intent();
			  intent.setClass(getActivity(), ActivityActivity.class);
			  Bundle bundle = new Bundle();
			  intent.putExtras(bundle);
			  startActivity(intent);
		 }
	 }; 
	 
	 private Button.OnClickListener goInfor = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  // Close this Activity
			  Intent intent = new Intent();
			  intent.setClass(getActivity(), InforActivity.class);
			  Bundle bundle = new Bundle();
			  intent.putExtras(bundle);
			  startActivity(intent);
		 }
	 }; 
	 
	 private Button.OnClickListener goGetMsg = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  // Close this Activity
			  Intent intent = new Intent();
			  intent.setClass(getActivity(), GetMessageActivity.class);
			  Bundle bundle = new Bundle();
			  intent.putExtras(bundle);
			  startActivity(intent);
		 }
	 }; 
	 private Button.OnClickListener goVoting = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  // Close this Activity
			  Intent intent = new Intent();
			  intent.setClass(getActivity(), VotingActivity.class);
			  Bundle bundle = new Bundle();
			  intent.putExtras(bundle);
			  startActivity(intent);
		 }
	 }; 	
	 private Button.OnClickListener goSendAct = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  // Close this Activity
			/*  Intent intent = new Intent();
			  intent.setClass(getActivity(), SendMessageActivity.class);
			  Bundle bundle = new Bundle();
			  intent.putExtras(bundle);
			  startActivity(intent);*/
		 }
	 };
	 private Button.OnClickListener goSendMsg = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  // Close this Activity
			  Intent intent = new Intent();
			  intent.setClass(getActivity(), SendMessage.class);
			  Bundle bundle = new Bundle();
			  intent.putExtras(bundle);
			  startActivity(intent);
		 }
	 };
}
