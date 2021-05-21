package com.s2p.practice.leetcode.problems._00100_00200.wordBreakII;

import java.util.*;

/**
 * 140 : https://leetcode.com/problems/word-break-ii/
 */
public class Solution {

    private class SentenceTree {
        String word;
        int start, end;
        Map<String, SentenceTree> trees = new HashMap<>();

        private void addWord(SentenceTree sentenceTree) {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SentenceTree that = (SentenceTree) o;
            return start == that.start &&
                    end == that.end &&
                    word.equals(that.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word, start, end);
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean result = false;
        SentenceTree tree = new SentenceTree();
        wordBreak(s, new HashSet<>(wordDict), 0, tree);
        return result;
    }

    private Map<Integer, SentenceTree> CACHE = new HashMap<>();

    private SentenceTree wordBreak(String s, Set<String> wordDict, int start, SentenceTree sentenceTree) {
        if (start == s.length()) {
            return sentenceTree;
        }

        SentenceTree result = CACHE.get(start);
        if (result != null) {
            return result;
        }

        /*

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)) {
                result = true;
                break;
            }
        }

         */

        CACHE.put(start, result);

        return result;
    }

    // TODO : Not complete
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

    /*


    protected Set<String> wordSet;
    protected HashMap<String, List<List<String>>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        memo = new HashMap<String, List<List<String>>>();

        _wordBreak_topdown(s);

        // chain up words together
        List<String> ret = new ArrayList<String>();
        for (List<String> words : memo.get(s)) {
            StringBuffer sentence = new StringBuffer();
            for (String word : words) {
                sentence.insert(0, word);
                sentence.insert(0, " ");
            }
            ret.add(sentence.toString().strip());
        }

        return ret;
    }

    protected List<List<String>> _wordBreak_topdown(String s) {
        if (s.equals("")) {
            List<List<String>> solutions = new ArrayList<List<String>>();
            solutions.add(new ArrayList<String>());
            return solutions;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        } else {
            List<List<String>> solutions = new ArrayList<List<String>>();
            memo.put(s, solutions);
        }

        for (int endIndex = 1; endIndex <= s.length(); ++endIndex) {
            String word = s.substring(0, endIndex);
            if (wordSet.contains(word)) {
                List<List<String>> subsentences = _wordBreak_topdown(s.substring(endIndex));
                for (List<String> subsentence : subsentences) {
                    List<String> newSentence = new ArrayList<String>(subsentence);
                    newSentence.add(word);
                    memo.get(s).add(newSentence);
                }
            }
        }
        return memo.get(s);
    }


     */
}
