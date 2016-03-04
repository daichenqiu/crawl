package org.fred.ztest.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;

/**
 * Created by fred.zhu on 15/12/17.
 */
public class ThreeDES {
    public static void main(String[] args) {
        String midKey = "1172d5e647adb62f357fd46825b1ffa5";
        String withholdKey = "02f78042faf0c1d6830370d7e3d8ba12";
        String jrKey = "7b7d45fe4b3d5e0e22d567607c48c50a";
        String logKey = "20160218" + "ERERIhERERERERERERERERERERMxERER";

        //---------加密------------
        // encryptMode("{\"createTime\":1451022584000,\"isDeleted\":0,\"mobileNo\":\"15903999973\",\"smsCode\":\"024262\",
        // \"smsId\":240405," +
        //"\"smsType\":2,\"updateTime\":1451022584000,\"userId\":\"158577227\"}",logKey);
        //---------解密------------
        decryptMode("n7/UKV+HDSDDK0LIIcnir0LR6RjxRqBxiPDv/jxXWjbHhTRqUI9qNVS8cy5bsvgO/1FGHqPNML2i\n" +
                            "BSSFKJf5/yjPQSHroMp8LzyMIDVy43BBc6qL/HsvTUAdkf5696BUH6s+9xwznv7h/V6ZfW7eDR2q\n" +
                            "wWJKDkqWVOhToXjXcc3tA8wtPziz8oqrmVrg1rh8W/khLzxMaAiFELTjd/i2qRvyur4kesQwc4Br\n" +
                            "Rj4pqdf2eJwsnp7qP86xXFlzGZMBI/1cI1RXKVXmmIkqnSuTzSQBobJyNuQWQXOqi/x7L00tgZIU\n" +
                            "E5ckGyNlfLNetcVtwUh5XkIv9seuAOiCjC4z39Bh/FCOD98fH6s+9xwznv7yAL5e14NS4GCAojmD\n" +
                            "XhKWLhyC1f4TcdXLysyekP04nsQZ2BXMcuyXlWfAOEXy4Jpskd4pvTHdbkptaZsmjvMKrE8+ieEO\n" +
                            "h01Bc6qL/HsvTQ5eLshMSwzYqeARgoKhfNfvVKfF1sJbfJvi4abQXtg8H6s+9xwznv466hLAcavx\n" +
                            "Lx+rPvccM57+6B4qte37x4wfqz73HDOe/rEggPtCKK5Y1oPHe1WgHRRpvepi90F59uBYenVQFTPt\n" +
                            "QXOqi/x7L03dXcJDgsBR0DXgPoDZ3F1lF1vDffskx1KMetCN5feaV6cL8h5BrXBGDJN9ZTSSrEUb\n" +
                            "WJZCpef746ZNtRvxU1RiG/K6viR6xDDb/vZ2eeFzgdaDx3tVoB0UX/bf4S72ZJOGwF0G1G9YbWCA\n" +
                            "ojmDXhKWvQ1CPE//ERlggKI5g14SljZJbaRZ5im6bJHeKb0x3W53RHfxKk3mWR/iKpicW/Gk6B2a\n" +
                            "AHeZdKQrWAUda8Gjpwu21bJFDoC0tZSZPjpxgNSpQbSGAUJTW4iOWh9kb5NWpQR3JpskMniTh2m5\n" +
                            "vQWYt2lhrVsfZbLBRA0+zoEVAMz0bV41lJoB+wS0r1iS9X3Xr5NihrxBr+34uyCvpCEP11Vr52QZ\n" +
                            "CImw", logKey);
    }

    /**
     * 加密数据
     *
     * @param data 需要加密的数据
     * @param key  密钥
     * @return 加密结果
     */
    public static String encryptMode(String data, String key) {
        System.out.println("-----------begin----加密-----------------------");
        System.out.println(">>>>>>加密KEY为:  " + key);
        System.out.println(">>>>>>加密参数为:  " + data);
        if (data == null || data.length() == 0) {
            return "";
        }
        if (key == null || key.length() == 0) {
            System.out.println("3DES加密密钥KEY为空!");
            return "";
        }
        try {
            byte[] keyBytes = new BASE64Decoder().decodeBuffer(key);
            byte[] dataBytes = data.getBytes("UTF-8");

            DESedeKeySpec spec = new DESedeKeySpec(keyBytes);
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
            Key deskey = keyfactory.generateSecret(spec);

            Cipher cipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] bOut = cipher.doFinal(dataBytes);
            String encryptValue = new BASE64Encoder().encode(bOut);
            System.out.println(">>>>>>加密结果为:  " + encryptValue);
            System.out.println("-----------end----加密-----------------------");
            return encryptValue;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 解密需要的数据
     *
     * @param data 需要解密的数据
     * @param key  密钥
     * @return 解密后的数据
     */
    public static String decryptMode(String data, String key) {
        System.out.println("=============begin====解密=====================");
        System.out.println("<<<<<<<解密KEY为:  " + key);
        System.out.println("<<<<<<<解密参数为:  " + data);
        if (data == null || data.length() == 0) {
            return "";
        }
        if (key == null || key.length() == 0) {
            System.out.println("3DES解密密钥KEY为空!");
            return "";
        }
        try {
            byte[] keyBytes = new BASE64Decoder().decodeBuffer(key);
            byte[] dataBytes = new BASE64Decoder().decodeBuffer(data);

            DESedeKeySpec spec = new DESedeKeySpec(keyBytes);
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
            Key deskey = keyfactory.generateSecret(spec);

            Cipher cipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, deskey);

            byte[] bOut = cipher.doFinal(dataBytes);
            String decryptValue = new String(bOut, "UTF-8");
            System.out.println("<<<<<<<<解密结果为:  " + decryptValue);
            System.out.println("=============end====解密==================");
            return decryptValue;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
