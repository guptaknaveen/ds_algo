package com.s2p.practice.interview.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Add any extra import statements you may need here
// https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=211548593612944
public class BalanceBrackets {
    // Add any helper functions you may need here
    private static Map<Character, Character> charMap = new HashMap();
    private static Map<Character, Character> closingMap = new HashMap();
    private static Map<Character, Character> openingMap = new HashMap();

    static {
        openingMap.put('{', '}');
        openingMap.put('[', ']');
        openingMap.put('(', ')');

        closingMap.put('}', '{');
        closingMap.put(']', '[');
        closingMap.put(')', '(');

        charMap.putAll(openingMap);
        charMap.putAll(closingMap);
    }

    private boolean isValidChar(char c) {
        return charMap.containsKey(c);
    }

    private boolean isClosingChar(char c) {
        return closingMap.containsKey(c);
    }

    private boolean isOpeningChar(char c) {
        return openingMap.containsKey(c);
    }

    boolean isBalanced(String s) {
        // Write your code here
        int i = 0, size = s.length();

        Stack<Character> stack = new Stack<>();

        char ch;
        for (; i<size; i++) {
            ch = s.charAt(i);
            if (!isValidChar(ch)) {
                continue;
            }

            if (isOpeningChar(ch)) {
                stack.push(ch);
            }

            if (isClosingChar(ch)) {
                Character pop = stack.pop();
                if (!pop.equals(closingMap.get(ch))) {
                    return false;
                }
            }
        }

        return true;
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
        System.out.print("[" + str + "]");
    }

    public void run() {
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BalanceBrackets().run();
    }
}