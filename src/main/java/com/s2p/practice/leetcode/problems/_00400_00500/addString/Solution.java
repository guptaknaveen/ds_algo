package com.s2p.practice.leetcode.problems._00400_00500.addString;

/**
 * https://leetcode.com/problems/add-strings/
 * 415. Add Strings
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }

        StringBuilder result = new StringBuilder();

        int li = num1.length() - 1;
        int ri = num2.length() - 1;

        int carry = 0;
        int currentSum = 0;

        while (true) {
            if (li < 0 || ri < 0) {
                break;
            }
            currentSum = (num1.charAt(li) - '0' + num2.charAt(ri) - '0') + carry;
            carry = currentSum / 10;
            result.append(currentSum % 10);

            li--;
            ri--;
        }

        while (true) {
            if (li < 0) {
                break;
            }
            currentSum = (num1.charAt(li) - '0') + carry;
            carry = currentSum / 10;
            result.append(currentSum % 10);

            li--;
        }

        while (true) {
            if (ri < 0) {
                break;
            }
            currentSum = (num2.charAt(ri) - '0') + carry;
            carry = currentSum / 10;
            result.append(currentSum % 10);

            ri--;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("123", "7675"));
    }
}
