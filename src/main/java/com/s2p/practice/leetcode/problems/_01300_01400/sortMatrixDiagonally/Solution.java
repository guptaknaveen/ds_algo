package com.s2p.practice.leetcode.problems._01300_01400.sortMatrixDiagonally;

import java.util.*;

/**
 * 1329 : https://leetcode.com/problems/sort-the-matrix-diagonally/
 */
public class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;


        Map<Integer, List<Integer>> diagonalDataMap = new HashMap<>();
        Map<Integer, List<Integer>> iSMap = new HashMap<>();
        Map<Integer, List<Integer>> jSMap = new HashMap<>();

        List<Integer> tempList, tempIsList, tempJsList;
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {

                tempList = diagonalDataMap.get(i - j);
                tempIsList = iSMap.get(i - j);
                tempJsList = jSMap.get(i - j);

                if (tempList == null) {
                    tempList = new ArrayList<>();
                    tempIsList = new ArrayList<>();
                    tempJsList = new ArrayList<>();
                }

                tempIsList.add(i);
                tempJsList.add(j);
                tempList.add(mat[i][j]);

                diagonalDataMap.put(i - j, tempList);
                iSMap.put(i - j, tempIsList);
                jSMap.put(i - j, tempJsList);
            }
        }

        int result[][] = new int[rows][cols];

        for (Map.Entry<Integer, List<Integer>> entry : diagonalDataMap.entrySet()) {
            Collections.sort(entry.getValue());

            tempList = entry.getValue();
            tempJsList = jSMap.get(entry.getKey());
            tempIsList = iSMap.get(entry.getKey());

            for (int i = 0 ;i<tempList.size(); i++) {
                result[tempIsList.get(i)][tempJsList.get(i)] = tempList.get(i);
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.diagonalSort(new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}});

        int rows = result.length, cols = result[0].length;

        for (int i = 0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}

