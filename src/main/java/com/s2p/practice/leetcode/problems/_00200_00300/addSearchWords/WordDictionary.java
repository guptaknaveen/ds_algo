package com.s2p.practice.leetcode.problems._00200_00300.addSearchWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /problems/design-add-and-search-words-data-structure/
 * 211. Design Add and Search Words Data Structure
 */
public class WordDictionary {
    private class Trie {
        boolean isWord;
        private Map<Character, Trie> trieMap = new HashMap<>();

        Trie getChild(char ch) {
            return trieMap.get(ch);
        }

        void addWord(String word) {
            Trie curr = this;
            for (char ch : word.toCharArray()) {
                curr = curr.createChild(ch);
            }
            curr.isWord = true;
        }

        Trie createChild(char ch) {
            Trie child = getChild(ch);
            if (child == null) {
                child = new Trie();
                trieMap.put(ch, child);
            }
            return child;
        }

        List<Trie> children() {
            return new ArrayList<>(this.trieMap.values());
        }
    }

    private Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.addWord(word);
    }

    public boolean search(String word) {
        if (word.length() == 0) {
            return true;
        }
        List<Trie> possibleTries = new ArrayList<>();
        possibleTries.add(trie);

        List<Trie> curr = new ArrayList<>(possibleTries);

        int currentIndex = 0, size = word.length();
        Trie child;

        for (char ch : word.toCharArray()) {
            currentIndex++;

            possibleTries = new ArrayList<>();
            for (Trie t : curr) {
                child = t.getChild(ch);
                if (ch == '.') {
                    possibleTries.addAll(t.children());
                    continue;
                } else if (child == null) {
                    continue;
                }
                possibleTries.add(child);

                if (currentIndex == size && child.isWord) {
                    return true;
                }
            }

            if (possibleTries.isEmpty()) {
                return false;
            }

            curr = possibleTries;
        }

        for (Trie t : possibleTries) {
            if (t.isWord) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("");
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        dictionary.addWord("bad");

        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("b.."));
        System.out.println(dictionary.search("pad"));
    }
}
