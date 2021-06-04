package com.s2p.practice.leetcode.problems._01000_01100.removeDuplicates;

/**
 * /problems/remove-all-adjacent-duplicates-in-string/
 * 1047. Remove All Adjacent Duplicates In String
 */
public class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca"));
        System.out.println(new Solution().removeDuplicates("azxxxzy"));
    }
}
