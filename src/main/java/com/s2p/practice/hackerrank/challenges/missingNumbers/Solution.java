package com.s2p.practice.hackerrank.challenges.missingNumbers;

// https://www.hackerrank.com/challenges/missing-numbers/problem
// Rank : 102977
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static int[] missingNumbers(int[] arr, int[] brr) {
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<OUTPUT.length;i++) {
            if(OUTPUT[i]>0) {
                output.add(i+MIN_NUMBER);
            }
        }
        int outputArray[] = new int[output.size()];
        int j = 0;
        for(int i : output) {
            outputArray[j++] = i;
        }
        return outputArray;
    }

    private static int MIN_NUMBER = Integer.MAX_VALUE;
    private static int MAX_VALUE = Integer.MIN_VALUE;
    private static int[] OUTPUT = new int[100];
    static {
        for(int i = 0;i<100;i++) {
            OUTPUT[i] = Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }

        for(int e : brr) {
            if(MIN_NUMBER > e) {
                MIN_NUMBER = e;
            }
            if(MAX_VALUE < e) {
                MAX_VALUE = e;
            }
        }

        for(int e : brr) {
            if(OUTPUT[e-MIN_NUMBER] == Integer.MIN_VALUE) {
                OUTPUT[e-MIN_NUMBER] = 0;
            }
            OUTPUT[e-MIN_NUMBER]++;
        }

        for(int e : arr) {
            OUTPUT[e - MIN_NUMBER]--;
        }

        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}


/*

10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204

 */