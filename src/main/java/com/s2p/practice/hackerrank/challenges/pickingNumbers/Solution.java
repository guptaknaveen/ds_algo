package com.s2p.practice.hackerrank.challenges.pickingNumbers;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/picking-numbers/problem
// Rank 92131->89042
public class Solution {

    private static int[] CACHE=new int[100];
    static int pickingNumbers(int[] a) {
        int maxNumbers = Integer.MIN_VALUE;
        int prevNumber = 0;
        for(int i:CACHE) {
            if(i == 0) {
                continue;
            }
            if(maxNumbers < prevNumber + i) {
                maxNumbers = prevNumber + i;
            }
            prevNumber = i;
        }
        return maxNumbers;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            CACHE[a[a_i]]++;
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
