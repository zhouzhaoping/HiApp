package com.example.hiapp;

import java.util.ArrayList;

import nettools.NetThread;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class SendMessageActivity extends Activity {
	
	public SendMessageActivity() {
	}
	private TextView intext1;
	private TextView intext2;
	 private Button confirm;
	 private EditText inedit1;
	 private EditText inedit2;
	
	 public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState); 
			setContentView(R.layout.activity_send); 

			intext1 = (TextView) this.findViewById(R.id.intext); 
			inedit2=(EditText) this.findViewById(R.id.inedit2);
			intext2 = (TextView) this.findViewById(R.id.intext2); 
			inedit1=(EditText) this.findViewById(R.id.inedit);
			confirm = (Button) this.findViewById(R.id.confirm); 
					 
			confirm.setOnClickListener(new Button.OnClickListener(){ 
			
			public void onClick(View arg0) { 
					//record the context!!!!
				
				NetThread t = new NetThread("sendActivity", -1, -1, "1100012847", inedit1.getText().toString(), inedit2.getText().toString(), -1, null, null);
				t.BeginDeal();
				
				if (t.retCode == 0)
				{
					new AlertDialog.Builder(SendMessageActivity.this)
			         .setMessage("发布成功！")
			         .setPositiveButton("确定",
			          new DialogInterface.OnClickListener(){
			              public void onClick(DialogInterface dialoginterface, int i){
					
					//Intent intent = new Intent();              
	                //intent.setClass(SendMessageActivity.this, MainFragment.class); 
	                //startActivity(intent);
	                SendMessageActivity.this.finish();
			            	  
					} }).show();
				}
				else 
				{
					Toast.makeText(SendMessageActivity.this, "发布失败，再试试吧亲！", Toast.LENGTH_SHORT).show();
				}
			}
			}); 
	 }
}
