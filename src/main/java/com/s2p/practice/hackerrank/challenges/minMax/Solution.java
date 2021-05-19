package com.s2p.practice.hackerrank.challenges.minMax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/mini-max-sum/problem
// Rank : 165943
public class Solution {

    static void miniMaxSum(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr) {
            list.add(i);
        }
        Collections.sort(list);
        long min = 0;
        long max = 0;
        for(int i = 0;i < list.size(); i++) {
            if(i == 0) {
                min+=list.get(i);
            }
            else if(i == list.size() - 1) {
                max+=list.get(i);
            } else {
                min+=list.get(i);
                max+=list.get(i);
            }
        }
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }
}
