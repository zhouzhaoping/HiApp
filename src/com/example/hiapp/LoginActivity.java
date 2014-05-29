package com.example.hiapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_login);
	 findViews();
	 showResults();
	 setListensers(); 
	}
	 	 
	 private Button button_goback;
	 private EditText view_username;
	 private EditText view_password;
	 	 
	 private void findViews()
	 {
		 button_goback = (Button) findViewById(R.id.signin_button);
		 view_username = (EditText) findViewById(R.id.username_edit);
		 view_password = (EditText) findViewById(R.id.password_edit);
	 }
	 private void showResults() {

	 }
	 
	 private void setListensers() {
		 button_goback.setOnClickListener(backMain);
	 }
	 
	 private Button.OnClickListener backMain = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  // Close this Activity
			  Intent intent = new Intent();
			  intent.setClass(LoginActivity.this, MainActivity.class);
			  Bundle bundle = new Bundle();
			  bundle.putString("KEY_USERNAME", view_username.getText().toString());
			  bundle.putString("KEY_PASSWORD", view_password.getText().toString());
			  intent.putExtras(bundle);
			  startActivity(intent);
			  LoginActivity.this.finish();
		 }
	 }; 
}
