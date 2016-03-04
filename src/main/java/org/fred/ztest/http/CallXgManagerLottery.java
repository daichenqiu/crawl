package org.fred.ztest.http;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.dtest.basic.http.HttpLink;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * Created by fred.zhu on 16/1/19.
 */
@SuppressWarnings("unused")
public class CallXgManagerLottery {

    //private static String REQUEST_DOMAIN = "http://10.198.192.30";
    //private static String REQUEST_DOMAIN="http://xg-mid.vip.vip.com";
    
//    public static void main(String[] args) {
//        CallXgLottery call = new CallXgLottery();
//        //-------------------------------------------
//        call.testCreateLotteryInfo();//抽奖
//
//    }
    private static String REQUEST_DOMAIN = "http://localhost:8080/xingou-webapp";
    private static String LOTTERY_DOMAIN = "/mid/manager/lottery";

    @Ignore
    @Test
    public void lotteryDraw() {
        String url = REQUEST_DOMAIN + "/mid/lottery/lotteryDraw";
        Map<String, String> map = new HashMap<String, String>();
        map.put("channel", "1");
        map.put("activityId", "");
        map.put("userId", "126810146");
        map.put("userName", "fuhua6d6@163.com");
        System.out.println("--------------lotteryDraw---------------");
        System.out.println(HttpTest.httpPost(url, map));
    }
    
    @Ignore
    @Test
    public void testSaveLotteryAwardInfo(){
    	String url = REQUEST_DOMAIN + LOTTERY_DOMAIN + "/saveLotteryAwardInfo";
        Map<String, String> map = new HashMap<String, String>();
//        map.put("userId", "126810146");
        
        map.put("activityId", "21");
        map.put("awardId", "11");
        map.put("awardName", "劳斯莱斯2");
        map.put("awardLevel", "14");
        map.put("awardType", "2");
        map.put("picPcUrl", "");
        map.put("picH5Url", "");
        map.put("winningTips", "醒醒,做梦呢");
        map.put("isRepeat", "0");
        map.put("isDefault", "0");
        map.put("virtualType", "2");
        map.put("sendTimeType", "1");
        map.put("vipCoinActivityNo", "1");
        map.put("sendQty", "10");
        map.put("couponNo", "1");
        map.put("userName", "fuhua6d6@163.com");
        System.out.println("-------------- testCreateLotteryInfo ---------------");
        System.out.println(HttpTest.httpPost(url, map));
    }
    
  @Ignore
  @Test
  public void testSaveLotteryAwardSetting(){
	  String url = REQUEST_DOMAIN + LOTTERY_DOMAIN + "/saveLotteryAwardSetting";
      Map<String, String> map = new HashMap<String, String>();
      map.put("userId", "126810146");
      
      map.put("activityId", "21");
      map.put("awardId", "3");
      map.put("probability", "110");
      map.put("totalQty", "-10");
      
//      map.put("settingId", "3");
      
      System.out.println("-------------- testCreateLotteryInfo ---------------");
      System.out.println(HttpTest.httpPost(url, map));
  }
  
  @Ignore
  @Test
  public void testSaveLotteryAwardDaily(){
	  String url = REQUEST_DOMAIN + LOTTERY_DOMAIN + "/saveLotteryAwardDaily";
      Map<String, String> map = new HashMap<String, String>();
//      map.put("userId", "126810146");
      
      map.put("activityId", "19");
      map.put("awardId", "11");
      map.put("limitStartTime", new Timestamp(System.currentTimeMillis()).toString());
//      Timestamp before = new Timestamp(2016, int month, int date,
//              int hour, int minute, int second, int nano);
      map.put("limitEndTime", new Timestamp(System.currentTimeMillis()).toString());
      map.put("dailyLimitQty", "21");
      
//      map.put("dailyId", "2");
      System.out.println("-------------- testCreateLotteryInfo ---------------");
      System.out.println(HttpTest.httpPost(url, map));
  }
  

  @Ignore
  @Test
  public void testQueryLotteryAwardInfoy(){
	  String url = REQUEST_DOMAIN + LOTTERY_DOMAIN + "/queryLotteryAwardInfo";
      Map<String, String> map = new HashMap<String, String>();
      
      map.put("activityId", "21");
      System.out.println("-------------- testCreateLotteryInfo ---------------");
      System.out.println(HttpTest.httpPost(url, map));
  }
  
  @Ignore
  @Test
  public void testQueryLotteryAwardSetting(){
	  String url = REQUEST_DOMAIN + LOTTERY_DOMAIN + "/queryLotteryAwardSetting";
      Map<String, String> map = new HashMap<String, String>();
      map.put("userId", "126810146");
      
      map.put("activityId", "21");
      System.out.println("-------------- testCreateLotteryInfo ---------------");
      System.out.println(HttpTest.httpPost(url, map));
  }
  
//  @Ignore
  @Test
  public void testQueryLotteryAwardDaily(){
	  String url = REQUEST_DOMAIN + LOTTERY_DOMAIN + "/queryLotteryAwardDaily";
      Map<String, String> map = new HashMap<String, String>();
//      map.put("userId", "126810146");
      
      map.put("activityId", "21");
      System.out.println("-------------- testCreateLotteryInfo ---------------");
//      System.out.println(HttpTest.httpPost(url, map));
      HttpLink.vipPost(url, map);
  }
  
  @Ignore
  @Test
  public void testTime(){
      System.out.println("-------------- testCreateLotteryInfo ---------------");
      System.out.println(new Timestamp(1456479041190L));
      System.out.println(JSON.toJSONString(new Timestamp(System.currentTimeMillis())));
      
  }
  
  public <T>T setting(){
	  return null;
  }

}
