package geeksforgeeks.six.stack;

import java.util.Stack;

public class EvaluatePostfix {

    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println("postfix evaluation: " + evaluatePostfix(exp));

        String exp2 = "100 200 + 2 / 5 * 7 +";
        System.out.println("postfix evaluation: " + evaluatePostfix2(exp2));
    }

    static int evaluatePostfix2(String s) {
        String[] splits = s.split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String op : splits) {
            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                int v1 = stack.pop();
                int v2 = stack.pop();

                switch (op) {
                    case "+":
                        stack.push(v2 + v1);
                        break;
                    case "-":
                        stack.push(v2 - v1);
                        break;
                    case "*":
                        stack.push(v2 * v1);
                        break;
                    case "/":
                        stack.push(v2 / v1);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        return stack.pop();
    }

    static int evaluatePostfix(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int v1 = stack.pop();
                int v2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(v2 + v1);
                        break;
                    case '-':
                        stack.push(v2 - v1);
                        break;
                    case '*':
                        stack.push(v2 * v1);
                        break;
                    case '/':
                        stack.push(v2 / v1);
                        break;
                }
            }
        }

        return stack.pop();
    }
}
