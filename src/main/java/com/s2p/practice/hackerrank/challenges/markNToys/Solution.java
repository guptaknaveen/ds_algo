package com.s2p.practice.hackerrank.challenges.markNToys;

import java.util.*;


//https://www.hackerrank.com/challenges/mark-and-toys/problem
public class Solution {

    static int maximumToys(int[] prices, int k) {
        return maximumToysArray(prices, k);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] prices = new int[n];
        for(int prices_i = 0; prices_i < n; prices_i++){
            prices[prices_i] = in.nextInt();
        }
        int result = maximumToys(prices, k);
        System.out.println(result);
        in.close();
    }

    private static int max(int a, int b) {
        return a>b?a:b;
    }

    private static int maximumToysArray(int prices[], int k) {
        List<Integer> arrayList = new ArrayList<>();
        for(int price : prices) {
            arrayList.add(price);

        }
        Collections.sort(arrayList);
        int numOFToys = 0;
        for(int price : arrayList) {
            if(price < k) {
                numOFToys++;
                k = k - price;
            }else
            {
                break;
            }
        }
        return numOFToys;
    }


    private static Map<Integer, Integer> INDEX = new HashMap<>();
    private static int maximumToys(int[] prices, int k, int noOfToys, int i) {
        if(INDEX.get(k) != null) {
            return INDEX.get(k);
        }
        if(i == prices.length) {
            return noOfToys;
        }
        if(k > prices[i]) {
            noOfToys = noOfToys+1;
        }

        INDEX.put(k, max(maximumToys(prices, k-prices[i], noOfToys, i+1),
                maximumToys(prices, k, noOfToys, i+1)));
        return  INDEX.get(k);
    }
}
