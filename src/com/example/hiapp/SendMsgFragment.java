package com.example.hiapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SendMsgFragment extends Activity { 
	 
	TextView tv = null; 
	ListView lv = null; 
	Button btn_selectAll = null; 
	Button btn_confirm = null; 
	Button btn_calcel = null; 
	String name[] = { "��˧", "�εt��", "������", "�����", "������", "�ļ�", "����ة", "��Ԫ", "���ҫ", "��ˬ", "����ƽ"}; 
	 
	ArrayList<String> listStr = null; 
	private List<HashMap<String, Object>> list = null; 
	private MyAdapter adapter; 
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.send_msg_fragment); 
		 
		tv = (TextView) this.findViewById(R.id.tv); 
		lv = (ListView) this.findViewById(R.id.lv); 
		btn_selectAll = (Button) this.findViewById(R.id.selectall); 
		//btn_inverseSelect = (Button) this.findViewById(R.id.inverseselect); 
		btn_confirm = (Button) this.findViewById(R.id.confirm); 
		btn_calcel = (Button) this.findViewById(R.id.cancel); 
		showCheckBoxListView(); 
		 
		//ȫѡ 
		btn_selectAll.setOnClickListener(new Button.OnClickListener(){ 
		@Override
		 
		public void onClick(View arg0) { 
				listStr = new ArrayList<String>(); 
				for(int i=0;i<list.size();i++){ 
				MyAdapter.isSelected.put(i,true); 
				listStr.add(name[i]); 
				} 
				 
				adapter.notifyDataSetChanged();//ע����һ�������ϣ�����checkbox�޷���������״̬ 
				tv.setText("��ѡ��"+listStr.size()+"��"); 
			} 
		}); 
		 
		//��ѡ 
		 
		btn_confirm.setOnClickListener(new Button.OnClickListener(){ 
		@Override
			public void onClick(View v) { 
				for(int i=0;i<list.size();i++){ 
				 
					if(MyAdapter.isSelected.get(i)==true){ 
						//send message!!!!!! 
					} 
				
				} 
				
				new AlertDialog.Builder(SendMsgFragment.this)
		         .setMessage("�����ɹ���")
		         .setPositiveButton("ȷ��",
		                         new DialogInterface.OnClickListener(){
		                                 public void onClick(DialogInterface dialoginterface, int i){
		                                     //��ť�¼�
		                                	// Intent intent=new Intent(SendMsgFragment.this,MainFragment.class);  
		                                	// intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
		                     				//SendMsgFragment.this.startActivity(intent);
		                                	 SendMsgFragment.this.finish();
		                                 }
		                         })
		         .show();
				  
				// MainActivity.this.finish();
			}
		 
		}); 
		
		btn_calcel.setOnClickListener(new Button.OnClickListener(){ 
			@Override
			public void onClick(View v) { 
			 
			for(int i=0;i<list.size();i++){ 
			 
				if(MyAdapter.isSelected.get(i)==true){ 
					MyAdapter.isSelected.put(i, false); 
					listStr.remove(name[i]); 
				} 
			} 
			 
			adapter.notifyDataSetChanged(); 
			tv.setText("��ѡ��"+listStr.size()+"��"); 
			 
			} 
			 
		}); 
	} 
	 
	// ��ʾ����checkbox��listview 
	public void showCheckBoxListView() { 
		list = new ArrayList<HashMap<String, Object>>(); 
		for (int i = 0; i < name.length; i++) { 
		 
			HashMap<String, Object> map = new HashMap<String, Object>(); 
			map.put("item_tv", name[i]); 
			map.put("item_cb", false); 
			list.add(map); 
			 
			adapter = new MyAdapter(this, list, R.layout.listviewitem, 
			new String[] { "item_tv", "item_cb" }, new int[] { 
			R.id.item_tv, R.id.item_cb }); 
			lv.setAdapter(adapter); 
			listStr = new ArrayList<String>(); 
			lv.setOnItemClickListener(new ListView.OnItemClickListener() { 
			 
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) { 
				ViewHolder holder = (ViewHolder) view.getTag(); 
				 
				holder.cb.toggle();// ��ÿ�λ�ȡ�����itemʱ�ı�checkbox��״̬ 
				MyAdapter.isSelected.put(position, holder.cb.isChecked()); // ͬʱ�޸�map��ֵ����״̬ 
				if (holder.cb.isChecked() == true) { 
					listStr.add(name[position]); 
				} else { 
					listStr.remove(name[position]); 
				} 
				tv.setText("��ѡ��"+listStr.size()+"��"); 
			} 
			 
			}); 
		} 
	} 
	 
	//Ϊlistview�Զ����������ڲ��� 
	 
	public static class MyAdapter extends BaseAdapter { 
		public static HashMap<Integer, Boolean> isSelected; 
		private Context context = null; 
		private LayoutInflater inflater = null; 
		private List<HashMap<String, Object>> list = null; 
		private String keyString[] = null; 
		private String itemString = null; // ��¼ÿ��item��textview��ֵ 
		private int idValue[] = null;// idֵ 
		 
		public MyAdapter(Context context, List<HashMap<String, Object>> list, 
		int resource, String[] from, int[] to) { 
		this.context = context; 
		this.list = list; 
		keyString = new String[from.length]; 
		idValue = new int[to.length]; 
		System.arraycopy(from, 0, keyString, 0, from.length); 
		System.arraycopy(to, 0, idValue, 0, to.length); 
		inflater = LayoutInflater.from(context); 
		init(); 
		} 
		 
		// ��ʼ�� ��������checkbox��Ϊδѡ�� 
		public void init() { 
		isSelected = new HashMap<Integer, Boolean>(); 
		for (int i = 0; i < list.size(); i++) { 
		isSelected.put(i, false); 
		} 
		} 
		 
		@Override
		public int getCount() { 
		return list.size(); 
		} 
		 
		@Override
		public Object getItem(int arg0) { 
		return list.get(arg0); 
		} 
		 
		@Override
		public long getItemId(int arg0) { 
		return 0; 
		 
		} 
		 
		@Override
		public View getView(int position, View view, ViewGroup arg2) { 
		ViewHolder holder = null; 
		if (holder == null) { 
		holder = new ViewHolder(); 
		if (view == null) { 
		view = inflater.inflate(R.layout.listviewitem, null); 
		} 
		 
		holder.tv = (TextView) view.findViewById(R.id.item_tv); 
		holder.cb = (CheckBox) view.findViewById(R.id.item_cb); 
		view.setTag(holder); 
		} else { 
		holder = (ViewHolder) view.getTag(); 
		} 
		HashMap<String, Object> map = list.get(position); 
		if (map != null) { 
		itemString = (String) map.get(keyString[0]); 
		holder.tv.setText(itemString); 
		} 
		holder.cb.setChecked(isSelected.get(position)); 
		return view; 
		}  
	} 
}
