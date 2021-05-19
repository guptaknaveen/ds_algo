package com.s2p.practice.hackerrank.challenges.designerpdfviewer;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
// Rank : 96506 -> 92131
public class Solution {

    static int designerPdfViewer(int[] h, String word) {
        int maxHeight = Integer.MIN_VALUE;
        for(char ch : word.toCharArray()) {
            if(maxHeight < h[ch-'a']) {
                maxHeight = h[ch-'a'];
            }
        }
        return maxHeight*word.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i = 0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }
}
