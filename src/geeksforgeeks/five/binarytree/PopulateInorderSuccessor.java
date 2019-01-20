package geeksforgeeks.five.binarytree;

public class PopulateInorderSuccessor {

    public static void main(String args[]) {
        /* Constructed binary tree is
            10
           /   \
          8      12
         /
        3    */
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);

        // Populates nextRight pointer in all nodes
        populateNext(root, null);

        // Let us see the populated values
        Node ptr = root.left.left;
        while (ptr != null) {
            // -1 is printed if there is no successor
            int print = ptr.next != null ? ptr.next.key : -1;
            System.out.println("Next of " + ptr.key + " is: " + print);
            ptr = ptr.next;
        }
    }

    static void populateNext(Node root, Node next) {
        if (root != null) {
            populateNext(root.right, next);
            root.next = next;
            next = root;
            populateNext(root.left, next);
        }
    }

    static class Node {
        int key;
        Node left, right, next;

        Node(int k) {
            this.key = k;
        }
    }
}
