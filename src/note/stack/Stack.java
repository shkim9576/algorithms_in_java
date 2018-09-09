package note.stack;

public class Stack<T> {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(7);

        System.out.println("peek: " + stack.peek()); // 7
        System.out.println("pop: " + stack.pop()); // 7
        System.out.println("pop: " + stack.pop()); // 3
        System.out.println("pop: " + stack.pop()); // 5
        System.out.println("isEmpty: " + stack.isEmpty()); // false
        System.out.println("pop: " + stack.pop()); // 1
        System.out.println("pop: " + stack.isEmpty()); // true
        System.out.println("pop: " + stack.pop()); // error
    }

    private StackNode<T> top;

    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);

        if (top != null) {
            node.next = top;
        }

        top = node;
    }

    public T peek() {
        if (top == null) {
            System.out.println("EmptyStackException");
            return null;
        } else {
            return top.data;
        }
    }

    public T pop() {
        T data;

        if (top == null) {
            System.out.println("EmptyStackException");
            return null;
        } else {
            data = top.data;
            top = top.next;
        }

        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
