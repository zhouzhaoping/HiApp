package nettools;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class NetThread{
	
	private final static String TAG = "HiApp";
	
	public String url;
	
	public String method;	
	public int count;
	//public String user_id;
	public int user_id;
	
	public String publisher_id;
	public String content;
	
	public int msg_id;
	
	public String username;
	public String password;

	public JSONArray result;
	
	public Bitmap mBitmap1;
	public Bitmap mBitmap2;
	public Bitmap mBitmap3;
	
	public List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	public Map<String, Object> map1 = new HashMap<String, Object>();
	
	JSONObject param = new JSONObject();
	
	public NetThread(){}
	
	public NetThread(String m, int ct, int uid, String pid, String ctt,
			  		 int mid, String u, String p){
		method = m;
		count = ct;
		user_id = uid;
		publisher_id = pid;
		content = ctt;
		msg_id = mid;
		username = u;
		password = p;
		try{
			if (method != null) param.put("method", method);
			if (count >= 0) param.put("count", count);
			if (user_id >= 0) param.put("user_id", user_id);
			if (publisher_id != null) param.put("publisher_id", publisher_id);
			if (content != null) param.put("content", content);
			if (msg_id >= 0) param.put("msg_id", msg_id);
			if (username != null) param.put("username", username);
			if (password != null) param.put("password", password);
		} catch (Exception e) {
			e.printStackTrace();
        }		
	}
	
	public void BeginDeal(){
		try{
			url = "http://hiappclass4demo.sinaapp.com";
			Thread t = new Thread(connect);
			t.start();
			t.join();
		} catch (Exception e) {
            e.printStackTrace();
        }
	}

	public List<Map<String, Object>> getData(String[] str){
		try {			
			int  i;
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			//JSONArray jsonarr = new JSONArray(result);
			for (i = 0; i < result.length(); i++)	{
				JSONObject object = result.getJSONObject(i);
				Map<String, Object> map = new HashMap<String, Object>();
				for (int j = 0; j < str.length; j++)
					map.put(str[j], object.getString(str[j]));
					//TODO:�������String��Ҫ��switch��������з��ദ��		
				list.add(map);
			}

			return list;
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	public String convert(String time) {
		int  i;
		String res;
		String temp = time.replace('T', ' ');
		i = temp.indexOf('+');
		res = temp.substring(0, i);
		return res;
	}
	
	public List<Map<String, Object>> talk(){
		try {
			int  i;
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			if (result != null){
				JSONArray jsonarr = new JSONArray();
				jsonarr = result;
				for (i = 0; i < jsonarr.length(); i++)	{
					JSONObject object = jsonarr.getJSONObject(i);
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("act_name", object.getString("title"));
					String temp = object.getString("publish_time");
					String res = convert(temp);
					map.put("act_time", res);
					map.put("act_content1", object.getString("content"));
					Thread t = new Thread(connectNet);
					t.start();
					try {
						t.join(); // wait for t to finish
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					if (mBitmap1 == null) map.put("act_content2", "1234");
					else map.put("act_content2", "4321");
					map.put("act_main_pic", mBitmap1);
					//map.put("act_content2", object.getInt("activity_id"));
					//map.put("act_content3", object.getInt("publisher_id"));
					list.add(map);
				}
				return list;
			}
			else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("act_name", "error");
				list.add(map);
				return list;
			}			
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

	 /**
	     * Get image from network
	     * @param path The path of image
	     * @return byte[]
	     * @throws Exception
	     */
	    public byte[] getImage(String path) throws Exception{
	        URL url = new URL(path);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setConnectTimeout(5 * 1000);
	        conn.setRequestMethod("GET");
	        InputStream inStream = conn.getInputStream();
	        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
	            return readStream(inStream);
	        }
	        return null;
	    }

	    /**
	     * Get image from network
	     * @param path The path of image
	     * @return InputStream
	     * @throws Exception
	     */
	    public InputStream getImageStream(String path) throws Exception{
	        URL url = new URL(path);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setConnectTimeout(5 * 1000);
	        conn.setRequestMethod("GET");
	        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
	            return conn.getInputStream();
	        }
	        return null;
	    }
	    /**
	     * Get data from stream
	     * @param inStream
	     * @return byte[]
	     * @throws Exception
	     */
	    public static byte[] readStream(InputStream inStream) throws Exception{
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while( (len=inStream.read(buffer)) != -1){
	            outStream.write(buffer, 0, len);
	        }
	        outStream.close();
	        inStream.close();
	        return outStream.toByteArray();
	    }


	    /*
	     * ��������
	     * ������4.0�в����������߳��з������磬������Ҫ�����߳��з���
	     */
	    private Runnable connectNet = new Runnable(){
	        @Override
	        public void run() {
	            try {
	                String filePath = "http://img.my.csdn.net/uploads/201402/24/1393242467_3999.jpg";

	                //������ȡ��ͼƬ�����ַ���
	                //////////////// ����1��ȡ�õ���byte����, ��byte��������bitmap
	                /*
	                byte[] data = getImage(filePath);
	                if(data!=null){
	                    mBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);// bitmap
	                }else{
	                    Toast.makeText(MainActivity.this, "Image error!", 1).show();
	                }
	                */
	                ////////////////////////////////////////////////////////

	                //******** ����2��ȡ�õ���InputStream��ֱ�Ӵ�InputStream����bitmap ***********/
	                mBitmap1 = BitmapFactory.decodeStream(getImageStream(filePath));
	                //********************************************************************/

	                // ������Ϣ��֪ͨhandler�����߳��и���UI
	                //connectHanlder.sendEmptyMessage(0);
	                Log.d(TAG, "set image ...");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	        }

	    };

	    private Handler connectHanlder = new Handler() {
	        @Override
	        public void handleMessage(Message msg) {
	        	//mSaveDialog.dismiss();
	            Log.d(TAG, "display image");
	            
	            // ����UI����ʾͼƬ
	           // if (mBitmap != null) {
	           //     mImageView.setImageBitmap(mBitmap);// display image
	           // }
	            
	        }
	    };

	
	public Runnable connect = new Runnable(){
		@Override
		public void run(){
			try{
				HttpClient client = new DefaultHttpClient();
				HttpPost request = new HttpPost(url);
				
				Log.d("request json", param.toString());
				 
				// �󶨵����� Entry
				StringEntity se = new StringEntity(param.toString()); 
				request.setEntity(se);
				
				// ��������
				HttpResponse httpResponse = client.execute(request);
				
				// �õ�Ӧ����ַ�������Ҳ��һ�� JSON ��ʽ���������
				String retSrc = EntityUtils.toString(httpResponse.getEntity());
				Log.d("receive content", retSrc);
	
				// ���� JSON ����
				result = new JSONArray(retSrc);
				if (result != null)
					Log.d("result", "yes");
				else 
					Log.d("result", "oh, no!");
			} catch (Exception e) {
				Log.d("myerror", "Oops!");
                e.printStackTrace();
            }
		}
		
	};
}
