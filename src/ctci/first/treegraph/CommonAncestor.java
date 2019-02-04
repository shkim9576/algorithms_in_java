package ctci.first.treegraph;

public class CommonAncestor {
    public static void main(String[] args) {
        Node ca = new Node(2);
        Node n1 = new Node(4);
        Node n2 = new Node(5);
        Node root = new Node(1);
        root.left = ca;
        root.right = new Node(3);
        root.left.left = n1;
        root.left.right = n2;
        root.right.left = new Node(6);

        CommonAncestor ob = new CommonAncestor();
        System.out.println(ob.commonAncestor(root, n1, n2));
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    Node commonAncestor(Node root, Node n1, Node n2) {
        if (root == null) return null;
        if (root == n1) return n1;
        if (root == n2) return n2;

        boolean n1Left = find(root.left, n1);
        boolean n1Right = find(root.right, n1);
        boolean n2Left = find(root.left, n2);
        boolean n2Right = find(root.right, n2);

        if (n1Left && n2Right) return root;
        if (n1Right && n2Left) return root;

        if(n1Left && n2Left) return commonAncestor(root.left, n1, n2);
        return commonAncestor(root.right, n1, n2);
    }

    boolean find(Node root, Node target) {
        if (root == null) return false;
        if (root == target) return true;
        return find(root.left, target) || find(root.right, target);
    }

}
