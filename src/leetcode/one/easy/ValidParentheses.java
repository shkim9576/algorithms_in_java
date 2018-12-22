package leetcode.one.easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        ValidParentheses o = new ValidParentheses();
        System.out.println(o.isValid("[]{}(())[()]")); //true
        System.out.println(o.isValid("{{)}}")); //false
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}
