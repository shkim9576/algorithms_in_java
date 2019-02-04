package ctci.first.stackqueue;

public class ThreeInOne {

    private static final int NUM_STACK = 3;
    private static final int STACK_SIZE = 3;

    int[] pool = new int[NUM_STACK * STACK_SIZE];
    int[] tops = new int[NUM_STACK];

    public static void main(String[] args) {
        ThreeInOne ob = new ThreeInOne();
        ob.push(10, 0);
        ob.push(11, 0);
        ob.push(12, 0);
        ob.push(13, 0);
        System.out.println("pop: " + ob.pop(0));
        System.out.println("peek: " + ob.peek(0));

        ob.push(100, 1);
        System.out.println(ob.pop(1));
        System.out.println(ob.pop(1));
    }

    void push(int v, int s) {
        if (tops[s] >= STACK_SIZE) {
            System.out.println("overflow");
        } else {
            pool[tops[s] + s*STACK_SIZE] = v;
            tops[s]++;
        }
    }

    int pop(int s) {
        if (tops[s] <= 0) {
            System.out.println("underflow");
            return -1;
        } else {
            int v = pool[tops[s] + s*STACK_SIZE-1];
            tops[s]--;
            return v;
        }
    }

    int peek(int s) {
        return pool[tops[s] + s*STACK_SIZE-1];
    }

}
