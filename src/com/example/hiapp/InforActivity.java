package com.example.hiapp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nettools.NetThread;
import nettools.Variable;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class InforActivity extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.avtivity_infor);
	 findViews();
	 showResults();
	 setListensers();
	}
	 
	 private ImageView button_goconfig;
	 private TextView view_username;
	 private TextView view_usersex;
	 private TextView view_userbirth;
	 private TextView view_useruniver;
	 private TextView view_userclass;
	 private TextView view_userQQ;
	 private TextView view_usertel;
	 private TextView view_usersay;
	 private ImageView button_back;
	 
	 private void findViews()
	 {
		 button_goconfig = (ImageView) findViewById(R.id.go_config_button);
		 view_username = (TextView) findViewById(R.id.infor_username);
		 view_usersex = (TextView) findViewById(R.id.infor_usersex);
		 view_userbirth = (TextView) findViewById(R.id.infor_userbirth);
		 view_useruniver = (TextView) findViewById(R.id.infor_useruniver);
		 view_userclass = (TextView) findViewById(R.id.infor_userclass);
		 view_userQQ = (TextView) findViewById(R.id.infor_userQQ);
		 view_usertel = (TextView) findViewById(R.id.infor_usertel);
		 view_usersay = (TextView) findViewById(R.id.infor_usersay);
		 button_back = (ImageView) findViewById(R.id.go_back_button);
	 }
	 private void showResults() 
	 {
		 NetThread t = new NetThread("getUserInfor", 1, 1100012865, null, null, null, -1, null, null);
		 t.BeginDeal();
		 List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		 list = t.getDataList();
		 Map<String, Object> map = new HashMap<String, Object>();
		 map = list.get(0);
		 int i;
		 String temp = null;
		 String[] str = Variable.info;
		 String[] str2 = new String[10];
		 for (i = 0; i < str.length; i++){
			 str2[i] = map.get(str[i]).toString();
		 }
		 view_username.setText(str2[0]);
		 view_usersex.setText(str2[1]);
		 view_userbirth.setText(str2[2]);
		 view_useruniver.setText(str2[3]);
		 //view_userclass.setText(str2[4]);
		 view_userQQ.setText(str2[4]);
		 view_usertel.setText(str2[5]);
		 view_usersay.setText(str2[6]);
		 /*
		 view_username.setText("williamyang");
		 view_usersex.setText("男");
		 view_userbirth.setText("1991.10.22");
		 view_useruniver.setText("北京大学");
		 view_userclass.setText("11级计算机4班");
		 view_userQQ.setText("123456789");
		 view_usertel.setText("1520*****68");
		 view_usersay.setText("要死要死要死，大作业多得没人性T_T");
		 */
	 }
	 
	 private void setListensers() 
	 {
		 button_goconfig.setOnClickListener(goConfig);
		 button_back.setOnClickListener(goBack);		 
	 }
	 
	 private Button.OnClickListener goConfig = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  Intent intent = new Intent();
			  intent.setClass(InforActivity.this, EditInforActivity.class);
			  Bundle bundle = new Bundle();
			  bundle.putString("KEY_USERNAME", view_username.getText().toString());
			  bundle.putString("KEY_SEX", view_usersex.getText().toString());
			  bundle.putString("KEY_BIRTH", view_userbirth.getText().toString());
			  bundle.putString("KEY_UNIVER", view_useruniver.getText().toString());			  
			  bundle.putString("KEY_CLASS", view_userclass.getText().toString());
			  bundle.putString("KEY_QQ", view_userQQ.getText().toString());	
			  bundle.putString("KEY_TEL", view_usertel.getText().toString());
			  bundle.putString("KEY_SAY", view_usersay.getText().toString());
			  intent.putExtras(bundle);
			  startActivity(intent);	
			  InforActivity.this.finish();
		 }
	 }; 
	 
	private Button.OnClickListener goBack = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			 InforActivity.this.finish();
		}
	}; 	
}
