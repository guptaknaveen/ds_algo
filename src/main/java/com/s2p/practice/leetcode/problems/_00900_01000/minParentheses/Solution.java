package com.s2p.practice.leetcode.problems._00900_01000.minParentheses;

import java.util.Stack;

/**
 * /minimum-add-to-make-parentheses-valid/
 * 921. Minimum Add to Make Parentheses Valid
 */
public class Solution {
    public int minAddToMakeValid(String s) {
        int result = 0;

        if (s == null || s.length() == 0) {
            return result;
        }

        Stack<Character> stack = new Stack<>();

        Character fromStack = null;
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if (ch == ')') {
                fromStack = stack.peek();
                if (fromStack == null) {
                    stack.push(ch);
                } else if (fromStack == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }

        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            result++;
            stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minAddToMakeValid("())"));
        System.out.println(new Solution().minAddToMakeValid("((("));
        System.out.println(new Solution().minAddToMakeValid("()"));
        System.out.println(new Solution().minAddToMakeValid("()))(("));
    }
}
