package com.s2p.practice.hackerrank.challenges.commonChild;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static Map<Integer, Map<Integer, Integer>> CACHE = new HashMap<>();

    static int commonChild(String s1, String s2){
        return lcs(s1,s2,0,0,0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }

    private static int lcs(String s1, String s2, int i, int j, int count) {
        if(i == s1.length() || s2.length() == j) {
            return count;
        }
        int current;
        if(s1.charAt(i) == s2.charAt(j)) {
            current = lcs(s1,s2,i+1,j+1, count+1);
        } else {
            current = max(max(lcs(s1,s2,i+1,j+1, count), lcs(s1,s2,i,j+1, count)), lcs(s1,s2,i+1,j, count));
        }
        if(CACHE.get(i) == null) {
            CACHE.put(i, new HashMap<>());
        } else if(CACHE.get(i).get(j) != null) {
            return CACHE.get(i).get(j);
        }
        CACHE.get(i).put(j, current);
        return current;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
