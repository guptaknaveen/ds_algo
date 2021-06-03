package com.s2p.practice.leetcode.problems._00000_00100.divideTwoIntegers;

/*
    29 : /problems/divide-two-integers/
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }

        int quotient = 0, prevQuotient = 0;
        int sum = 0, prevSum = 0;

        boolean isNegative;

        if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
            isNegative = false;
        } else {
            isNegative = true;
        }


        dividend = dividend < 0 ? dividend : -dividend;

        divisor = Math.abs(divisor);

        if (dividend != Integer.MIN_VALUE && Math.abs(dividend) < divisor) {
            return 0;
        }

        int result = 0;
        quotient = 1;
        sum = -divisor;

        int HALF_INT = -1073741824;

        while(true) {
            if (sum < dividend || sum < HALF_INT) {
                result = result + prevQuotient;
                dividend = dividend - prevSum;
                sum = -divisor;
                quotient = 1;
            }

            if (sum < dividend) {
                break;
            }

            if (sum < HALF_INT) {
                result = result + quotient;
                break;
            }

            prevSum = sum;
            prevQuotient = quotient;

            sum = sum + sum;

            quotient = quotient + quotient;
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(10, 3));
        System.out.println(new Solution().divide(21, -3));
        System.out.println(new Solution().divide(Integer.MAX_VALUE, 2));
        System.out.println(new Solution().divide(Integer.MIN_VALUE, 2));
        //1100540749
        //-1090366779
        System.out.println(new Solution().divide(1100540749, -1090366779));
    }
}