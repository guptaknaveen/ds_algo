package com.s2p.practice.leetcode.problems._00100_00200.wordBreakII;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/
 * 140. Word Break II
 */
public class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordBreak(s, new ArrayList<>(), wordDict);
        return RESULT;
    }

    private List<String> RESULT = new ArrayList<>();

    private void wordBreak(String s, List<String> prevWords, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            RESULT.add(String.join(" ", prevWords));
        }

        List<String> newList;

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                newList = new ArrayList<>(prevWords);
                newList.add(word);
                wordBreak(s.replaceFirst(word, ""), newList, wordDict);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new Solution().wordBreak("applepenapple", Arrays.asList("apple", "pen", "pet", "pent")));
        System.out.println(new Solution().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(new Solution().wordBreak("bccdbacdbdacddabbaaaadababadad", Arrays.asList("cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb")));
    }
}
