package com.s2p.practice.leetcode.problems.dateDifference;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class Solution {
    public int daysBetweenDates(String date1, String date2) {

        try {
            String strd1[] = date1.split("-");
            String strd2[] = date2.split("-");
            Date d1 = new Date(Integer.parseInt(strd1[0]) - 1900, Integer.parseInt(strd1[1]) - 1, Integer.parseInt(strd1[2]));
            Date d2 = new Date(Integer.parseInt(strd2[0]) - 1900, Integer.parseInt(strd2[1]) - 1, Integer.parseInt(strd2[2]));

            long diffInMillies = Math.abs(d2.getTime() - d1.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            return (int)diff;

        } catch(Exception e) {

        }

        return -1;
    }

    /*
    "2020-01-15"
    "2019-12-31"

     */

    public static void main(String[] args) {
        System.out.println(new Solution().daysBetweenDates("2020-01-15", "2019-12-31"));
    }
}
