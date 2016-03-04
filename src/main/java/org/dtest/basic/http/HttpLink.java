package org.dtest.basic.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.fred.ztest.http.Md5Encrypt;

public class HttpLink {
    private static String DEFAULT_ENCODING = "UTF-8";
    public final static String partnerId = "80002000007";
    public final static String key = "b243c0b8fb0a02b68ab68a08c9f4ccf5";

	public static void main(String[] args) {
		httpPost("http://www.baidu.com", null);
	}
	
	public static void httpGet(String uri){
		try {
	    	 CloseableHttpClient httpclient = HttpClients.createDefault();
	    	 HttpGet httpget = new HttpGet(uri);
	    	 CloseableHttpResponse response = httpclient.execute(httpget);
	    	 HttpEntity entity =response.getEntity(); 
	         if(entity != null) {
                   String back = EntityUtils.toString(entity, DEFAULT_ENCODING);
                   System.out.println(back);
            }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public static void vipPost(String uri, Map<String, String> paramMap){
		
	    if (paramMap == null) {
            paramMap = new HashMap<String, String>();
        }
	    
        paramMap.put("partnerId", partnerId);
        paramMap.put("signType", "MD5");
        paramMap.put("reqTime", DateUtils.formatDate(new Date(), "yyyyMMdd") + "000000");
        paramMap.put("resultType", "json");
        paramMap.put("charSet", DEFAULT_ENCODING);
        paramMap.put("versionNo", "1.0.0");

        paramMap.put("sign", sign(paramMap, key));
        
        httpPost(uri, paramMap);
        
		
	}
	public static void httpPost(String uri, Map<String, String> paramMap){
		try {
	    	 CloseableHttpClient httpclient = HttpClients.createDefault();
	    	 HttpPost post = new HttpPost(uri);
	    	 
	    	 List<NameValuePair> params = new ArrayList<NameValuePair>();
	    	 for(String key :paramMap.keySet()){
	    		 params.add(new BasicNameValuePair(key,paramMap.get(key)));
	    	 }
	    	 UrlEncodedFormEntity httpEntity = new UrlEncodedFormEntity(params, DEFAULT_ENCODING);
	    	 
	    	 post.setEntity(httpEntity);
	    	 CloseableHttpResponse response = httpclient.execute(post);
	    	 HttpEntity entity =response.getEntity(); 
	         if (entity != null) {
                   String back = EntityUtils.toString(entity, DEFAULT_ENCODING);
                   System.out.println(back);
            }
		} catch (ClientProtocolException e) {
			// TODO: handle exception
			System.out.println(e);
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

    public static String sign(Map params, String privateKey) {
        Properties properties = new Properties();

        for (Iterator iter = params.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            Object value = params.get(name);

            if (name == null || name.equalsIgnoreCase("sign") || name.equalsIgnoreCase("signType")) {
                continue;
            }
            if (null != value) {
                properties.setProperty(name, value.toString());
            }
        }
        StringBuffer content = new StringBuffer();
        List keys = new ArrayList(properties.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            String value = properties.getProperty(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }
        String signBefore = content + privateKey;
        return Md5Encrypt.md5(signBefore);
    }
}
