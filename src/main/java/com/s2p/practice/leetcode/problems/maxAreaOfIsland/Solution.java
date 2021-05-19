package com.s2p.practice.leetcode.problems.maxAreaOfIsland;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// 695 : https://leetcode.com/problems/max-area-of-island/submissions/
public class Solution {

    private static class Entry implements Comparable<Entry> {
        int i;
        int j;
        int value;

        Entry(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }


        public int compareTo(Entry o) {
            return  this.value - o.value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "i=" + i +
                    ", j=" + j +
                    ", value=" + value +
                    '}';
        }
    }

    private static Entry newE(int i, int j, int value) {
        return new Entry(i, j, value);
    }

    private static void addE(Queue s, Entry e, int rows, int columns, int[][] grid) {
        int x,y;

        x = e.i - 1;
        y = e.j;

        if (isValid(x, y, rows, columns)) {
            s.add(newE(x, y, grid[x][y]));
        }

        x = e.i + 1;
        y = e.j;

        if (isValid(x, y, rows, columns)) {
            s.add(newE(x, y, grid[x][y]));
        }

        x = e.i;
        y = e.j + 1;

        if (isValid(x, y, rows, columns)) {
            s.add(newE(x, y, grid[x][y]));
        }

        x = e.i;
        y = e.j - 1;

        if (isValid(x, y, rows, columns)) {
            s.add(newE(x, y, grid[x][y]));
        }

    }

    private static boolean isValid(int i, int j, int rows, int columns) {
        if (i>=0 && i<rows && j >=-0 && j<columns) {
            return true;
        }
        return false;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;

        boolean[][] t = new boolean[rows][columns];

        Queue<Entry> queue = new PriorityQueue(Collections.reverseOrder());

        int maxArea = 0, currentArea = 0;

        queue.add(newE(0, 0, grid[0][0]));

        Entry curr;

        while(true) {

            try {

                curr = queue.poll();

                if (curr == null) {
                    break;
                }

                if (t[curr.i][curr.j]) {
                    continue;
                }

                if (grid[curr.i][curr.j] == 1) {
                    currentArea++;

                    if (currentArea > maxArea) {
                        maxArea = currentArea;
                    }

                } else {
                    currentArea = 0;
                }

                t[curr.i][curr.j] = true;

                addE(queue, curr, rows, columns, grid);

            } catch (Exception e) {
                break;
            }

        }

        return maxArea;
    }
}
