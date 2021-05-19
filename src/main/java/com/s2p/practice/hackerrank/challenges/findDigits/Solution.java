package com.s2p.practice.hackerrank.challenges.findDigits;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/find-digits/problem
// Rank : 89048 -> 84333
public class Solution {

    static int findDigits(int n) {
        int output = 0;
        for(int i = 0; i< Integer.toString(n).length(); i++) {
            if(Integer.toString(n).charAt(i) == '0') {
                continue;
            }
            if(n%(Integer.toString(n).charAt(i)-'0')==0) {
                output++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = findDigits(n);
            System.out.println(result);
        }
        in.close();
    }
}
