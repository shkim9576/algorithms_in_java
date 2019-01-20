package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
public class SymmetricTree {

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.println(isSymmetric(root));
    }

    static boolean isSymmetric(Node root) {
        return isSymmetric(root, root);
    }

    static boolean isSymmetric(Node n1, Node n2) {
        if (n1 == null || n2 == null) return n2 == n2;
        return (n1.key == n2.key) && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }
}
