package g4g2nd.binarytree;

public class PrintMaxSumLeafToRoot {

    Node root;
    public static void main(String[] args) {
        PrintMaxSumLeafToRoot tree = new PrintMaxSumLeafToRoot();
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        System.out.println("Following are the nodes "+
                           "on maximum sum path");
        int sum = tree.maxSumPath(tree.root);
        System.out.println("");
        System.out.println("Sum of nodes is : " + sum);
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    static class MaxNode {
        int maxData;
        Node maxNode;
        MaxNode() {}
        MaxNode(Node node, int data) {
            maxData = data;
            maxNode = node;
        }
    }

    int maxSumPath (Node root) {
        MaxNode maxLeafNode = findMaxLeafNode(root);
        printPathFromLeafToTop(root, maxLeafNode.maxNode);
        return maxLeafNode.maxData;
    }

    boolean printPathFromLeafToTop(Node root, Node target) {
        if (root == null || target == null) return false;

        if (root == target) {
            System.out.print(root.data + " ");
            return true;
        }

        if (printPathFromLeafToTop(root.left, target)) {
            System.out.print(root.data + " ");
            return true;
        }
        if (printPathFromLeafToTop(root.right, target)) {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }

    MaxNode findMaxLeafNode(Node root) {
        if (root == null) return null;

        MaxNode res = new MaxNode();
        helper(root, res, 0);
        return res;
    }

    void helper(Node root, MaxNode res, int sum) {

        if (root == null) return;
        sum += root.data;

        if (root.left == null && root.right == null) {
            if (sum > res.maxData) {
                res.maxData = sum;
                res.maxNode = root;
            }
        }

        helper(root.left, res, sum);
        helper(root.right, res, sum);
    }

}
