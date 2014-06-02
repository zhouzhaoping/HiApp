package com.example.hiapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nettools.NetThread;


import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.SimpleAdapter.ViewBinder;

public class ActivityActivity extends ListActivity {
	
	private SimpleAdapter adapter; 
	private ImageView button_back;
	private ImageView button_add;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_activity);
		
		NetThread t = new NetThread("getActivityList", 100, 1100012847, null, null, null, -1, null, null);
		t.BeginDeal();
		
		adapter = new SimpleAdapter(this, t.getDataList(), R.layout.list_row_activity, 
	        		new String[]{"act_name","act_time","act_intro","act_main_pic"
	        	,"act_content1","act_small_pic1", "act_small_pic2","act_go"},
	        		new int[]{R.id.act_name,R.id.act_time,R.id.act_intro,R.id.act_main_pic
	        	, R.id.act_content1,R.id.act_small_pic1, R.id.act_small_pic2, R.id.act_go});
		
	   adapter.setViewBinder(new ViewBinder(){
			@Override
			public boolean setViewValue(View view, Object data,	String textRepresentation) {
				if (view instanceof ImageView && data instanceof Bitmap) {
					ImageView iv = (ImageView)view;
					iv.setImageBitmap((Bitmap) data);
					return true;
				}
				return false;
			}
	   });
	   setListAdapter(adapter);   
	   findViews();
	   setListensers();
	}
	
	private void findViews()
	{		
		button_back = (ImageView) findViewById(R.id.go_back_button);
		button_add = (ImageView) findViewById(R.id.go_add_button);
	}
	private void setListensers() 
	{
		button_back.setOnClickListener(goBack);
		button_add.setOnClickListener(goAdd);
	 }
	
	 private Button.OnClickListener goBack = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  ActivityActivity.this.finish();
		 }
	 };	
	 private Button.OnClickListener goAdd = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  Intent intent = new Intent();
			  intent.setClass(ActivityActivity.this, SendMessageActivity.class);
			  Bundle bundle = new Bundle();
			  intent.putExtras(bundle);
			  startActivity(intent);

			  
		 }
	 };	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("act_name", "上庄水库");
		map.put("act_time", "2013.3.24");
		map.put("act_intro", "春和景明，踏青吃烧烤");
		map.put("act_content1", Util.ToDBC("从3班请来了翔叔，烤的烧烤引发了哄抢,刚是不是有人把椅子都到湖里了,下午的杀人好给力,过去的路上找不到班长太不给力了"));
		map.put("act_main_pic", R.drawable.act_mian_pic_bg);
		map.put("act_small_pic1", R.drawable.act_small_pic_bg);
		map.put("act_small_pic2", R.drawable.act_small_pic_bg);		
		map.put("act_go", R.drawable.act_go_bg);	
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("act_name", "坝上草原行");
		map.put("act_time", "2013.5.20");
		map.put("act_intro", "长河落日骑马观景");
		map.put("act_content1", "计算机系男女比例首超二比一");
		map.put("act_main_pic", R.drawable.act_mian_pic_bg);
		map.put("act_small_pic1", R.drawable.act_small_pic_bg);
		map.put("act_small_pic2", R.drawable.act_small_pic_bg);		
		map.put("act_go", R.drawable.act_go_bg);	
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("act_name", "寿司DIY");
		map.put("act_time", "2012.11.5");
		map.put("act_intro", "一起制作自己的寿司");
		map.put("act_content1", "居然把整个学五二层都包下来了，太阔绰了");

		map.put("act_main_pic", R.drawable.act_mian_pic_bg);
		map.put("act_small_pic1", R.drawable.act_small_pic_bg);
		map.put("act_small_pic2", R.drawable.act_small_pic_bg);	
		map.put("act_go", R.drawable.act_go_bg);	
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("act_name", "丰台滑雪行");
		map.put("act_time", "2012.12.21");
		map.put("act_intro", "银装素裹，滑雪素拓");
		map.put("act_content1", "有个帅哥划得好快啊啊啊啊啊！！");

		map.put("act_main_pic", R.drawable.act_mian_pic_bg);
		map.put("act_small_pic1", R.drawable.act_small_pic_bg);
		map.put("act_small_pic2", R.drawable.act_small_pic_bg);
		map.put("act_go", R.drawable.act_go_bg);	
		list.add(map);
		return list;
	}
}
