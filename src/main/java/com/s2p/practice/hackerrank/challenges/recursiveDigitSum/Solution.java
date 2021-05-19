package com.s2p.practice.hackerrank.challenges.recursiveDigitSum;

import java.util.Scanner;

public class Solution {

    static int superDigit(String n, int k) {
        StringBuilder input = new StringBuilder();
        for(int i=0;i<k;i++) {
            input.append(sum(n));
            if(i%2000000==0){
                input = new StringBuilder(sum(input.toString()));
            }

        }
        return Integer.parseInt(sum(input.toString()));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        int result = superDigit(n, k);
        System.out.println(result);
        in.close();
    }

    private static String sum(String input) {
        if(input.length() <= 1) {
            return input;
        }
        int i = 0;
        long sumOfChars = 0;
        for(;i<input.length();i++) {
            sumOfChars+=input.charAt(i)-48;
        }
        StringBuilder str = new StringBuilder(Long.toString(sumOfChars));
        if(i<input.length()) {
            str.append(input.substring(i, input.length()));
        }
        return sum(str.toString());
    }
}
