package com.s2p.practice.hackerrank.challenges.breakingWorstBest;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
// Rank : 115596
public class Solution {

    static int[] breakingRecords(int[] score) {
        int l=score[0],h=score[0];
        int countl = 0, counth = 0;
        for(int s : score) {
            if(s > h) {
                h = s;
                counth++;
            }
            if(s < l) {
                l = s;
                countl++;
            }
        }
        return new int[]{counth, countl};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
