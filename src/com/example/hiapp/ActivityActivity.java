package com.example.hiapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class ActivityActivity extends ListActivity {
	
	private SimpleAdapter adapter; 
	private ImageView button_back;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_activity);
		adapter = new SimpleAdapter(this, getData(), R.layout.list_row_activity, 
	        		new String[]{"act_name","act_time","act_intro","act_main_pic"
	        	,"act_content1","act_small_pic1", "act_small_pic2","act_go"},
	        		new int[]{R.id.act_name,R.id.act_time,R.id.act_intro,R.id.act_main_pic
	        	, R.id.act_content1,R.id.act_small_pic1, R.id.act_small_pic2, R.id.act_go});  
	   setListAdapter(adapter);   
	   findViews();
	   setListensers();
	}
	
	private void findViews()
	{		
		button_back = (ImageView) findViewById(R.id.go_back_button);
	}
	private void setListensers() 
	{
		button_back.setOnClickListener(goBack);
	 }
	
	 private Button.OnClickListener goBack = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  ActivityActivity.this.finish();
		 }
	 };	
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("act_name", "��ׯˮ��");
		map.put("act_time", "2013.3.24");
		map.put("act_intro", "���;�����̤����տ�");
		map.put("act_content1", Util.ToDBC("��3�����������壬�����տ������˺���,���ǲ������˰����Ӷ���������,�����ɱ�˺ø���,��ȥ��·���Ҳ����೤̫��������"));
		map.put("act_main_pic", R.drawable.act_mian_pic_bg);
		map.put("act_small_pic1", R.drawable.act_small_pic_bg);
		map.put("act_small_pic2", R.drawable.act_small_pic_bg);		
		map.put("act_go", R.drawable.act_go_bg);	
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("act_name", "���ϲ�ԭ��");
		map.put("act_time", "2013.5.20");
		map.put("act_intro", "������������۾�");
		map.put("act_content1", "�����ϵ��Ů�����׳�����һ");
		map.put("act_main_pic", R.drawable.act_mian_pic_bg);
		map.put("act_small_pic1", R.drawable.act_small_pic_bg);
		map.put("act_small_pic2", R.drawable.act_small_pic_bg);		
		map.put("act_go", R.drawable.act_go_bg);	
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("act_name", "��˾DIY");
		map.put("act_time", "2012.11.5");
		map.put("act_intro", "һ�������Լ�����˾");
		map.put("act_content1", "��Ȼ������ѧ����㶼�������ˣ�̫������");

		map.put("act_main_pic", R.drawable.act_mian_pic_bg);
		map.put("act_small_pic1", R.drawable.act_small_pic_bg);
		map.put("act_small_pic2", R.drawable.act_small_pic_bg);	
		map.put("act_go", R.drawable.act_go_bg);	
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("act_name", "��̨��ѩ��");
		map.put("act_time", "2012.12.21");
		map.put("act_intro", "��װ�ع�����ѩ����");
		map.put("act_content1", "�и�˧�绮�úÿ찡������������");

		map.put("act_main_pic", R.drawable.act_mian_pic_bg);
		map.put("act_small_pic1", R.drawable.act_small_pic_bg);
		map.put("act_small_pic2", R.drawable.act_small_pic_bg);
		map.put("act_go", R.drawable.act_go_bg);	
		list.add(map);
		return list;
	}
}
