package geeksforgeeks.five.stack;

//https://leetcode.com/problems/backspace-string-compare
public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare o = new BackspaceStringCompare();
        System.out.println(o.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    String build(String S) {
        if (S == null || S.length() == 0) return S;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (sb.length() > 0 && c == '#') sb.deleteCharAt(sb.length() - 1);
            else if (c != '#') sb.append(c);
        }
        return sb.toString();
    }
}
