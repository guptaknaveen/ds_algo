package com.s2p.practice.hackerrank.challenges.hackerrankInaString;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
// Rank : 78250 -> 74955
public class Solution {

    private static String hackerrankInString(String s) {
        String str1 = "hackerrank";
        String str2 = s;
        return isSubSequence(str1, str2, str1.length(), str2.length()) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }

    static boolean isSubSequence(String str1, String str2, int m, int n) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        if (str1.charAt(m-1) == str2.charAt(n-1))
            return isSubSequence(str1, str2, m-1, n-1);

        return isSubSequence(str1, str2, m, n-1);
    }
}
