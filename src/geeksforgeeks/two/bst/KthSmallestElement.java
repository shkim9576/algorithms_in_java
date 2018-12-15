package geeksforgeeks.two.bst;

public class KthSmallestElement {

    Node root;
    public static void main(String[] args) {
        KthSmallestElement tree = new KthSmallestElement();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        KthSmallestElement ob = new KthSmallestElement();
        ob.kthElement(tree.root, 5);
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    static class IntWrapper {
        int data;
        IntWrapper(int d) {
            data = d;
        }
    }

    void kthElement(Node root, int k) {
        inorder(root, new IntWrapper(k));
    }

    void inorder(Node root, IntWrapper iw) {
        if (root != null) {
            inorder(root.left, iw);
            iw.data--;
            if (iw.data == 0) {
                System.out.println(root.data);
            }
            inorder(root.right, iw);
        }
    }
}
