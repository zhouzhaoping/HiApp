package com.example.hiapp;

import java.util.ArrayList;


import android.app.Activity;
import android.app.AlertDialog;
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


public class SendMessage extends Activity {
	
	public SendMessage() {
	}
	private TextView intext;
	 private Button confirm;
	 private EditText content;
	
	 public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState); 
			setContentView(R.layout.msg_send); 

			intext = (TextView) this.findViewById(R.id.intext); 
			content=(EditText) this.findViewById(R.id.inedit);
			confirm = (Button) this.findViewById(R.id.confirm); 
					 
			confirm.setOnClickListener(new Button.OnClickListener(){ 
			
			public void onClick(View arg0) { 
					//record the context!!!!
				
				
				Intent i = new Intent();              
                i.setClass(SendMessage.this, SendMsgFragment.class); 
                startActivity(i);
                SendMessage.this.finish();
				} 
			}); 
	 }
}

