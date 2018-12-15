package geeksforgeeks.two.binarytree;

public class AllCommonAncestors {

    Node root;
    public static void main(String[] args) {
        AllCommonAncestors tree = new AllCommonAncestors();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.right.left.left = new Node(9);
        tree.root.right.left.right = new Node(10);

        AllCommonAncestors ob = new AllCommonAncestors();
        // 3 1
        ob.allCommonAncestors(tree.root, 9, 7);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    void allCommonAncestors(Node root, int n1, int n2) {
        Node lca = findLCA(root, n1, n2);
        printCommonAncestors(root, lca);
    }

    boolean printCommonAncestors(Node root, Node lca) {
        if (root == null || lca == null) return false;

        if (root.data == lca.data) {
            System.out.print(root.data + " ");
            return true;
        }
        if (printCommonAncestors(root.left, lca) || printCommonAncestors(root.right, lca)) {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }

    Node findLCA(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;

        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if (left != null && right != null) return root;
        return (left == null) ? right : left;
    }

}
