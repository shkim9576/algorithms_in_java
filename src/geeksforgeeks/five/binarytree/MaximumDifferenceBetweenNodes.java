package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
public class MaximumDifferenceBetweenNodes {

    //Maximum difference between a node and its ancestor is : 7
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        System.out.println("Maximum difference between a node and"
                + " its ancestor is : " + maxDiff(root));
    }

    static class Res {
        int res;
    }

    static int maxDiff(Node root) {
        Res result = new Res();
        maxDiff(root, result);
        return result.res;
    }

    static int maxDiff(Node root, Res result) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return root.key;

        int min = Math.min(maxDiff(root.left, result), maxDiff(root.right, result));
        result.res = Math.max(result.res, root.key - min);

        return Math.min(root.key, min);
    }
}
