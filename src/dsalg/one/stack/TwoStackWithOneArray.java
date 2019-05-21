package dsalg.one.stack;

public class TwoStackWithOneArray {

    public static void main(String[] args) {
        TwoStackWithOneArray o = new TwoStackWithOneArray();
        o.push(0, 10);
        o.push(0, 20);
        o.push(0, 30);
        o.push(0, 40);
        o.push(0, 50);
        o.push(0, 60);
        o.push(1, 100);
        o.push(1, 200);
        o.push(1, 300);
        o.push(1, 400);
        o.push(1, 500);

        System.out.println(o.top(0));
        System.out.println(o.top(0));
        System.out.println(o.top(0));
        System.out.println(o.top(0));
        System.out.println(o.top(0));
        System.out.println(o.top(0));
        System.out.println(o.top(0));
        System.out.println(o.top(1));
        System.out.println(o.top(1));
        System.out.println(o.top(1));
        System.out.println(o.top(1));
        System.out.println(o.top(1));
        System.out.println(o.top(1));
    }

    int N = 10;
    int[] mem = new int[N];
    int topA = -1, topB = N;

    void push(int id, int data) {
        if (topA >= topB) {
            System.out.println("StackOverflowException");
            return;
        }

        if (id == 0) {
            mem[++topA] = data;
        } else if (id == 1) {
            mem[--topB] = data;
        }
    }

    int top(int id) {
        if (id == 0) {
            if (topA < 0) {
                System.out.println("StackUnderflowException");
                return -1;
            }
            int d = mem[topA--];
            return d;
        }
        if (id == 1) {
            if (topB >= N) {
                System.out.println("StackUnderflowException");
                return -1;
            }
            int d = mem[topB++];
            return d;
        }

        System.out.println("IllegalArgumentException");
        return -1;
    }

}
