package com.s2p.practice.leetcode.problems.canonicalPath;

import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public String simplifyPath(String path) {
        StringTokenizer stringTokenizer = new StringTokenizer(path, "/");

        Stack<String> folders = new Stack<>();

        String folderName;
        while (stringTokenizer.hasMoreTokens()) {
            folderName = stringTokenizer.nextToken();

            if (folderName.length() == 0) {
                continue;
            }

            if (folderName.equals(".")) {
                continue;
            }

            if (folderName.equals("..")) {
                if (!folders.empty()) {
                    folders.pop();
                }
                continue;
            }

            folders.push(folderName);
        }

        StringBuilder result = new StringBuilder();

        StringBuilder str;

        while (true) {
            if (folders.empty()) {
                break;
            }
            str = new StringBuilder(folders.pop());

            if (result.length() > 0) {
                str.append("/");
            }
            str.append(result);

            result = str;
        }

        result = new StringBuilder("/").append(result);

        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().simplifyPath("/home/"));
//        System.out.println(new Solution().simplifyPath("/../"));
//        System.out.println(new Solution().simplifyPath("/home//foo/"));
        System.out.println(new Solution().simplifyPath("/a/./../b/../../c/../"));
    }
}
