package org.fred.ztest.main;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class MainTest {

    public static void main(String[] args) {
        //System.out.println(Arrays.asList(null));
        System.out.println(Arrays.asList(""));



        String a = "123234";
        String b = "12";
        System.out.println(a.contains(b));
        System.out.println(b.contains(a));

        System.out.println(new Date(1453552680617L));

        System.out.println("----------");
        int kk = 100000;
        int kki = 0;
        for (int i = 0; i < 10000; i++) {
            int j = new Random().nextInt(10000) + 1;
            System.out.println((double) j / 100 + "%");
            if (j < kk) {
                kk = j;
                kki = i;
            }
        }
        System.out.println(kki + "--------------------" + kk);
    }

}
