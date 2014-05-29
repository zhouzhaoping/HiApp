package com.example.hiapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ContactActivity extends ListActivity {

	private SimpleAdapter adapter; 
	private ImageView button_back;
	private ListView listview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_activity);
        adapter = new SimpleAdapter(this, getData(), R.layout.list_row_contact, 
        		new String[]{"person_name","person_telephone","person_introduction","person_profile"},
        		new int[]{R.id.person_name,R.id.person_telephone,R.id.person_introduction,R.id.person_profile});  
		setListAdapter(adapter);
		findViews();
		setListensers();
	}
	
	
	private void findViews()
	{		
		button_back = (ImageView) findViewById(R.id.go_back_button);
		listview = getListView(); 
	}
	private void setListensers() 
	{
		button_back.setOnClickListener(goBack);
		ItemOnLongClick();
	 }
	
	private Button.OnClickListener goBack = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			 ContactActivity.this.finish();
		}
	}; 	
	
	
    private void ItemOnLongClick() {
    	listview.setOnCreateContextMenuListener(new OnCreateContextMenuListener()
    	{
    		@Override
    		public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("请选择操作");	
                menu.add(0, 0, 0, "拨号");
                menu.add(0, 1, 0, "短信");
    			menu.add(0, 2, 0, "删除");
    		}
    	});
    }
    	
    @Override
    public boolean onContextItemSelected(MenuItem item) {

            AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

            int id = (int) info.id;// 这里的info.id对应的就是数据库中_id的值
            switch (item.getItemId()) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;
            }
            return super.onContextItemSelected(item);
    }
    
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("person_name", "杨帅");
		map.put("person_telephone", "1520*****68");
		map.put("person_introduction", "啊啊啊啊啊啊，我讨厌当美工！烦死啦啦啦啦啦啦！啊啊啊啊啊啊，我讨厌当美工！烦死啦啦啦啦啦啦！");
		map.put("person_profile", R.drawable.person_profile_image);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("person_name", "黄元");
		map.put("person_telephone", "1881*******");
		map.put("person_introduction", "黄元又在黑人啦~黄元又在黑人啦~黄元又在黑人啦~");
		map.put("person_profile", R.drawable.person_profile_image);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("person_name", "王尼玛");
		map.put("person_telephone", "1881*******");
		map.put("person_introduction", "你快点给我自学安卓啊！快点！快点！");
		map.put("person_profile", R.drawable.person_profile_image);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("person_name", "段祎纯");
		map.put("person_telephone", "1881*******");
		map.put("person_introduction", "我这么随便一写就是标准的十五字");
		map.put("person_profile", R.drawable.person_profile_image);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("person_name", "崔治承");
		map.put("person_telephone", "1881*******");
		map.put("person_introduction", "我有一种名字敲错了的感觉");
		map.put("person_profile", R.drawable.person_profile_image);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("person_name", "周钊平");
		map.put("person_telephone", "1881*******");
		map.put("person_introduction", "操统实习要挂科了！！！！！");
		map.put("person_profile", R.drawable.person_profile_image);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("person_name", "李家耀");
		map.put("person_telephone", "1881*******");
		map.put("person_introduction", "软件工程怎么破！");
		map.put("person_profile", R.drawable.person_profile_image);
		list.add(map);
		return list;
	}	
}
