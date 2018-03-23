package g4g.stack;

public class Stack {

    public static void main(String[] args) {
        Stack ob = new Stack();
        ob.push(1);
        ob.push(3);
        ob.push(5);
        ob.push(7); // g4g.stack overflow
        System.out.println(ob.isEmptry());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop()); // underflow
    }

    private static final int MAX = 3;
    int[] A = new int[MAX];
    int top = -1;

    void push(int x) {
        if (top >= MAX-1) {
            System.out.println("g4g.stack overflow");
        } else {
            A[++top] = x;
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("g4g.stack underflow");
            return -1;
        }

        return A[top--];
    }

    boolean isEmptry() {
        return top < 0;
    }

}
