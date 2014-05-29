package com.example.hiapp;
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
		 view_username.setText("williamyang");
		 view_usersex.setText("��");
		 view_userbirth.setText("1991.10.22");
		 view_useruniver.setText("������ѧ");
		 view_userclass.setText("11�������4��");
		 view_userQQ.setText("123456789");
		 view_usertel.setText("1520*****68");
		 view_usersay.setText("Ҫ��Ҫ��Ҫ��������ҵ���û����T_T");
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
