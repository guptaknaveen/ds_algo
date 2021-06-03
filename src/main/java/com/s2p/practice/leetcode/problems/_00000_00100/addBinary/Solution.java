package com.s2p.practice.leetcode.problems._00000_00100.addBinary;

/*
    67 : /problems/add-binary/
 */
public class Solution {
    public String addBinary(String a, String b) {

        int carry = 0;
        int[] sum = new int[2];

        int i = a.length() - 1, j = b.length() - 1;

        StringBuilder result = new StringBuilder();

        char ach, bch;

        while (true) {
            if (i < 0 || j < 0) {
                break;
            }

            ach = a.charAt(i);
            bch = b.charAt(j);

            sum = sum(ach,bch, carry);
            carry = sum[1];

            result.append(sum[0]);

            i--;
            j--;
        }

        while (true) {
            if (i < 0) {
                break;
            }

            ach = a.charAt(i);

            sum = sum(ach,'0', carry);
            carry = sum[1];

            result.append(sum[0]);

            i--;
        }

        while (true) {
            if (j < 0) {
                break;
            }

            bch = b.charAt(j);

            sum = sum('0',bch, carry);
            carry = sum[1];

            result.append(sum[0]);

            j--;
        }

        if (carry == 1) {
            result.append("1");
        }

        return result.reverse().toString();
    }

    private int[] sum(char ach, char bch, int carry) {
        int sum = ach - '0' + bch - '0' + carry;
        return new int[]{sum%2, sum/2};
    }
}