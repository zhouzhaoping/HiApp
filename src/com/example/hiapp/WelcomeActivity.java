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
		 Timer timer = new Timer();//timer����һ���߳�,����̲߳���ִ��task
		 TimerTask task = new TimerTask() { //timertaskʵ��runnable�ӿ�,TimerTask��ʹ���һ����ָ��ʱ����ִ�е�task
			 @Override
			 public void run() {
				  Intent intent = new Intent();
				  intent.setClass(WelcomeActivity.this, LoginActivity.class);
				  startActivity(intent);				  
				  WelcomeActivity.this.finish();				  
			 }
		 };
		 timer.schedule(task, 1000 * second);//�������task���ӳ�����֮���Զ�ִ��
	}
}
