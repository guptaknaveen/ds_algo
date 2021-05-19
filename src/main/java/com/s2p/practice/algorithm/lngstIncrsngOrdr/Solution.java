package com.s2p.practice.algorithm.lngstIncrsngOrdr;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List lst = new ArrayList<>();
        lst.add(Integer.MIN_VALUE);
        System.out.println(getLongestIncresingSubSequence(new int[]{10,15,4,3,4,5,20,40,50,2}, lst, 0));
    }

    private static List<Integer> getLongestIncresingSubSequence(int[] a, List<Integer> lsc, int i) {
        if(i == a.length ) {
            return lsc;
        }
        List leftSubList = getLongestIncresingSubSequence(a, new ArrayList<>(lsc), i+1);
        List<Integer> rightTempList = new ArrayList<>(lsc);
        if(a[i] > lsc.get(lsc.size()-1)) {
            rightTempList.add(a[i]);
        }

        List rightSubList = getLongestIncresingSubSequence(a, rightTempList, i+1);
        return leftSubList.size() > rightSubList.size() ? leftSubList : rightSubList;
    }
}


