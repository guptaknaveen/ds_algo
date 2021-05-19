package com.s2p.practice.hackerrank.challenges.newYearChaos;

// https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here

        int ci = 0, count = 0, totalCount = 0;

        boolean tooChaotic = false;

        Map<Integer, Boolean> traversed = new HashMap<>();

        while (true) {
            if (ci >= q.size()) {
                break;
            }

            if (traversed.get(ci) != null) {
                ci++;
                continue;
            }

            int cv = q.get(ci);

            traversed.put(ci, true);

            count = 0;

            while (cv != ci+1) {
                traversed.put(cv - 1, true);
                cv = q.get(cv - 1);
                count++;
            }

            if (count > 2) {
                tooChaotic = true;
                System.out.println("Too chaotic");
                break;
            }

            totalCount = totalCount + count;

            ci = cv - 1;
        }

        if (!tooChaotic) {
            System.out.println(totalCount);
        }

    }

}

public class Solution {
    public static void main_01(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] qTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> q = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qTemp[i]);
                q.add(qItem);
            }

            Result.minimumBribes(q);
        }

        bufferedReader.close();
    }

    public static void main(String[] args) {
//        Result.minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
//        Result.minimumBribes(Arrays.asList(2, 5, 1, 3, 4));
//        Result.minimumBribes(Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8));
//        Result.minimumBribes(Arrays.asList(4, 1, 2, 3));
        Result.minimumBribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
    }
}
