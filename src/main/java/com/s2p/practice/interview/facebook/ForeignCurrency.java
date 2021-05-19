package com.s2p.practice.interview.facebook;

// https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=2903692913051025

import java.util.HashMap;
import java.util.Map;
// Add any extra import statements you may need here


public class ForeignCurrency {

    // Add any helper functions you may need here
    private Map<Integer, Boolean> cache = new HashMap();

    private boolean isSingleCoin(int targetMoney, int[] denominations) {
        for (int d : denominations) {
            if (d == targetMoney) {
                return true;
            }
        }
        return false;
    }

    private boolean isLessThanSingleCoin(int targetMoney, int[] denominations) {
        for (int d : denominations) {
            if (d < targetMoney) {
                return false;
            }
        }
        return true;
    }


    boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        if (cache.get(targetMoney) != null) {
            return cache.get(targetMoney);
        }

        if (isSingleCoin(targetMoney, denominations)) {
            return true;
        }

        if (isLessThanSingleCoin(targetMoney, denominations)) {
            return false;
        }

        boolean result = false;
        for (int d : denominations) {
            result = result || canGetExactChange(targetMoney - d, denominations);
        }

        cache.put(targetMoney, result);

        return result;
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        int target_1 = 94;
        int arr_1[] = {5, 10, 25, 100, 200};
        boolean expected_1 = false;
        boolean output_1 = canGetExactChange(target_1, arr_1);
        check(expected_1, output_1);

        int target_2 = 75;
        int arr_2[] = {4, 17, 29};
        boolean expected_2 = true;
        boolean output_2 = canGetExactChange(target_2, arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ForeignCurrency().run();
    }
}