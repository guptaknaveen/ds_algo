package com.s2p.practice.algorithm.misc;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCharacters {

    private static char[][] keyPad = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r'},
            {'s', 't', 'u'},
            {'v', 'w', 'x'},
            {'y', 'z'},
    };

    public static void main(String[] args) {


        String input = "12";

        updateOutput("", input);

        System.out.println(output);
    }

    private static List<String> output = new ArrayList<>();

    private static void updateOutput(String prefix, String input) {
        if(input.length() == 0) {
            output.add(prefix);
            return;
        }
        for(char ch : keyPad[input.charAt(0)-'1']) {
            updateOutput(prefix+ch, input.substring(1,input.length()));
        }
    }
}
