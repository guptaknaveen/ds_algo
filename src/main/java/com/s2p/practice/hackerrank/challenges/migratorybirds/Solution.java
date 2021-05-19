package com.s2p.practice.hackerrank.challenges.migratorybirds;

import java.util.Scanner;

public class Solution {

    static int migratoryBirds(int n, int[] ar) {
        int maxIndex = 0;
        int MAX = Integer.MIN_VALUE;
        int[] count = new int[5];
        for(int i:ar) {
            count[i-1]++;
            if(count[i-1] > MAX) {
                MAX = count[i-1];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
