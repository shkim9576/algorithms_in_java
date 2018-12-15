package geeksforgeeks.two.binarytree;

public class TreeSize {

    Node root;
    public static void main(String[] args) {
        TreeSize tree = new TreeSize();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // 5
        System.out.println("The size of binary tree is : " + tree.countSize(tree.root));

    }

    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
        }
    }

    int countSize(Node root) {
        if (root == null) return 0;
        return countSize(root.left) + countSize(root.right) + 1;
    }

}
