package geeksforgeeks.two.binarytree;

public class CountLeaf {

    Node root;
    public static void main(String[] args) {
        CountLeaf tree = new CountLeaf();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* get leaf count of the abve tree */
        System.out.println("The leaf count of binary tree is : "
                           + tree.countLeaf(tree.root));

    }

    static class Node{
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    int countLeaf(Node root) {
        if (root == null) return 0;
        if (isLeaf(root)) return 1;

        return countLeaf(root.left) + countLeaf(root.right);
    }

    boolean isLeaf(Node root) {
        return root != null && root.left == null && root.right == null;
    }
}
