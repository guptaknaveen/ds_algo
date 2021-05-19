package com.s2p.practice.hackerrank.challenges.gradingStudents;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        int next5Multiple;
        for (int i = 0; i<grades.length; i++) {
            if (grades[i] < 38 || grades[i] % 5 ==0) {
                continue;
            }
            next5Multiple = next5Multiple(grades[i]);
            if (next5Multiple - grades[i] < 3) {
                grades[i] = next5Multiple;
             }
        }
        return grades;
    }

    private static int next5Multiple(int number) {
        while ((++number)%5!=0) { }
        return number;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("GradingStudents.txt"));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
