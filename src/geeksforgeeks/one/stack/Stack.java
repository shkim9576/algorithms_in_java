package geeksforgeeks.one.stack;

public class Stack {

    public static void main(String[] args) {
        Stack ob = new Stack();
        ob.push(1);
        ob.push(3);
        ob.push(5);
        ob.push(7); // geeksforgeeks.g4g1st.one.stack overflow
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
            System.out.println("geeksforgeeks.g4g1st.one.stack overflow");
        } else {
            A[++top] = x;
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("geeksforgeeks.g4g1st.one.stack underflow");
            return -1;
        }

        return A[top--];
    }

    boolean isEmptry() {
        return top < 0;
    }

}
