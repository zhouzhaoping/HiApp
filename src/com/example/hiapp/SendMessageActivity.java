package com.example.hiapp;

import java.util.ArrayList;


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


public class SendMessageActivity extends Activity {
	
	public SendMessageActivity() {
	}
	private TextView intext;
	private TextView intext2;
	 private Button confirm;
	 private EditText content;
	 private EditText theme;
	
	 public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState); 
			setContentView(R.layout.activity_send); 

			intext = (TextView) this.findViewById(R.id.intext); 
			theme=(EditText) this.findViewById(R.id.theme);
			intext2 = (TextView) this.findViewById(R.id.intext2); 
			content=(EditText) this.findViewById(R.id.inedit);
			confirm = (Button) this.findViewById(R.id.confirm); 
					 
			confirm.setOnClickListener(new Button.OnClickListener(){ 
			
			public void onClick(View arg0) { 
					//record the context!!!!
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
			}); 
	 }
}
