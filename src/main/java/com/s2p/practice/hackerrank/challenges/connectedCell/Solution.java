package com.s2p.practice.hackerrank.challenges.connectedCell;


import java.util.Scanner;

// https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
public class Solution {

    private static int MAX_VALUE = Integer.MIN_VALUE;
    static int connectedCell(int[][] output) {
        System.out.println("\n\n");
        for(int i=0;i<output.length;i++) {
            for(int j=0;j<output[0].length;j++) {
                System.out.print(output[i][j]+"\t");
            }
            System.out.println();
        }
        return MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        int[][] output = new int[n+2][m+2];

        for(int i = 0;i<n+2;i++) {
            for(int j=0;j<m+2;j++) {
                output[i][j] = 0;
            }
        }

        for(int matrix_i = 0; matrix_i < n; matrix_i++){
            for(int matrix_j = 0; matrix_j < m; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
                output[matrix_i+1][matrix_j+1] = matrix[matrix_i][matrix_j];
            }
        }

        int i,j;
        for(int matrix_i = 0; matrix_i < n; matrix_i++){
            for(int matrix_j = 0; matrix_j < m; matrix_j++){
                i = matrix_i + 1;
                j = matrix_j + 1;
                setValue(output, i+1, j, i, j);
                setValue(output, i+1, j-1, i, j);
                setValue(output, i+1, j+1, i, j);
                setValue(output, i, j+1, i, j);

                setValue(output, i-1, j, i, j);
                setValue(output, i-1, j-1, i, j);
                setValue(output, i-1, j+1, i, j);
                setValue(output, i, j-1, i, j);
            }
        }

        int result = connectedCell(output);
        System.out.println(result);
        in.close();
    }

    private static int max(int a, int b, int c, int d) {
        if(a>=b&&a>=c&&a>=d){
            return a;
        }
        if(b>=a&&b>=c&&b>=d) {
            return b;
        }
        if(c>=a&&c>=b&&c>=d) {
            return c;
        }
        if(d>=a&&d>=b&&d>=c) {
            return d;
        }
        return a;
    }

    private static int max(int a,int b) {
        return a>b?a:b;
    }

    private static void setValue(int[][] output, int i, int j, int baseI, int baseJ) {
        if(output[i][j] == 0 || output[baseI][baseJ] == 0) {
            return;
        }
        output[i][j] = max(output[i][j], output[baseI][baseJ]) + 1;
        if(MAX_VALUE < output[i][j]) {
            MAX_VALUE = output[i][j];
        }
    }
}
