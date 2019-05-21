package geeksforgeeks.six.stack;

import java.util.Stack;

public class Celebrity {

    public static void main(String[] args) {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1) {
            System.out.println("No Celebrity");
        } else
            System.out.println("Celebrity ID " +
                    result);
    }

    static int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int celebrity = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))) return -1;
        }

        return celebrity;
    }

    // Person with 2 is celebrity
    static int MATRIX[][] = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    // Returns true if a knows
    // b, false otherwise
    static boolean knows(int a, int b) {
        return (MATRIX[a][b] == 1);
    }
}
