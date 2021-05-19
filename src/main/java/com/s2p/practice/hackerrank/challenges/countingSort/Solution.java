package com.s2p.practice.hackerrank.challenges.countingSort;

import java.util.Scanner;


// Rank : 138497
public class Solution {

    static int[] countingSort(int[] arr) {
        int output[] = new int[100];
        for(int i=0;i<100;i++) {
            output[i] = 0;
        }
        for(int i:arr) {
            if(i<0 || i>99 ) {
                continue;
            }
            output[i]++;
        }
        return output;
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
