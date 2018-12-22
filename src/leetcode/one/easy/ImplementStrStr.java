package leetcode.one.easy;

//https://leetcode.com/problems/implement-strstr/
public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr o = new ImplementStrStr();
        System.out.println(o.strStr("hello", "ll")); //2
        System.out.println(o.strStr("aaaaa", "bba")); //-1
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
