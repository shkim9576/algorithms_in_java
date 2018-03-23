package ctci.treegraph;

public class Successor {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        Successor ob = new Successor();
        System.out.println(ob.successor(root.left)); // 5
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    // find next node in BST = inorder
    Node successor(Node n) {
        if (n == null) return null;
        if (n.right != null) {
            return leftMost(n.right);
        } else {
            Node q = n;
            Node x = q.parent;
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    Node leftMost(Node n) {
        if (n == null) return null;
        while (n.left != null) n = n.left;
        return n;
    }

}
