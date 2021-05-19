package com.s2p.practice.hackerrank.challenges.portfolio;

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        String input = "1 2 3 4 5 # # # # 6";
        System.out.println(calculateResult(input));
    }

    private static class Tree {
        int i;
        Tree l;
        Tree r;
        Tree(int i) {
            this.i = i;
        }
    }


    private static int calculateResult(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        String token;

        boolean evenLevel = true;
        int evenSum = 0, oddSum = 0, currentPower = 0;


        while (true) {
            for(int i = 0; i< Math.pow(2,currentPower); i++) {
                if(tokenizer.hasMoreElements()) {
                    token = tokenizer.nextToken();
                    if("#".equals(token)) {
                        continue;
                    } else {
                        if(evenLevel) {
                            evenSum+= Integer.parseInt(token);
                        } else {
                            oddSum+= Integer.parseInt(token);
                        }
                    }
                } else {
                    break;
                }
            }
            currentPower++;
            if(!tokenizer.hasMoreElements()) {
                break;
            }
            evenLevel = !evenLevel;
        }

        return evenSum > oddSum ? evenSum : oddSum;
    }
}
