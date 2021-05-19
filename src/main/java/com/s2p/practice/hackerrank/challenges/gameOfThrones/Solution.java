package com.s2p.practice.hackerrank.challenges.gameOfThrones;

import java.util.Scanner;


// https://www.hackerrank.com/challenges/game-of-thrones/problem
// Rank : 71940 -> 67727
public class Solution {

    static String gameOfThrones(String s){
        int ch[] = new int[26];
        for(char c : s.toCharArray()) {
            ch[c-'a']++;
        }
        int countEven = 0;
        int countOdd = 0;
        for(int i:ch) {
            if(i%2==0) {
                countEven++;
            }
            else {
                countOdd++;
            }
        }
        if(countOdd > 1){
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }
}
