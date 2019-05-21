package geeksforgeeks.six.stack;

public class MiddleOperation {

    public static void main(String args[]) {
        MiddleStack ob = new MiddleStack();
        ob.push(11);
        ob.push(22);
        ob.push(33);
        ob.push(44);
        ob.push(55);
        ob.push(66);
        ob.push(77);

        System.out.println("Item popped is " + ob.pop().data);
        System.out.println("Item popped is " + ob.pop().data);
        System.out.println("Middle Element is " + ob.findMiddle().data);
    }

    static class MiddleStack {
        int MAX = 10;
        Node top = null, middle = null;
        int size = 0;

        void push(int d) {
            if (size == MAX) {
                System.out.println("Stack overflow");
                return;
            }

            Node nn = new Node(d);
            if (top != null) {
                nn.prev = top;
                top.next = nn;
            }
            top = nn;
            size++;

            if (size == 1) {
                middle = nn;
            } else if (size > 1 && size % 2 == 1) {
                middle = middle.next;
            }
        }

        Node pop() {
            if (size == 0) {
                System.out.println("Stack underflow");
                return null;
            }
            Node temp = top;
            top = top.prev;

            size--;
            if (middle != null && size % 2 == 0) {
                middle = middle.prev;
            }

            return temp;
        }

        Node findMiddle() {
            return middle;
        }

        static class Node {
            Node prev;
            Node next;
            int data;

            Node(int d) {
                this.data = d;
            }
        }

    }


}
