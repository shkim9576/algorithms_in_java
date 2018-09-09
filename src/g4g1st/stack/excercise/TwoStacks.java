package g4g1st.stack.excercise;

public class TwoStacks {
    // https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/

    public static void main(String[] args) {
        TwoStacks ts = new TwoStacks();
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack2 is " + ts.pop2());
        ts.push1(1);
        ts.push1(2);
        System.out.println(ts.pop2());
        System.out.println(ts.pop2());
        System.out.println(ts.pop2());
        System.out.println(ts.pop2());
    }

    int A[] = new int[5];
    int top1 = -1;
    int top2 = A.length;

    void push1(int data) {
        if (top1 + 1 == top2) {
            System.out.println("g4g1st.stack 1 overflow");
        } else {
            A[++top1] = data;
        }
    }

    void push2(int data) {
        if (top2 - 1 == top1) {
            System.out.println("g4g1st.stack 2 overflow");
        } else {
            A[--top2] = data;
        }
    }

    int pop1() {
        if (top1 < 0) {
            System.out.println("g4g1st.stack 1 underflow");
            return -1;
        } else {
            return A[top1--];
        }
    }

    int pop2() {
        if (top2 > A.length - 1) {
            System.out.println("g4g1st.stack 2 underflow");
            return -1;
        } else {
            return A[top2++];
        }
    }

}
