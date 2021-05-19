package com.s2p.deleteMe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestClass {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("/Users/naveen/Projects/hackerrank/src/com/s2p/temp/result.csv")));
            int count = 0,i;
            int sum = 0;
            int countSumGt270 = 0;
            int correctFindCount = 0;
            boolean checkForSum = false;
            String str;
            while ((str = br.readLine()) != null) {
                i = Integer.parseInt(str.trim());
                if (count == 3) {
                    if (sum > 280) {
                        countSumGt270++;
                        checkForSum = true;
                    } else {
                        checkForSum = false;
                    }
                }
                sum+=i;
                if (++count == 4) {
                    if (checkForSum) {
                        if (i>=40&&i<=100) {
                            correctFindCount++;
                        }
                    }
                    System.out.println(sum);
                    sum = 0;
                    count = 0;
                }
            }
            System.out.println(countSumGt270);
            System.out.println(correctFindCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
