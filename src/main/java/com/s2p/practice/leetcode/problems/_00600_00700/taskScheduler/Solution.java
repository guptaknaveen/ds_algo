package com.s2p.practice.leetcode.problems._00600_00700.taskScheduler;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * /problems/task-scheduler/
 * 621. Task Scheduler
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> countMap = new TreeMap<>(Collections.reverseOrder());
        Integer count;

        int maxFrequency = Integer.MIN_VALUE;
        char maxFrequencyTask = ' ';

        for (char c : tasks) {
            count = countMap.get(c);

            if (count == null) {
                count = 0;
            }
            count = count + 1;

            if (count > maxFrequency) {
                maxFrequency = count;
                maxFrequencyTask = c;
            }

            countMap.put(c, count);
        }

        int freeTimeAfterTasks = (countMap.remove(maxFrequencyTask) - 1) * n;

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                freeTimeAfterTasks = freeTimeAfterTasks - (entry.getValue() - 1);
                continue;
            }
            freeTimeAfterTasks = freeTimeAfterTasks - entry.getValue();
        }

        int result = tasks.length + (freeTimeAfterTasks < 0 ? 0 : freeTimeAfterTasks);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
//        System.out.println(new Solution().leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
//        System.out.println(new Solution().leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }
}
