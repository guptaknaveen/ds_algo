package com.s2p.practice.leetcode.problems._00100_00200.readNCharsII;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4/
 * 157. Read N Characters Given Read4
 */
public class Solution {
    private String data;

    private  int dataSize;

    private int currentPointer = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (data == null) {
            data = readData();
            dataSize = data.length();
        }

        if (currentPointer > data.length()) {
            return 0;
        }

        int startIndex = currentPointer;
        int endIndex = currentPointer + n;

        if (endIndex > dataSize) {
            endIndex = dataSize;
        }

        String readData = data.substring(startIndex, endIndex);
        int readSize = readData.length();

        int i = 0;
        for (;i<readSize;i++) {
            buf[i] = readData.charAt(i);
        }

        currentPointer = currentPointer + n;

        return readSize;

    }

    private String readData() {
        StringBuilder dataBuilder = new StringBuilder();

        int currentRead = 0;

        char tempBuf[] = new char[4];

        int  i;

        while (true) {
            // read from the parent class is called which is provided in the leetcode
            // TODO : uncomment following to submit the code
            // currentRead = read4(tempBuf);

            for (i=0;i<currentRead;i++) {
                dataBuilder.append(tempBuf[i]);
            }

            if (currentRead < 4) {
                break;
            }
        }

        return dataBuilder.toString();
    }
}
