package com.s2p.practice.hackerrank.challenges.sherlockCost;

import java.util.*;

//https://www.hackerrank.com/challenges/sherlock-and-cost/problem
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfInput = scanner.nextInt();
        List<Input> inputs = new ArrayList<>();
        for(int i=0;i<noOfInput;i++) {
            inputs.add(Input.createInput(scanner));
        }
        for(Input input : inputs) {
            doJob(input);
        }

    }

    private static class Input {
        int size;
        int[] array;
        static Input createInput(Scanner scanner) {
            Input input = new Input();
            input.size = scanner.nextInt();
            input.array = new int[input.size];
            for(int i = 0;i<input.size; i++) {
                input.array[i] = scanner.nextInt();
            }
            return input;
        }
    }


    private static void doJob(Input input) {
        System.out.println(getMaxSum(input.array, 0, 0, 1));
    }


    private static Map<Integer, Integer> sum = new HashMap<>();
    private static int getMaxSum(int a[], int i, int prevSum, int prevElement) {

        if(i == a.length-1) {
            sum.put(i,max(prevSum+subAbs(prevElement,1), prevSum+subAbs(prevElement,a[i])));
        }
        int leftMax1= Integer.MIN_VALUE, rightMax1 = Integer.MIN_VALUE, maxOfLeftRight = 0;
        if(sum.get(i) != null) {
            return sum.get(i);
        }
        if(i == 0) {
            leftMax1 = getMaxSum(a, i+1, 0, 1);
            rightMax1 = getMaxSum(a, i+1, 0, a[i]);
        } else {
            leftMax1 = subAbs(a[i],prevElement) + getMaxSum(a, i+1, prevSum, a[i]);
            rightMax1 = subAbs(1,prevElement)+ getMaxSum(a, i+1, prevSum, 1);
        }
        sum.put(i,max(leftMax1, rightMax1));
        return sum.get(i);
    }


    private static int max(int a, int b) {
        return a>b?a:b;
    }

    private static int subAbs(int a, int b) {
        return Math.abs(a-b);
    }

}
