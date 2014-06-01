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
		map.put("mse_from", "������");
		map.put("msg_time", "2014.05.15. 08:01");
		map.put("msg_content", Util.ToDBC("����+OO���롿��λ��Ա���鳤��ҹ���к�����ݴ���ĸ�ʽ�����µķֹ����͵���QȺ�" +
				"������ǰ�Ķ�����ǰ׼�������ǽ��ڱ��������缯�п���"));
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("mse_from", "������");
		map.put("msg_time", "2014.05.09 18:08");
		map.put("msg_content", Util.ToDBC("��λ��Ա�����Ǳ�����3:00~4:00��1423�����ᣬ������뿪������"));
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("mse_from", "������");
		map.put("msg_time", "2014.04.26 14:25");
		map.put("msg_content", Util.ToDBC("��λ��Ա�����������ճ����������硾2:00����1423���С���������Ϊ��1��00A��00D�ı�����滮��" +
				"2����������С��ļ�����չ����"));
		list.add(map);
		
		return list;
	}	
}
