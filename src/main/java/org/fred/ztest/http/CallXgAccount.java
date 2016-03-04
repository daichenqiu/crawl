package org.fred.ztest.http;

import org.fred.ztest.encrypt.ThreeDES;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fred.zhu on 16/1/22.
 */
public class CallXgAccount {
    private static String REQUEST_DOMAIN = "http://localhost:8080";

    public static void main(String[] args) {
        CallXgAccount call = new CallXgAccount();
        //----------------------------
        call.openAccount();
    }

    private void openAccount() {
        String url = REQUEST_DOMAIN + "/mid/account/openAccount";
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "126810146");
        map.put("bankId", "ICBC");
        map.put("cardType", "2");
        map.put("cardNo", ThreeDES.encryptMode("6227001217760012346", HttpTest.key));
        map.put("cardholderName", ThreeDES.encryptMode("张三", HttpTest.key));
        map.put("idNo", ThreeDES.encryptMode("310110198306235121", HttpTest.key));
        map.put("mobileNo", ThreeDES.encryptMode("18611112222", HttpTest.key));
        map.put("orderId", "123");
        map.put("msgCode", "123456");
        map.put("signWithhold", "0");
        map.put("channel", "1");
        map.put("bizChannel", "2");
        System.out.println("--------------openAccount---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }
}
