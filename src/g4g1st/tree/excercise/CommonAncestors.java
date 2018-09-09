package g4g1st.tree.excercise;

import java.util.ArrayList;
import java.util.List;

public class CommonAncestors {
    // https://www.geeksforgeeks.org/print-common-nodes-path-root-common-ancestors/

    public static void main(String[] args) {
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

        CommonAncestors ob = new CommonAncestors();
        List<Node> result = ob.findCommonNodes(root, new Node(9), new Node(7));  // 3, 1
        for (Node n : result) System.out.println(n.data);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    List<Node> findCommonNodes(Node root, Node n1, Node n2) {
        List<Node> result = new ArrayList<>();
        if (root == null || n1 == null || n2 == null) return result;

        Node lca = findLCA(root, n1, n2);
        findCommons(root, lca, result);
        return result;
    }

    boolean findCommons(Node root, Node lca, List<Node> result) {
        if (root == null || lca == null) return false;

        if (root.data == lca.data || findCommons(root.left, lca, result) || findCommons(root.right, lca, result)) {
            result.add(root);
            return true;
        }

        return false;
    }

    Node findLCA(Node root, Node n1, Node n2) {
        if (root == null || n1 == null || n2 == null) return null;

        if (root.data == n1.data || root.data == n2.data) return root;
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if (left != null && right != null) return root;

        return left == null ? right : left;
    }

}
