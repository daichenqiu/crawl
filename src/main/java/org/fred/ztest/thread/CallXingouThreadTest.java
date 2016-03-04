package org.fred.ztest.thread;

import java.util.HashMap;
import java.util.Map;

import org.fred.ztest.http.HttpTest;

public class CallXingouThreadTest implements Runnable {
    private static String REQUEST_DOMAIN = "http://10.198.192.30";

    public void run() {
        String url = REQUEST_DOMAIN + "/mid/stage/queryUseStageInfo";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "ef16b8ffa8061613c8f1782538f66276");
        map.put("stageAmount", "100");
        map.put("userId", "126810146");
        System.out.println("--------------queryUseStageInfo-----------------"+Thread.currentThread().getName());
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println("--------------queryUseStageInfo-----------------"+Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            CallXingouThreadTest call=new CallXingouThreadTest();
            Thread thread=new Thread(call);
            thread.setName(String.valueOf(i));
            System.out.println("---Start-------------Thread "+thread.getName());
            thread.start();
        }
    }
}
