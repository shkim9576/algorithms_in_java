package leetcode.one.easy;

import java.util.Stack;

//https://leetcode.com/problems/backspace-string-compare/
public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare o = new BackspaceStringCompare();
        System.out.println(o.backspaceCompare("ab#c", "ad#c")); //true
    }

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') stack.push(c);
            else if (!stack.isEmpty()) stack.pop();
        }
        return String.valueOf(stack);
    }
}
