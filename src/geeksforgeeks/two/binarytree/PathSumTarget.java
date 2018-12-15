package geeksforgeeks.two.binarytree;

public class PathSumTarget {

    Node root;
    public static void main(String[] args) {
        int sum = 21;

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        PathSumTarget tree = new PathSumTarget();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        if (tree.pathSumTarget(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }

    static class Node {
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
        }
    }

    boolean pathSumTarget(Node root, int target) {

        if (root == null) {
            return target == 0;
        } else {
            int sub = target - root.data;
            if (sub == 0 && root.left == null && root.right == null) return true;

            return pathSumTarget(root.left, sub) || pathSumTarget(root.right, sub);
        }

    }
}
