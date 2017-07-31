package com.creaty.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility) <br\>
 * P   A   H   N<br\>
 * A P L S I I G<br\>
 * Y   I   R<br\>
 * <p\>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p\>
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);<br\>
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". <br\>
 * Created by hyx on 2015/11/9.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("ABCDEFGHIJKLMN", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        char[] charArray = s.toCharArray();
        int len = s.length();
        StringBuilder result = new StringBuilder();
        int topStep = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i, interval = i * 2; j < len; j += interval) {
                interval = interval == 0 ? interval : topStep - interval;
                result.append(charArray[j]);
            }
            //System.out.println("i: " + i + " " + sb.toString());
        }
        return result.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows < 2)
            return s;
        StringBuffer sb = new StringBuffer(s.length());
        int group = 2 * numRows - 2;
        //int groupnum = s.length()/group;
        int k = 0;
        for (int i = 0; i < s.length(); i += (2 * numRows - 2)) {
            sb.setCharAt(0, s.charAt(k));
            k++;
            sb.setCharAt(group + 1, s.charAt(k));
            k++;
            sb.setCharAt(group * 3, s.charAt(k));
            k++;
            sb.setCharAt(group * 5, s.charAt(k));
            k++;
            sb.setCharAt(group * 4, s.charAt(k));
            k++;
            sb.setCharAt(group * 2, s.charAt(k));
            k++;
        }
        return sb.toString();
    }

    public String convert3(String s, int numRows) {
        char[] c = s.toCharArray();
        int nRows = numRows;
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
