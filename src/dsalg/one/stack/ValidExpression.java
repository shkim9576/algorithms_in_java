package dsalg.one.stack;

import java.util.Stack;

public class ValidExpression {

    public static void main(String[] args) {
        ValidExpression o = new ValidExpression();
        System.out.println(o.validExpression("(A+B)+(C+D)"));
        System.out.println(o.validExpression("((A+B)+(C-D)"));
        System.out.println(o.validExpression("((A+B)+[C+D])"));
        System.out.println(o.validExpression("((A+B)+[C+D]}"));
    }

    boolean validExpression(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == ']' || c == '}' || c == ')') {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
