package com.s2p.practice.algorithm.misc;

public class MissingNumber {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 0;
        int xor1 = a^b^c^d^e;
        System.out.println(xor1);


        a = 1;
        b = 2;
        c = 3;
        d = 3;
        e = 0;
        int xor2 = a^b^c^d^e;
        System.out.println(xor2);

        System.out.println(xor1^xor2);
    }
}
