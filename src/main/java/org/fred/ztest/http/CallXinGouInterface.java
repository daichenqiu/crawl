package org.fred.ztest.http;

import org.fred.ztest.encrypt.ThreeDES;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class CallXinGouInterface {
    private static String REQUEST_DOMAIN = "http://localhost:8080";
    //private static String REQUEST_DOMAIN = "http://10.198.192.30";
    //private static String REQUEST_DOMAIN="http://xg-mid.vip.vip.com";

    public static void main(String[] args) {
        CallXinGouInterface cxgIf = new CallXinGouInterface();
        // -----------------------账户------------------------------
        //cxgIf.queryAccountInfo();
        // cxgIf.openAccount();
        // cxgIf.openWithhold();// 开通代扣
         cxgIf.queryAccountDetails();//查询账户明细 OK
        // cxgIf.findBusAccount();
        //cxgIf.uniteLicaiOpen();
        //cxgIf.dealUniteLicaiOpe();

        // -----------------------分期------------------------------
        //cxgIf.queryCanStage();// 查询是否可分期 OK
        // cxgIf.queryUseStageInfo();// 查询可分期信息 OK
        // cxgIf.acceptStage();// 受理分期 OK

        // -----------------------账单------------------------------
        // cxgIf.queryBatchBills();// 查询批量账单 OK
        // cxgIf.queryStageBills();//账单分期信息查询 OK
        // cxgIf.queryHistBills();//查询历史账单 OK
        //cxgIf.queryOneKeyRepayInfos();//查询一键还清账单详情
        //cxgIf.queryCanOneKeyRepay();//查询是否可一键还清账单

        // -----------------------还款------------------------------
        // cxgIf.queryCurrentPayables();//查询当前应还信息 OK

        // -----------------------交易------------------------------
        // cxgIf.queryAvailableLimitModificationResult();//可用余额调整结果查询
        // cxgIf.modifyAvailableCreditLimit();//信购支付接口
        // cxgIf.refund();//退款
        // cxgIf.repayment();// 还款
        // cxgIf.manualProcessAmount();//人工处理金额

        // -----------------------安全中心------------------------------
        // cxgIf.queryBindMobile();//查询绑定手机号

        //-----------------------短信----------------------------
        // cxgIf.sendVerificationCode();//发送验证码
        // cxgIf.checkVerificationCode();//验证短信验证码
        // cxgIf.sendMsgForFinance();
        //----------------------商城------------------------
        // cxgIf.queryLastOrderMobileNo();//查询历史订单手机号

        //----------------------支付-----------------------
//        cxgIf.findFourElementsForAccount();

        //---------------------理财-----------------------
        // cxgIf.sendVipCoinForLicai();

        //--------------------营销活动--------------------
        //cxgIf.bindCoupon();

        //--------------------代扣--------------------
        //cxgIf.queryWithholdStatus();
    }

    private void queryWithholdStatus(){
        String url = REQUEST_DOMAIN + "/mid/withhold/queryWithholdStatus";
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "126810146");

        System.out.println("--------------queryWithholdStatus---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void dealUniteLicaiOpe(){
        String url = REQUEST_DOMAIN + "/mid/account/dealUniteLicaiOpe";
        Map<String, String> map = new HashMap<String, String>();
        map.put("dealId", "1");

        System.out.println("--------------dealUniteLicaiOpe---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void uniteLicaiOpen(){
        String url = REQUEST_DOMAIN + "/mid/account/uniteLicaiOpen";
        Map<String, String> map = new HashMap<String, String>();
        String key="8d993e90c2905c7599dc56b0b152c11a";
        map.put("holderName", ThreeDES.encryptMode("王重阳",key));
        map.put("idNo",  ThreeDES.encryptMode("320925199909091234",key));
        map.put("cardNo",  ThreeDES.encryptMode("4392266677788899",key));
        map.put("mobileNo",  ThreeDES.encryptMode("18611117989",key));
        map.put("openChannel", "2");
        map.put("userId", "126810147");

        System.out.println("--------------uniteLicaiOpen---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }


    private void queryAccountInfo(){
        String url = REQUEST_DOMAIN + "/mid/account/queryAccountInfo";
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "126810146");
        System.out.println("--------------queryAccountInfo---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryOneKeyRepayInfos(){
        String url = REQUEST_DOMAIN + "/mid/bills/queryOneKeyRepayInfos";
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "126810146");
        System.out.println("--------------queryOneKeyRepayInfos---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }
    private void queryCanOneKeyRepay(){
        String url = REQUEST_DOMAIN + "/mid/bills/queryCanOneKeyRepay";
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "126810146");
        System.out.println("--------------queryCanOneKeyRepay---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void bindCoupon(){
        String url = REQUEST_DOMAIN + "/mid/market/bindCoupon";
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "848151172");
        map.put("couponId","17137");
        map.put("mobileNo","");
        System.out.println("--------------bindCoupon---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void sendVipCoinForLicai() {
        String url = REQUEST_DOMAIN + "/mid/licai/sendVipCoin";
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "848151172");
        map.put("activityNo","pay_merch_w39");
        map.put("amount","2");
        System.out.println("--------------licai--sendVipCoin---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void findFourElementsForAccount() {
        String url = REQUEST_DOMAIN + "/mid/account/findFourElements";
        Map<String, String> map = new HashMap<String, String>();
//        map.put("partnerId", "80002000003");
//        map.put("sign", "0369155f1dab0c60eb2d21251c044227");
        map.put("userId", "848151172");
        map.put("cardType", "2");
        System.out.println("--------------queryFourElements---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void sendMsgForFinance() {
        String url = REQUEST_DOMAIN + "/sms/finance/send";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "addd86bc21d5a24781659c4f0904c903");
        map.put("userId", "126810146");
        map.put("mobileNo", "18616711912");

        map.put("typeCode", "VIP_LC1");
        map.put("paramJson", "{\"verify\":\"123412\"}");
        //        map.put("typeCode","VIP_LC_BIZ");
        //        map.put("templateCode","VIP_LC_BIZ4");
        //        map.put("paramJson", "{\"amount\":\"876.00\"}");
        System.out.println("--------------sendMsgForFinance---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void findBusAccount() {
        String url = REQUEST_DOMAIN + "/pay/findBusAccount";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "865ec245091844e5bdedfd8710ccab35");
        map.put("userId", "126810146");
        System.out.println("--------------findBusAccount---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void openAccount() {
        String url = REQUEST_DOMAIN + "/mid/account/openAccount";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "7c813ac6cdabec5ab220e2c76168508a");
        map.put("userId", "126810146");
        map.put("bankId", "ICBC");
        map.put("cardType", "2");
        map.put("cardNo", "6227001217760075236");
        map.put("cardholderName", "林敏");
        map.put("idType", "1");
        map.put("idNo", "31011019830623563X");
        map.put("mobileNo", "18101944419");
        map.put("orderId", "123");
        map.put("msgCode", "123456");
        map.put("signWithhold", "0");
        map.put("channel", "1");
        map.put("bizChannel", "2");
        System.out.println("--------------openAccount---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryLastOrderMobileNo() {
        String url = REQUEST_DOMAIN + "/mid/mall/queryLastOrderMobileNo";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "4820207e35bb1ebf2ac1015487dbc810");
        map.put("userId", "84815159");
        System.out.println("--------------queryLastOrderMobileNo---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void checkVerificationCode() {
        String url = REQUEST_DOMAIN + "/sms/checkVerificationCode";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "6a6afe04afa4433fb164a7145fe98c3d");
        map.put("userId", "126810146");
        map.put("type", "2");
        map.put("mobileNo", "18616711912");
        map.put("verificationCode", "123456");
        System.out.println("--------------checkVerificationCode---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }


    private void sendVerificationCode() {
        String url = REQUEST_DOMAIN + "/sms/sendVerificationCode";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "140b74175647d9976ce869662f4097e5");
        map.put("userId", "126810146");
        map.put("type", "2");
        map.put("mobileNo", "18616711912");
        System.out.println("--------------sendVerificationCode---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryBindMobile() {
        String url = REQUEST_DOMAIN + "/mid/security/queryBindMobile";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "af08b6c7a1ad11e8c2d2ec26f6d61c7d");
        map.put("userId", "36578010");
        System.out.println("--------------queryBindMobile---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void manualProcessAmount() {
        String url = REQUEST_DOMAIN + "/mid/trade/manualProcessAmount";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "432e834561fb96522d9788833e9312f1");
        map.put("userId", "126810146");
        map.put("operator", "127381726387163871628736187236");
        map.put("amount", "0.06");
        map.put("operateType", "10");// 10:人工反向充值，11:人工罚息减免，12:人工费用减免
        map.put("message", "hsh伺服电机");
        map.put("tradeTime", "20150916162034");
        map.put("transactionId", "2341232");
        map.put("channel", "1");// 1 pc 2 wap 3 移动客户端 4 其他
        System.out.println("-------manualProcessAmount-----");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void repayment() {
        String url = REQUEST_DOMAIN + "/mid/account/refund";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "0de8876cb016922978f2df2ab365a9a0");
        map.put("userId", "126810146");
        map.put("operator", "refund");
        map.put("changedAmount", "-0.05");
        map.put("operateType", "03");// 03还款
        map.put("relatedTradeId", "12345678");
        map.put("tradeTime", "20150916162034");
        map.put("origTransactionId", "11233334");
        map.put("transactionId", "2341232");
        map.put("channel", "1");// 1 pc 2 wap 3 移动客户端 4 其他
        System.out.println("-------refund-----");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void refund() {
        String url = REQUEST_DOMAIN + "/mid/account/refund";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "0de8876cb016922978f2df2ab365a9a0");
        map.put("userId", "126810146");
        map.put("operator", "refund");
        map.put("changedAmount", "-0.04");
        map.put("operateType", "02");// 02退款
        map.put("relatedTradeId", "12345678");
        map.put("tradeTime", "20150916162034");
        map.put("origTransactionId", "11233334");
        map.put("transactionId", "2341232");
        map.put("channel", "1");// 1 pc 2 wap 3 移动客户端 4 其他
        System.out.println("-------refund-----");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void modifyAvailableCreditLimit() {
        String url = REQUEST_DOMAIN + "/mid/account/modifyAvailableCreditLimit";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "0de8876cb016922978f2df2ab365a9a0");
        map.put("userId", "126810146");
        map.put("operator", "modifyAvailableCreditLimit");
        map.put("changedAmount", "12.34");
        map.put("operateType", "01");// 01支付
        map.put("relatedTradeId", "12345678");
        map.put("tradeTime", "20150914162034");
        map.put("origTransactionId", "11233334");
        map.put("transactionId", "2341232");
        map.put("channel", "1");// 1 pc 2 wap 3 移动客户端 4 其他
        System.out.println("-------modifyAvailableCreditLimit-----");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryAvailableLimitModificationResult() {
        String url = REQUEST_DOMAIN + "/mid/account/queryAvailableLimitModificationResult";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "ef5e5a4c8c5610d4cb82d879df2fad67");
        map.put("userId", "126810146");
        map.put("transactionId", "20150720202751000002");
        map.put("relatedTradeId", "15061440862057");
        map.put("amount", "0.01");
        map.put("adjustTime", "20150721140000");
        map.put("tradeType", "02");// 01支付，02退款，03主动还款，04自动还款，05其它
        map.put("channel", "1");// 1 pc 2 wap 3 移动客户端 4 其他
        System.out.println("-------queryAvailableLimitModificationResult-----");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryHistBills() {
        String url = REQUEST_DOMAIN + "/mid/account/queryHistBills";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "0de8876cb016922978f2df2ab365a9a0");
        map.put("userId", "126810146");
        map.put("billTime", "201509");
        map.put("currentPage", "1");
        map.put("pageSize", "20");
        System.out.println("--------------queryHistBills---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryCurrentPayables() {
        String url = REQUEST_DOMAIN + "/mid/account/queryCurrentPayables";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "0de8876cb016922978f2df2ab365a9a0");
        map.put("userId", "126810146");
        System.out.println("--------------queryCurrentPayables---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryStageBills() {
        String url = REQUEST_DOMAIN + "/mid/bills/queryStageBills";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "1f2687f8b94f5c918d3884a7871815e3");
        map.put("userId", "126810146");
        map.put("monthBillNo", "20150915205304000001");
        map.put("currentPage", "1");
        map.put("pageSize", "20");
        System.out.println("--------------queryStageBills---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryBatchBills() {
        String url = REQUEST_DOMAIN + "/mid/bills/queryBatchBills";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "26a7bb409776c639a6cb59827d9c0eb8");
        map.put("userId", "126810146");
        map.put("billStartTime", "201508");
        map.put("billEndTime", "201509");
        map.put("currentPage", "1");
        map.put("pageSize", "20");
        System.out.println("--------------queryBatchBills---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryAccountDetails() {
        String url = REQUEST_DOMAIN + "/mid/account/queryAccountDetails";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "6801d5ef52263bf8b85671f7cce2ebea");
        map.put("userId", "126810146");
        map.put("startTime", "20151001000000");
        map.put("endTime", "20151031235959");
        map.put("type", "03");
        map.put("currentPage", "1");
        map.put("pageSize", "20");
        System.out.println("--------------queryAccountDetails---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryCanStage() {
        String url = REQUEST_DOMAIN + "/mid/stage/queryCanStage";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "ad9291ffb12c29d9fbabd2ca5765a5d3");
        map.put("userId", "126810146");
        System.out.println("--------------queryCanStage---------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void queryUseStageInfo() {
        String url = REQUEST_DOMAIN + "/mid/stage/queryUseStageInfo";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "b9c4eecaa00f1a32ec5c338058215966");
        map.put("stageAmount", "100");
        map.put("userId", "126810146");
        System.out.println("--------------queryUseStageInfo-----------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void acceptStage() {
        String url = REQUEST_DOMAIN + "/mid/stage/acceptStage";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "e7770141b98f7faaca511e19513d677c");
        map.put("userId", "126810146");
        map.put("stageAmount", "130");
        map.put("stageNumber", "6");
        System.out.println("--------------acceptStage-----------------");
        System.out.println(HttpTest.httpPost(url, map));
        System.out.println();
    }

    private void openWithhold() {
        String url = REQUEST_DOMAIN + "/mid/withhold/signWithhold";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partnerId", "80002000003");
        map.put("sign", "64444ed573ef7ac29778b413ae9496bb");
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
