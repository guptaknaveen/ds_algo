package com.s2p.practice.hackerrank.challenges.anagram;

import java.util.Scanner;


// https://www.hackerrank.com/challenges/anagram/problem
// Rank : 64542 -> 61588
public class Solution {

    private static int anagram(String s){
        if(s.length()%2!=0) {
            return -1;
        }
        int ch[] = new int[26];
        int i = 0;
        for(char c : s.toCharArray()) {
            if(i < s.length()/2) {
                ch[c-'a']++;
            } else {
                ch[c-'a']--;
            }
            i++;
        }
        int total = 0;
        for(int c:ch) {
            total+= Math.abs(c);
        }
        return total/2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
    }
}
