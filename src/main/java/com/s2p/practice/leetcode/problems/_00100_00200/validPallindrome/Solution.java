package com.s2p.practice.leetcode.problems._00100_00200.validPallindrome;

/**
 * 125 : https://leetcode.com/problems/valid-palindrome/
 */
public class Solution {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        char lch, rch;

        while (true) {
            if (i > j) {
                break;
            }

            lch = s.charAt(i);
            rch = s.charAt(j);

            if (isInvalidCharacter(lch)) {
                i++;
                continue;
            }

            if (isInvalidCharacter(rch)) {
                j--;
                continue;
            }

            if (toLowerCase(lch) != toLowerCase(rch)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private boolean isInvalidCharacter(char ch) {
        if (ch >= '0' && ch <='9') {
            return false;
        }
        if (ch >= 'a' && ch <= 'z') {
            return false;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return false;
        }
        return true;
    }

    private char toLowerCase(char ch) {
        return Character.toLowerCase(ch);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
    }
}
