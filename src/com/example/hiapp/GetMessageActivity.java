package com.example.hiapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nettools.NetThread;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class GetMessageActivity extends ListActivity {
	

	private ImageView button_back;
	private ImageView button_flush;
	private SimpleAdapter adapter; 
	
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.contact_activity);
	 findViews();
	 showResults();
	 setListensers(); 
	 
	 NetThread t = new NetThread("getMessages", 2, 1100012865, null, null, -1, null, null);
	 t.BeginDeal();
		
	 adapter = new SimpleAdapter(this, t.getDataList(), R.layout.list_row_message, 
        		new String[]{"mse_from","msg_time","msg_content"},
        		new int[]{R.id.msg_from,R.id.msg_time,R.id.msg_content});  
	 setListAdapter(adapter);   	 
	}
	 
	private void findViews()
	{		
		button_back = (ImageView) findViewById(R.id.go_back_button);
		button_flush = (ImageView) findViewById(R.id.go_add_button);
	}
	private void setListensers() 
	{
		button_back.setOnClickListener(goBack);
	}
	
	private void showResults()
	{
		button_flush.setImageResource(R.drawable.button_flush_background);
	}
	private Button.OnClickListener goBack = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			GetMessageActivity.this.finish();
		}
	};	
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mse_from", "王尼玛");
		map.put("msg_time", "2014.05.15. 08:01");
		map.put("msg_content", Util.ToDBC("【软工+OO编码】各位组员，组长连夜调研后把数据传输的格式和最新的分工发送到了Q群里。" +
				"请大家提前阅读，提前准备。我们将在本周日下午集中开发"));
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("mse_from", "王尼玛");
		map.put("msg_time", "2014.05.09 18:08");
		map.put("msg_content", Util.ToDBC("各位组员，我们本周日3:00~4:00在1423开例会，分配代码开发工作"));
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("mse_from", "王尼玛");
		map.put("msg_time", "2014.04.26 14:25");
		map.put("msg_content", Util.ToDBC("各位组员，本周例会照常在周日下午【2:00】在1423举行。会议流程为：1、00A和00D的报告与规划。" +
				"2、两个技术小组的技术进展报告"));
		list.add(map);
		
		return list;
	}	
}
