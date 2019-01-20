package geeksforgeeks.five.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/print-common-nodes-path-root-common-ancestors/
public class PrintCommonNodesOnPath {

    public static void main(String args[]) {
    /*Let us create Binary Tree shown in
        above example */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);

        if (findCommonNodes(root, 9, 7) == false)
            System.out.println("No Common nodes");

    }

    static boolean findCommonNodes(Node root, int a, int b) {
        int lca = findLCA(root, a, b);

        List<Integer> path = new ArrayList<>();
        findPath(root, lca, path);

        System.out.println(path);

        return path.size() > 0;
    }

    static boolean findPath(Node root, int n, List<Integer> path) {
        if (root == null) return false;

        path.add(root.key);
        if (root.key == n) return true;

        boolean l = findPath(root.left, n, path);
        boolean r = findPath(root.right, n, path);
        if (l || r) return true;

        path.remove(path.size() - 1);
        return false;
    }

    static int findLCA(Node root, int a, int b) {
        if (root == null) return -1;
        if (root.key == a || root.key == b) return root.key;

        int l = findLCA(root.left, a, b);
        int r = findLCA(root.right, a, b);

        if (l > 0 && r > 0) return root.key;

        return Math.max(l, r);
    }

}
