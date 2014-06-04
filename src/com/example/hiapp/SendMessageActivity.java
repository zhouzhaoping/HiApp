package com.example.hiapp;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import nettools.NetThread;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class SendMessageActivity extends Activity {
	
	public SendMessageActivity() {
	}
	
	private ImageView button_back;
	private TextView intext1;
	private TextView intext2;
	 private Button confirm;
	 private EditText inedit1;
	 private EditText inedit2;

	 private Button selectImage, uploadImage;
	 private ImageView imageView;
	 private String picPath = null;

	 
	
	 
	 public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState); 
			setContentView(R.layout.activity_send); 

			button_back = (ImageView) findViewById(R.id.go_back_button);
			button_back.setOnClickListener(goBack);
			intext1 = (TextView) this.findViewById(R.id.intext); 
			inedit2=(EditText) this.findViewById(R.id.inedit2);
			intext2 = (TextView) this.findViewById(R.id.intext2); 
			inedit1=(EditText) this.findViewById(R.id.inedit);
			confirm = (Button) this.findViewById(R.id.confirm); 
					 
			selectImage = (Button) this.findViewById(R.id.selectImageButton);
			selectImage.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View arg0){
					/***
					* 这个是调用android内置的intent，来过滤图片文件 ，同时也可以过滤其他的
					*/
					Intent intent = new Intent();
					intent.setType("image/*");
					intent.setAction(Intent.ACTION_GET_CONTENT);
					startActivityForResult(intent, 1);
					
				}
			}
			);
			
			
			confirm.setOnClickListener(new Button.OnClickListener(){ 		
			public void onClick(View arg0) { 
					
				NetThread t = new NetThread("sendActivity", 0, 0, "1100012847", 
						inedit1.getText().toString(), 
						inedit2.getText().toString(), 
						-1, null, null);
				t.BeginDeal();
				String[] Path = new String[1];
				Path[0] = picPath;
				Log.d("picPaht Src", picPath);
				NetThread pt = new NetThread("sendPictures", 1, 0, "1100012847", inedit1.getText().toString(), null, 0, null, null, Path);
				pt.sendpic();
				int retCode = t.getReturnCode();
				
				if (retCode == 0)
				{
					new AlertDialog.Builder(SendMessageActivity.this)
			         .setMessage("发布成功！")
			         .setPositiveButton("确定",
			          new DialogInterface.OnClickListener(){
			              public void onClick(DialogInterface dialoginterface, int i){
					
					//Intent intent = new Intent();              
	                //intent.setClass(SendMessageActivity.this, MainFragment.class); 
	                //startActivity(intent);
	                SendMessageActivity.this.finish();
			            	  
					} }).show();
				}
				else 
				{
					new AlertDialog.Builder(SendMessageActivity.this)
			         .setMessage("发布失败，再试试吧亲！")
			         .setPositiveButton("确定",
			          new DialogInterface.OnClickListener(){
			              public void onClick(DialogInterface dialoginterface, int i){
					} }).show();
					//Toast.makeText(SendMessageActivity.this, "发布失败，！", Toast.LENGTH_SHORT).show();
				}
			}
			}); 
	 }
	 /*
	 @Override
	     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	         if (resultCode == Activity.RESULT_OK) {
	             /**
	              * 当选择的图片不为空的话，在获取到图片的途径
	              
	             Uri uri = data.getData();
	             Log.e("uri", "uri = " + uri);
	             try {
	                 String[] pojo = { MediaStore.Images.Media.DATA };
	                 @SuppressWarnings("deprecation")
					Cursor cursor = managedQuery(uri, pojo, null, null, null);
	                 if (cursor != null) {
	                     ContentResolver cr = this.getContentResolver();
	                     int colunm_index = cursor
	                             .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	                     cursor.moveToFirst();
	                     String path = cursor.getString(colunm_index);
	                     /***
	                      * 这里加这样一个判断主要是为了第三方的软件选择，比如：使用第三方的文件管理器的话，你选择的文件就不一定是图片了，
	                      * 这样的话，我们判断文件的后缀名 如果是图片格式的话，那么才可以
	                      
	                     if (path.endsWith("jpg") || path.endsWith("png")) {

	                         picPath = path;
	                         Bitmap bitmap = BitmapFactory.decodeStream(cr
	                                 .openInputStream(uri));
	                         imageView.setImageBitmap(bitmap);
	                     } else {
	                         alert();
	                     }
	                 } else {
	                     alert();
	                 }
	             } catch (Exception e) {
	             }
	         }
	         super.onActivityResult(requestCode, resultCode, data);
	     }
	 */
	 
	 @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	 
	        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
	            Uri selectedImage = data.getData();
	            String[] filePathColumn = { MediaStore.Images.Media.DATA };
	 
	            Cursor cursor = getContentResolver().query(selectedImage,
	                    filePathColumn, null, null, null);
	            cursor.moveToFirst();
	 
	            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	            String picturePath = cursor.getString(columnIndex);
	            cursor.close();
	 
	            ImageView imageView = (ImageView) findViewById(R.id.imageView);
	            picPath = picturePath;
	            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	 
	        }
	 
	    }
	 
	 
	 
	     private void alert() {
	         Dialog dialog = new AlertDialog.Builder(this).setTitle("提示")
	                 .setMessage("您选择的不是有效的图片")
	                 .setPositiveButton("确定", new DialogInterface.OnClickListener() {
	                     public void onClick(DialogInterface dialog, int which) {
	                         picPath = null;
	                     }
	                 }).create();
	         dialog.show();
	     }

	 
	 
	 
	 
	 
	 
	 
	 private Button.OnClickListener goBack = new Button.OnClickListener()
	 {
		  public void onClick(View v)
		 {
			  SendMessageActivity.this.finish();
		 }
	 };	
}
