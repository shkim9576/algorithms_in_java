package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/density-of-binary-tree-in-one-traversal/
public class DensityOfBinaryTree {

    //Density of given binary tree is 1.5
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        System.out.println("Density of given Binary Tree is : "
                + tree.density(tree.root));
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Size {
        int size = 0;
    }

    static class BinaryTree {
        Node root;

        int heighAndSize(Node node, Size size) {
            if (node == null) return 0;

            int l = heighAndSize(node.left, size);
            size.size++;
            int r = heighAndSize(node.right, size);

            return Math.max(l, r) + 1;
        }

        //function to calculate density of a binary tree
        float density(Node root) {
            Size size = new Size();
            int height = heighAndSize(root, size);
            return (float) size.size / height;
        }
    }
}
