package com.s2p.practice.leetcode.problems._00600_00700.maxSwap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * /problems/maximum-swap/
 * 670. Maximum Swap
 */
public class Solution {
    private class Position {
        char ch;
        int index;

        public Position(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    public int maximumSwap(int num) {
        StringBuilder str = new StringBuilder(Integer.toString(num));

        PriorityQueue<Position> positions = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if (o2.ch == o1.ch) {
                    return o1.index - o2.index;
                }
                return o2.ch - o1.ch;
            }
        });

        char ch = ' ';
        int i = 0;

        for (i=0;i<str.length(); i++) {
            positions.add(new Position(str.charAt(i), i));
        }

        Position position = null;
        for (i=0;i<str.length(); i++) {
            ch = str.charAt(i);
            position = positions.poll();
            if (position.ch == ch) {
                continue;
            }
            break;
        }

        Position curr;
        while (true) {
            if (positions.isEmpty()) {
                break;
            }
            curr = positions.poll();
            if (curr.ch == position.ch) {
                position = curr;
            } else {
                break;
            }
        }

        if (position != null && i < str.length()) {
            str.setCharAt(i, position.ch);
            str.setCharAt(position.index, ch);
        }

        return Integer.parseInt(str.toString()) > num ? Integer.parseInt(str.toString()) : num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(1993));
        System.out.println(new Solution().maximumSwap(99088));
    }
}
