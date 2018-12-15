package geeksforgeeks.two.binarytree;

public class DeleteTree {

    Node root;
    public static void main(String[] args) {
        DeleteTree tree = new DeleteTree();

        /*
         Deleting node: 4
         Deleting node: 5
         Deleting node: 2
         Deleting node: 3
         Deleting node: 1
         Tree deleted
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* Print all root-to-leaf paths of the input tree */
        tree.deleteTree(tree.root);
        tree.root = null;
        System.out.println("Tree deleted");
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    void deleteTree(Node root) {
        if (root != null) {
            deleteTree(root.left);
            deleteTree(root.right);
            System.out.print(root.data + " ");
            root = null;
        }
    }

}
