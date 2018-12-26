package leetcode.one.easy;

//https://leetcode.com/problems/reverse-string/
public class ReverseString {

    public static void main(String[] args) {
        ReverseString o = new ReverseString();
        System.out.println(o.reverseString("hello")); //olleh
    }

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }

        return new String(chars);
    }
}
