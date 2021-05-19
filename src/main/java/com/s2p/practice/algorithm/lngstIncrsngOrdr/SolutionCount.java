package com.s2p.practice.algorithm.lngstIncrsngOrdr;

import java.util.HashMap;
import java.util.Map;

public class SolutionCount {
    public static void main(String[] args) {
        System.out.println(count(new int[]{2,3,6,3,1,10}, 0, 1, 0));
        System.out.println(count(new int[]{10,22,9,33,21,50,41,60,80}, 0, 1, 0));
        System.out.println(count(new int[]{3, 10, 2, 1, 20}, 0, 1, 0));
        System.out.println(count(new int[]{3, 2}, 0, 1, 0));
        System.out.println(count(new int[]{50, 3, 10, 7, 40, 80}, 0, 1, 0));
    }

    private static Map<Integer, Map<Boolean, Integer>> CACHE = new HashMap<>();

    private static int count(int arr[], int i, int j, int c) {
        if(i == arr.length || j == arr.length) {
            return c+1;
        }
        if(arr[i] < arr[j]) {
            return
                    max(
                            count(arr, j, j+1, c+1), count(arr, j+1, j+2, c)
                    );
        }
        return
                max(
                        count(arr, i, j+1, c), count(arr, j, j+1, c)
                );
    }

    private static int max(int a, int b) {
        return a < b ? b : a;
    }

    /*private static int getCount(int i, int j, boolean isIncluded) {
        if(CACHE.get(i) == null) {
            if(isIncluded) {
                CACHE.put();
            } else {

            }
        }
    }*/
}
