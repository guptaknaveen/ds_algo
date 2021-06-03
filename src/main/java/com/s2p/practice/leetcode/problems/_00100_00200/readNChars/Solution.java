package com.s2p.practice.leetcode.problems._00100_00200.readNChars;

/**
 * /problems/read-n-characters-given-read4/
 * 157. Read N Characters Given Read4
 */
public class Solution {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int totalCharRead = 0;

        int currentRead = 0;


        char tempBuf[] = new char[4];
        int  i=0;


        while (true) {
            // read from the parent class is called which is provided in the leetcode
            // TODO : uncomment following to submit the code
            // currentRead = read4(tempBuf);

            for (i=0;i<currentRead;i++) {
                buf[i+totalCharRead]=tempBuf[i];
            }
            totalCharRead+=currentRead;

            if (currentRead < 4) {
                break;
            }
        }

        return totalCharRead > n ? n : totalCharRead;

    }
}
