package com.s2p.practice.interview.facebook;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=2237975393164055
public class MinimumLengthSubstrings {

    // Add any helper functions you may need here
    int slidingWindow(int start, String s, String t) {
        Map<Character, Integer> map = new HashMap();

        char ch;
        int ws = t.length();

        for (int i = 0; i<ws; i++) {
            ch = t.charAt(i);
            if (map.get(ch) == null) {
                map.put(ch, 0);
            }

            map.put(ch, map.get(ch) + 1);
        }

        int sI = -1;
        int eI = -1;

        for (int i = start; i<s.length(); i++) {
            ch = s.charAt(i);

            if (map.get(ch) == null) {
                continue;
            }

            if (sI == -1) {
                sI = i;
            }
            eI = i;

            Integer cnt = map.get(ch);
            if (cnt == 1) {
                map.remove(ch);
            } else {
                map.put(ch, cnt-1);
            }

            if(map.size() == 0) {
                break;
            }
        }

        if (sI < 0 || eI < 0 || map.size() != 0) {
            return -1;
        }

        return eI - sI + 1;
    }

    int minLengthSubstring(String s, String t) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        int count;
        for (int i = 0; i<s.length() - t.length(); i++) {
            count = slidingWindow(i, s, t);

            if (count == -1) {
                continue;
            }

            if (count < min) {
                min  = count;
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) throws IOException {
        new MinimumLengthSubstrings().run();
    }
}