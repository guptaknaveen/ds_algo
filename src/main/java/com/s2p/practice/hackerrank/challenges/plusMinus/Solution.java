package com.s2p.practice.hackerrank.challenges.plusMinus;

import java.util.Scanner;

// Rank : 171905
public class Solution {

    static void plusMinus(int[] arr) {
        int plusCount, minusCount, zeroCount;
        plusCount = minusCount = zeroCount = 0;
        for(int i : arr) {
            if(i<0) {
                minusCount++;
                continue;
            }
            if(i>0){
                plusCount++;
                continue;
            }
            zeroCount++;
        }
        //System.out.printf("%.6f", val);
        System.out.printf("%.6f",new Float(plusCount)/new Float(arr.length).doubleValue());
        System.out.println();
        System.out.printf("%.6f",new Float(minusCount)/new Float(arr.length));
        System.out.println();
        System.out.printf("%.6f",new Float(zeroCount)/new Float(arr.length));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
