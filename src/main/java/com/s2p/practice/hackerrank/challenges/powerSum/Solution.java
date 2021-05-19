package com.s2p.practice.hackerrank.challenges.powerSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int sum = Integer.parseInt(str1);
        int pow = Integer.parseInt(str2);
        System.out.println(count(sum, 1, pow));
    }

    private static long count(long sum, long number, int pow) {
        long powerNumber = 1;
        for(int i=0;i<pow;i++) {
            powerNumber*=number;
        }
        if(powerNumber > sum) {
            return 0;
        }
        if(powerNumber == sum) {
            return 1;
        }
        return count(sum, number+1, pow) + count(sum-powerNumber, number+1, pow);
    }
}