package com.s2p.practice.algorithm.lsc;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lcs("abcdef", "abdekjkef", 0, 0, 0));
        System.out.println("done");
    }
    private static int[][] lengths;
    static {
        lengths = new int[100][100];
        for(int i = 0; i<100; i++) {
            for(int j = 0; j<100; j++) {
                lengths[i][j] = Integer.MIN_VALUE;
            }
        }
    }
    private static int lcs(String str1, String str2, int i, int j, int maxUptil) {
        int str1L = str1.length();
        int str2L = str2.length();
        if(lengths[i][j] > 0) {
            return lengths[i][j];
        }
        if(i == str1.length() || j == str2.length()) {
            return maxUptil;
        }
        if(str1.charAt(i) == str2.charAt(j)) {
            maxUptil = lcs(str1, str2, i+1, j+1, maxUptil + 1);
        } else {
            maxUptil = max(lcs(str1, str2, i, j+1, maxUptil),lcs(str1, str2,
                    i+1, j,
                    maxUptil));
        }
        lengths[i][j] = maxUptil;
        return lengths[i][j];
     //   return maxUptil;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
