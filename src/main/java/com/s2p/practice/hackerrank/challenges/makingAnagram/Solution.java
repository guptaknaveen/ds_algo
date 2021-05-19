package com.s2p.practice.hackerrank.challenges.makingAnagram;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/making-anagrams/problem
// Rank : 61588 -> 58259
public class Solution {

    static int makingAnagrams(String s1, String s2){
        int ch[] = new int[26];
        int i = 0;
        for(char c : s1.toCharArray()) {
            ch[c - 'a']++;
        }
        for(char c : s2.toCharArray()) {
            ch[c - 'a']--;
        }
        for(int c:ch) {
            i+= Math.abs(c);
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
