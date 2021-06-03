package com.s2p.practice.leetcode.problems._00100_00200.wordBreak;

import java.util.*;

/**
 * 139 : /problems/word-break/
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0);
    }

    private Map<Integer, Boolean> CACHE = new HashMap<>();

    private boolean wordBreak(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        Boolean result = CACHE.get(start);
        if (result != null) {
            return result;
        }

        result = false;

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)) {
                result = true;
                break;
            }
        }

        CACHE.put(start, result);

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().wordBreak("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(new Solution().wordBreak("applepenapple", Arrays.asList("apple", "pen", "pet", "pent")));
//        System.out.println(new Solution().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(new Solution().wordBreak("bccdbacdbdacddabbaaaadababadad", Arrays.asList("cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb")));

        /*
        "bccdbacdbdacddabbaaaadababadad"
["cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"]

         */
    }
}
