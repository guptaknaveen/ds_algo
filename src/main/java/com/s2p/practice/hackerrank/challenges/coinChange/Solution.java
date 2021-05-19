package com.s2p.practice.hackerrank.challenges.coinChange;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static long getWays(long n, long[] c){
        return total(n, c, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }

    private static Map<Long, Map<Integer, Long>> INDEX = new HashMap();

    public static long total(long n, long[] v, int i) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        // means coins over and n>0 so no solution
        if (i == v.length && n > 0) {
            return 0;
        }

        if(INDEX.get(n) == null){
            INDEX.put(n, new HashMap<Integer, Long>());
        }
        if(INDEX.get(n).get(i) == null) {
            long left = total(n - v[i], v, i);
            long right = total(n, v, i + 1);



                INDEX.get(n).put(i, left+right);


        }
        return  INDEX.get(n).get(i);
    }
}