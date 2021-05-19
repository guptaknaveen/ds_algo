package com.s2p.practice.hackerrank.challenges.marsExploration;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/mars-exploration/problem
// Rank : 80820 -> 78250
public class Solution {

    static int marsExploration(String s) {
        int count = 0;
        char SOS[] = {'S','O','S'};
        for(int i=0;i<s.length();i++) {
            if(SOS[i%3] == s.charAt(i)) {
                continue;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = marsExploration(s);
        System.out.println(result);
        in.close();
    }
}
