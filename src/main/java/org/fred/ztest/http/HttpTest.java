package org.fred.ztest.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpTest {
    private static String DEFAULT_ENCODING = "UTF-8";
    public final static String partnerId = "80002000007";
    public final static String key = "b243c0b8fb0a02b68ab68a08c9f4ccf5";

    public static String httpPost(String postUri, Map<String, String> paramMap) {
        String back = null;

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
        if (StringUtils.isNotEmpty(postUri)) {

            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();

                HttpPost httpPost = new HttpPost(postUri);
                if (MapUtils.isNotEmpty(paramMap)) {
                    String paramStr = "";
                    List<NameValuePair> formParams = new ArrayList<NameValuePair>();
                    for (String key : paramMap.keySet()) {
                        formParams.add(new BasicNameValuePair(key, paramMap.get(key).toString()));
                        paramStr += key + "=" + paramMap.get(key).toString() + "&";
                    }
                    System.out.println("请求参数为: " + paramStr.substring(0, paramStr.length() - 1));
                    UrlEncodedFormEntity uefEntity;

                    uefEntity = new UrlEncodedFormEntity(formParams, DEFAULT_ENCODING);


                    httpPost.setEntity(uefEntity);
                }
                CloseableHttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    back = EntityUtils.toString(entity, DEFAULT_ENCODING);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return back;
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
