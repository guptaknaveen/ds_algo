package com.s2p.practice.hackerrank.challenges.pangrams;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/pangrams/problem
// Rank : 74955 -> 71936
public class Solution {
    private static boolean isPanGram(String input) {
        int ch[] = new int[26];
        for(char c:input.toCharArray()) {
            if(c>='A'&&c<='Z') {
                ch[c-'A']++;
            }
            if(c>='a'&&c<='z') {
                ch[c-'a']++;
            }
        }
        for(int i:ch) {
            if(i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isPanGram(scanner.nextLine()) ? "pangram" : "not pangram");
    }
}
