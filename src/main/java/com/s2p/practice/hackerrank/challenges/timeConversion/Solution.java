package com.s2p.practice.hackerrank.challenges.timeConversion;


import java.util.Scanner;

// Rank : 152437
public class Solution {

    static String timeConversion(String s) {
        boolean isPM = s.contains("PM");
        if(isPM) {
            s=s.replaceAll("PM","");
        } else {
            s=s.replaceAll("AM", "");
        }
        int hour,min,sec;
        hour = Integer.parseInt(s.split(":")[0]);
        min = Integer.parseInt(s.split(":")[1]);
        sec = Integer.parseInt(s.split(":")[2]);
        if(isPM) {
            if(hour != 12) {
                hour = (hour + 12)%24;
            }
        } else {
            if(hour == 12) {
                hour = (hour + 12)%24;
            }
        }
        String output = String.format("%02d:%02d:%02d",hour,min,sec);
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}