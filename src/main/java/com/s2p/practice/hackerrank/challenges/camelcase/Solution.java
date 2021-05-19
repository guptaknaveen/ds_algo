package com.s2p.practice.hackerrank.challenges.camelcase;

import java.util.Scanner;

public class Solution {
    static int camelcase(String s) {
        int count = 1;
        char ch;
        if(s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        for(int i=1;i<s.length();i++) {
            ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }
}
