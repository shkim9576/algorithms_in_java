package dsalg.one.stack;

import java.util.Stack;

public class Postfix {

    public static void main(String[] args) {
        Postfix o = new Postfix();
        System.out.println(o.postfix("123*+5-"));
    }

    int postfix(String s) {
        if (s == null) return 0; // return error

        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int v1 = stack.pop();
                int v2 = stack.pop();

                if (c == '+') {
                    stack.push(v1 + v2);
                } else if (c == '-') {
                    stack.push(v2 - v1);
                } else if (c == '*') {
                    stack.push(v1 * v2);
                } else if (c == '/') {
                    stack.push(v2 / v1);
                }
            }
        }

        return stack.pop();
    }
}
