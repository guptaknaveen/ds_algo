package com.s2p.practice.hackerrank.challenges.fullCountingSort;

// https://www.hackerrank.com/challenges/countingsort2/problem
// Rank :

import java.util.*;

public class Solution {

    private static Map<Integer, List<Input>> MAP = new TreeMap<>();
    private static int SIZE = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int index = 0;
        Input input;
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            String s = in.next();
            input = new Input(index++, x, s);
            if(MAP.get(input.i) == null) {
                MAP.put(input.i, new ArrayList<Input>());
            }
            MAP.get(input.i).add(input);
            SIZE++;
        }
        printOutput();
        in.close();
    }

    /*public static void main_1(String[] args) {
        printOutput(inputs());
    }*/


    private static void printOutput() {
        for(Map.Entry<Integer, List<Input>> entry : MAP.entrySet()) {
            for(Input input : entry.getValue()) {
                if(input.index >= SIZE/2) {
                    System.out.print(input.v+" ");
                } else {
                    System.out.print("- ");
                }
            }
        }
    }

    private static class Input {
        Input(int index, int i, String v) {
            this.i = i;
            this.v = v;
            this.index = index;
        }
        int index;
        int i;
        String v;
    }


    private static Set<Input> inputs() {
        Set<Input> inputs = new TreeSet<>(new Comparator<Input>() {
            @Override
            public int compare(Input o1, Input o2) {
                return o1.i - o2.i == 0 ? o1.index - o2.index : o1.i - o2.i;
            }
        });
        inputs.add(new Input(0,6,"cd"));
        inputs.add(new Input(1,0,"ef"));
        inputs.add(new Input(2,6,"gh"));
        inputs.add(new Input(3,4,"ij"));
        inputs.add(new Input(4,0,"ab"));
        inputs.add(new Input(5,6,"cd"));
        inputs.add(new Input(6,0,"ef"));
        inputs.add(new Input(7,6,"gh"));
        inputs.add(new Input(8,0,"ij"));
        inputs.add(new Input(9,4,"that"));
        inputs.add(new Input(10,3,"be"));
        inputs.add(new Input(11,0,"to"));
        inputs.add(new Input(12,1,"be"));
        inputs.add(new Input(13,5,"question"));
        inputs.add(new Input(14,1,"or"));
        inputs.add(new Input(15,2,"not"));
        inputs.add(new Input(16,4,"is"));
        inputs.add(new Input(17,2,"to"));
        inputs.add(new Input(18,4,"the"));
        return inputs;
    }
}

