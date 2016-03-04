package org.fred.ztest.http;

import java.util.HashMap;
import java.util.Map;

public class CallVipjrInterface {
	private static String REQUEST_DOMAIN = "http://localhost:8081/vipjr-webapp";

	public static void main(String[] args) {
		CallVipjrInterface cxgIf = new CallVipjrInterface();
		cxgIf.openWithhold();// 开通代扣
	}

	private void queryCanStage(){
		String url = REQUEST_DOMAIN + "/jr/stage/queryCanStage";
		
	}
	
	
	private void openWithhold() {
		String url = REQUEST_DOMAIN + "/mid/withhold/openWithhold";
		Map<String, String> map = new HashMap<String, String>();
		map.put("partnerId", "80002000003");
		map.put("sign", "8a07ef11818d12e877d264458e1c3dc7");
		map.put("userId", "60122535");
		map.put("bankCode", "ICBC");
		map.put("cardholderName", "VCPJ+TqhvwRm8Zs3PuMUZw==");
		map.put("cardType", "00");
		map.put("cardNo", "vSWpWxOyn5DpQm9IXGB38HjTSThXuWzR");
		map.put("idType", "00");
		map.put("idNo", "FA8P+mLeseBAjYYr1yVjlIQKQVnnJBQC");
		map.put("mobileNo", "o6sBhjQSK0Eda+VgfckT7Q==");
		System.out.println("-------------------------------openWithhold--------------------------------------");
		System.out.println(HttpTest.httpPost(url, map));
		System.out.println();
	}

}
