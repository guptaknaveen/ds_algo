package com.s2p.practice.hackerrank.challenges.countingsort2;

import java.util.Scanner;


// https://www.hackerrank.com/challenges/countingsort2/problem
// Rank : 126680
public class Solution {

    static int[] countingSort(int[] arr) {
        int output[] = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            output[i] = 0;
        }
        for(int i:arr) {
            output[i]++;
        }
        int finalOutput[] = new int[arr.length];
        int j = 0;
        for(int i=0;i<output.length;i++) {
            if(output[i] == 0) {
                continue;
            }
            for(int k=0;k<output[i];k++) {
                finalOutput[j++]=i;
            }
        }
        return finalOutput;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = countingSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        in.close();
    }
}
