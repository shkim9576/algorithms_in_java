package geeksforgeeks.two.bst;

public class KthLargestElement {

    Node root;
    public static void main(String[] args) {
         /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        KthLargestElement tree = new KthLargestElement();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right = new Node(70);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        for (int i = 1; i <= 7; i++) {
            int res = tree.kthLargest(tree.root, i);
            System.out.println(res);
        }
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    static class IntWrapper {
        int index;
        int data;

        IntWrapper(int ind) {
            index = ind;
        }
    }

    int kthLargest(Node root, int k) {
        IntWrapper iw = new IntWrapper(k);
        inorder(root, iw);
        return iw.data;
    }

    void inorder(Node root, IntWrapper iw) {
        if (root != null) {
            inorder(root.right, iw);
            iw.index--;
            if (iw.index == 0) {
                iw.data = root.data;
                return;
            }
            inorder(root.left, iw);
        }
    }
}
