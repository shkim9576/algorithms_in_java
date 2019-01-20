package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/foldable-binary-trees/
public class FoldableBinaryTree {

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.right = new Node(5);

        if (isFoldable2(root))
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.left = new Node(5);

        if (isFoldable2(root))
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");
    }

    static boolean isFoldable2(Node root) {
        if (root == null) return true;
        return isFoldable2(root.left, root.right);
    }

    static boolean isFoldable2(Node n1, Node n2) {
        if (n1 == null || n2 == null) return n1 == n2;
        return isFoldable2(n1.left, n2.right) && isFoldable2(n1.right, n2.left);
    }

    static boolean isFoldable(Node root) {
        if (root == null) return true;

        boolean result;

        mirror(root.left);
        result = isSameStructure(root.left, root.right);
        mirror(root.left);

        return result;
    }

    static void mirror(Node root) {
        if (root != null) {
            mirror(root.left);
            mirror(root.right);

            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    static boolean isSameStructure(Node n1, Node n2) {
        if (n1 == null || n2 == null) return n1 == n2;
        return isSameStructure(n1.left, n2.left) && isSameStructure(n1.right, n2.right);
    }
}
