package g4g2nd.binarytree;

public class PrintAncestors {

    Node root;
    public static void main(String[] args) {
        PrintAncestors tree = new PrintAncestors();

        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        // 4 2 1
        tree.printAncestors(tree.root, 7);
    }

    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
        }
    }

    boolean printAncestors(Node root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;

        if (printAncestors(root.left, target) || printAncestors(root.right, target)) {
            System.out.print(root.data + " ");
            return true;
        }

        return false;
    }

}
