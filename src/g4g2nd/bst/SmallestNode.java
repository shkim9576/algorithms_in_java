package g4g2nd.bst;

public class SmallestNode {

    public static void main(String[] args) {
        SmallestNode tree = new SmallestNode();
        Node root = null;
        root = tree.insert(root, 4);
        tree.insert(root, 2);
        tree.insert(root, 10);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 5);

        System.out.println("The minimum value of BST is " + tree.minvalue(root));
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    Node insert(Node node, int data) {

        /* 1. If the tree is empty, return a new,
         single node */
        if (node == null) {
            return (new Node(data));
        } else {

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }

    int minvalue(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null) return root.data;

        return minvalue(root.left);
    }
}
