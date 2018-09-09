package g4g1st.tree.excercise;

public class LCA {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        LCA ob = new LCA();
        System.out.println(ob.LCA(root, new Node(4), new Node(5)).data); // 2
        System.out.println(ob.LCA(root, new Node(4), new Node(6)).data); // 1
        System.out.println(ob.LCA(root, new Node(3), new Node(4)).data); // 1
        System.out.println(ob.LCA(root, new Node(2), new Node(4)).data); // 2
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }

    Node LCA(Node root, Node n1, Node n2) {
        if (root == null || n1 == null || n2 == null) return null;

        if (root.data == n1.data || root.data == n2.data) return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null) return root;

        return left == null ? right : left;
    }

}
