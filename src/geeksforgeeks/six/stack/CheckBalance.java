package geeksforgeeks.six.stack;

import java.util.Stack;

public class CheckBalance {

    public static void main(String[] args) {
        char exp[] = {'{', '(', ')', '}', '[', ']'};
        if (checkBalanced(exp))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

    static boolean checkBalanced(char[] exp) {
        Stack<Character> stack = new Stack<>();

        for (char c : exp) {
            if (c == '{') stack.push('}');
            else if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (!stack.isEmpty() && stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}
