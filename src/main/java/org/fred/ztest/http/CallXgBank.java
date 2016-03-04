package org.fred.ztest.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fred.zhu on 16/1/19.
 */
@SuppressWarnings("unused")
public class CallXgBank {
    private static String REQUEST_DOMAIN = "http://localhost:8080";

    //private static String REQUEST_DOMAIN = "http://10.198.192.30";
    //private static String REQUEST_DOMAIN="http://xg-mid.vip.vip.com";
    public static void main(String[] args) {
        CallXgBank call = new CallXgBank();
        //-------------------------------------------
        //call.queryBankInfoByCardBin();//根据卡bin查询银行信息--开户
        //call.queryBankInfoByCardBinForWithhold();//根据卡bin查询银行信息--代扣
        call.queryBankInfoByBankId();//根据银行简码查询银行信息
        //call.switchBankTarget();//修改开户渠道
    }

    private void switchBankTarget(){
        String url = REQUEST_DOMAIN + "/mid/bank/switchBankTarget";
        Map<String, String> map = new HashMap<String, String>();
        map.put("bankId", "ABC");
        map.put("accountTarget", "3");

        System.out.println("--------------switchBankTarget---------------");
        System.out.println(HttpTest.httpPost(url, map));
    }

    private void queryBankInfoByBankId(){
        String url = REQUEST_DOMAIN + "/mid/bank/queryBankInfoByBankId";
        Map<String, String> map = new HashMap<String, String>();
        map.put("bankId", "ABC");

        System.out.println("--------------queryBankInfoByBankId---------------");
        System.out.println(HttpTest.httpPost(url, map));
    }

    private void queryBankInfoByCardBinForWithhold(){
        String url = REQUEST_DOMAIN + "/mid/bank/queryBankInfoByCardBinForWithhold";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partBankCardNo", "622662");

        System.out.println("--------------queryBankInfoByCardBinForWithhold---------------");
        System.out.println(HttpTest.httpPost(url, map));
    }

    private void queryBankInfoByCardBin() {
        String url = REQUEST_DOMAIN + "/mid/bank/queryBankInfoByCardBin";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partBankCardNo", "622666");

        System.out.println("--------------queryBankInfoByCardBin---------------");
        System.out.println(HttpTest.httpPost(url, map));
    }
}
