package com.s2p.practice.interview.facebook;

// https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=229890198389794

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class QueueRemovals {

    // Add any helper functions you may need here
    class Node {
        int data;
        int index;

        public Node(int data, int index) {
            this.data = data;
            this.index = index;
        }

        @Override
        public String toString() {
            return "\nNode{" +
                    "data=" + data +
                    ", index=" + index +
                    '}';
        }
    }

    private int performAction(Queue<Node> queue, int x) {
        int result = -1;

        int max = Integer.MIN_VALUE;

        int i = 0;
        Node front;

        List<Node> popped = new ArrayList<>();

        for (; i<x; i++) {
            front = queue.poll();

            if (front == null) {
                continue;
            }

            if (front.data > max) {
                result = front.index;
                max = front.data;
            }

            popped.add(front);
        }

        if (result > -1) {

            for (Node node : popped) {
                if (node.index == result) {
                    continue;
                }
                if (node.data > 0) {
                    node.data--;
                }
                queue.add(node);
            }

        }

        System.out.println("Q -> " + queue);

        return result;
    }


    int[] findPositions(int[] arr, int x) {
        // Write your code here
        Queue<Node> queue = new ArrayDeque<>(x * x);

        int[] positions = new int[x];

        int i = 0;
        for (; i<arr.length; i++) {
            queue.add(new Node(arr[i], i+1));
        }

        for (i=0; i<x; i++) {
            positions[i] = performAction(queue, x);
        }

        return positions;
    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        check(expected_1, output_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new QueueRemovals().run();
    }
}