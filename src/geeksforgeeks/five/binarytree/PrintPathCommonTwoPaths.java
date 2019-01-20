package geeksforgeeks.five.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/print-path-common-two-paths-root-two-given-nodes/
public class PrintPathCommonTwoPaths {

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right.left.right = new Node(9);

        int n1 = 4, n2 = 8;
        printCommonPath(root, n1, n2);
    }

    static void printCommonPath(Node root, int a, int b) {
        int lca = findLCA(root, a, b);
        List<Integer> list = new ArrayList<>();
        printPath(root, lca, list);
        System.out.println(list);
    }

    static int findLCA(Node root, int a, int b) {
        if (root == null) return -1;
        if (root.key == a || root.key == b) return root.key;

        int l = findLCA(root.left, a, b);
        int r = findLCA(root.right, a, b);

        if (l > 0 && r > 0) return root.key;

        return Math.max(l, r);
    }

    static boolean printPath(Node root, int lca, List<Integer> path) {
        if (root == null) return false;

        path.add(root.key);
        if (root.key == lca) return true;

        boolean l = printPath(root.left, lca, path);
        boolean r = printPath(root.right, lca, path);

        if (l || r) return true;

        path.remove(path.size() - 1);
        return false;
    }
}
