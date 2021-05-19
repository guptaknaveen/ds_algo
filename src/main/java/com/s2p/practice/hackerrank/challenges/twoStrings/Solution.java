package com.s2p.practice.hackerrank.challenges.twoStrings;

import java.util.Scanner;


// https://www.hackerrank.com/challenges/two-strings/problem
// Rank : 67727 -> 64542
public class Solution {

    static String twoStrings(String s1, String s2){
        int ch[] = new int[26];
        for(char c : s1.toCharArray()) {
            ch[c-'a']++;
        }
        for(char c : s2.toCharArray()) {
            if(ch[c-'a'] > 0) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }
}
