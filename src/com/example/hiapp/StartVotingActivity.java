package com.example.hiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class StartVotingActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_begin_voting);
			findViews();
			showResults();
			setListensers(); 
		}
		 	 
		 private Button button_goNext;
		 private ImageView button_goBack;
		 private EditText editText_VotingName;
		 private EditText editText_VotingDescribe;
		 private EditText editText_NumChoice;
		 	 
		 private void findViews()
		 {
			 button_goNext = (Button) findViewById(R.id.buttonBeginVoting);
			 button_goBack =	(ImageView) findViewById(R.id.go_back_button);
			 editText_VotingName = (EditText) findViewById(R.id.VotingName);
			 editText_VotingDescribe = (EditText) findViewById(R.id.VotingDescribe);
			 editText_NumChoice = (EditText) findViewById(R.id.NumChoice);
		 }
		 private void showResults() {

		 }
		 
		 private void setListensers() {
			 button_goNext.setOnClickListener(goNext);
			 button_goBack.setOnClickListener(goBack);
		 }
		 
		 private Button.OnClickListener goNext = new Button.OnClickListener()
		 {
			  public void onClick(View v)
			 {
				  // Close this Activity
				  Intent intent = new Intent();
				  intent.setClass(StartVotingActivity.this, StartVotingChoiceActivity.class);
				  Bundle bundle = new Bundle();
				  bundle.putString("KEY_VOTINGNAME", editText_VotingName.getText().toString());
				  bundle.putString("KEY_VOTINGDESCRIBE", editText_VotingDescribe.getText().toString());
				  String tmp=editText_NumChoice.getText().toString();
				  if(editText_NumChoice.getText().toString().isEmpty()||Integer.parseInt(editText_NumChoice.getText().toString())<2||Integer.parseInt(editText_NumChoice.getText().toString())>100)bundle.putString("KEY_NUMCHOICE", "2");
				  else bundle.putString("KEY_NUMCHOICE", editText_NumChoice.getText().toString());
				  intent.putExtras(bundle);
				  startActivity(intent);
				  StartVotingActivity.this.finish();
			 }
		 }; 
		 private Button.OnClickListener goBack = new Button.OnClickListener()
		 {
			  public void onClick(View v)
			 {
				  // Close this Activity
				  StartVotingActivity.this.finish();
			 }
		 }; 
}
