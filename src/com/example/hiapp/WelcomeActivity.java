package com.example.hiapp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_welcome);
	 autoSwitch(2);	 
	}
	 
	private void autoSwitch(int second)
	{
		 Timer timer = new Timer();//timer中有一个线程,这个线程不断执行task
		 TimerTask task = new TimerTask() { //timertask实现runnable接口,TimerTask类就代表一个在指定时间内执行的task
			 @Override
			 public void run() {
				  Intent intent = new Intent();
				  intent.setClass(WelcomeActivity.this, LoginActivity.class);
				  startActivity(intent);				  
				  WelcomeActivity.this.finish();				  
			 }
		 };
		 timer.schedule(task, 1000 * second);//设置这个task在延迟三秒之后自动执行
	}
}
