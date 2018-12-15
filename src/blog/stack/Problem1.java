package blog.stack;

import java.util.HashMap;

public class Problem1 {

    public static void main(String[] args) {
        Problem1 p = new Problem1();
        System.out.println(p.isValidParentheses("[]{}()"));
        System.out.println(p.isValidParentheses("{{[()]}()[]}"));
        System.out.println(p.isValidParentheses("[]{"));
    }

    boolean isValidParentheses(String S) {
        if (S == null) {
            throw new IllegalArgumentException("input string cannot be null.");
        }

        HashMap<Character, Character> map = new HashMap<>(3);
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (map.containsValue(c)) { // open
                stack.push(c);
            } else if (map.containsKey(c)) { // close
                if(stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException("input string should only contains []{}()");
            }
        }

        return stack.isEmpty();
    }
}
