package geeksforgeeks.five.binarysearchtree;

//https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
public class CheckBST {

    //IS BST
    public static void main(String args[]) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        if (isBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    static boolean isBST(Node root) {
        if (root == null) return true;
        if (root.left != null && root.left.data > root.data ||
                root.right != null && root.right.data < root.data) return false;

        return isBST(root.left) && isBST(root.right);
    }
}
