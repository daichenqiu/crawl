package org.fred.ztest.http;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by fred.zhu on 16/1/19.
 */
@SuppressWarnings("unused")
public class CallXgLottery {
    private static String REQUEST_DOMAIN = "http://localhost:8080/xingou-webapp";
    private static String LOTTERY_DOMAIN = "/mid/lottery";
    
//    @Ignore
    @Test
    public void queryLatestLottery(){
    	String url = REQUEST_DOMAIN + LOTTERY_DOMAIN + "/queryLatestLotteryResult";
        Map<String, String> map = new HashMap<String, String>();
//        map.put("userId", "126810146");
        
        map.put("size", "100");
        System.out.println("-------------- testCreateLotteryInfo ---------------");
        System.out.println(HttpTest.httpPost(url, map));
    }
}
