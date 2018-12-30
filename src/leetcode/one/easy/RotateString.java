package leetcode.one.easy;

//https://leetcode.com/problems/rotate-string/
public class RotateString {

    public static void main(String[] args) {
        RotateString o = new RotateString();
        System.out.println(o.rotateString("abcde", "cdeab")); //true
    }

    public boolean rotateString(String A, String B) {
        return (A.length() == B.length()) && (A + A).indexOf(B) != -1;
    }
}
