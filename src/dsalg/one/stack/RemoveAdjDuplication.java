package dsalg.one.stack;

import java.util.Stack;

public class RemoveAdjDuplication {

    public static void main(String[] args) {
        RemoveAdjDuplication o = new RemoveAdjDuplication();
        System.out.println(o.removeAdjDuplication("mississippi"));
        System.out.println(o.removeAdjDuplication("careermonk"));
    }

    String removeAdjDuplication(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.toString();
    }
}
