package leetcode.one.easy;

import ctci.array.StringCompress;

//https://leetcode.com/problems/string-compression/submissions/
public class StringCompression {

    public static void main(String[] args) {
        StringCompression o = new StringCompression();
        System.out.println(o.compress(new String("aabbccc").toCharArray())); //6 - a2b2c3
    }

    public int compress(char[] chars) {

        int ri = 0, wi = 0;

        while (ri < chars.length) {
            int count = 0;
            char curr = chars[ri];
            while (ri < chars.length && curr == chars[ri]) {
                count++;
                ri++;
            }

            chars[wi++] = curr;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[wi++] = c;
                }
            }
        }

        return wi;
    }
}
