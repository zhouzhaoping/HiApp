package com.example.hiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditInforActivity extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_change_infor);
	 findViews();
	 showResults();
	 setListensers();
	}
	 
	 private ImageView button_goconfirm;
	 private TextView view_username;
	 private EditText view_usersex;
	 private EditText view_userbirth;
	 private EditText view_useruniver;
	 private EditText view_userclass;
	 private EditText view_userQQ;
	 private EditText view_usetel;
	 private EditText view_usersay;
	 private ImageView button_back;
	 
	 private void findViews()
	 {
		 button_goconfirm = (ImageView) findViewById(R.id.go_confirm_button);
		 view_username = (TextView) findViewById(R.id.infor_username);
		 view_usersex = (EditText) findViewById(R.id.getinfor_usersex);
		 view_userbirth = (EditText) findViewById(R.id.getinfor_userbirth);
		 view_useruniver = (EditText) findViewById(R.id.getinfor_useruniver);
		 view_userclass = (EditText) findViewById(R.id.getinfor_userclass);
		 view_userQQ = (EditText) findViewById(R.id.getinfor_userQQ);
		 view_usetel = (EditText) findViewById(R.id.getinfor_usertel);
		 view_usersay = (EditText) findViewById(R.id.getinfor_usersay);
		 button_back = (ImageView) findViewById(R.id.go_back_button);
	 }
	 private void showResults() 
	 {
		 Bundle bundle = this.getIntent().getExtras();
		 view_username.setText(bundle.getString("KEY_USERNAME"));
		 view_usersex.setText(bundle.getString("KEY_SEX"));
		 view_userbirth.setText(bundle.getString("KEY_BIRTH"));
		 view_useruniver.setText(bundle.getString("KEY_UNIVER"));
		 view_userclass.setText(bundle.getString("KEY_CLASS"));
		 view_userQQ.setText(bundle.getString("KEY_QQ"));
		 view_usetel.setText(bundle.getString("KEY_TEL"));
		 view_usersay.setText(bundle.getString("KEY_SAY"));
	 }
	 
	 private void setListensers() 
	 {
		 button_back.setOnClickListener(goBack);	
		 button_goconfirm.setOnClickListener(goConfirm);
	 }
	 
	 public void updateData()
	 {
		 //更新修改后的信息
	 }
	 
	 private Button.OnClickListener goConfirm = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  new AlertDialog.Builder(EditInforActivity.this).setTitle("确认保存当前修改吗？") 
			  .setIcon(android.R.drawable.ic_dialog_info)  
			  .setPositiveButton("确定", new DialogInterface.OnClickListener() { 
 
				  @Override 
				  public void onClick(DialogInterface dialog, int which) { 
					  EditInforActivity.this.updateData();
					  Toast.makeText(EditInforActivity.this, "修改信息保存成功", 
		                        Toast.LENGTH_SHORT).show(); 
		        } 
			  })
			  .setNegativeButton("不是", new DialogInterface.OnClickListener() { 
				  @Override 
				  public void onClick(DialogInterface dialog, int which) { 
					  // 点击“返回”后的操作,这里不设置没有任何操作 
				  } 
			  }).show();
		 }
	 }; 
	 
	private Button.OnClickListener goBack = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			  Intent intent = new Intent();
			  intent.setClass(EditInforActivity.this, InforActivity.class);
			  Bundle bundle = new Bundle();
			  intent.putExtras(bundle);
			  startActivity(intent);	
			  EditInforActivity.this.finish();
		}
	}; 	
}
