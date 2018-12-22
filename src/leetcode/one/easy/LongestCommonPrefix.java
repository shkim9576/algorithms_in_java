package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix o = new LongestCommonPrefix();

        String[] in = {"flower","f","flow","flight"};
        System.out.println(o.longestCommonPrefix(in));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pre = strs[0];
        for(int i=1; i<strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);

                if(pre.length() == 0) return "";
            }
        }

        return pre;
    }
}
