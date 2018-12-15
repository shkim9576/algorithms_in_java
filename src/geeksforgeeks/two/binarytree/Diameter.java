package geeksforgeeks.two.binarytree;

public class Diameter {

    Node root;
    public static void main(String[] args) {
        Diameter tree = new Diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : " + tree.getDiameter(tree.root));
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    int getDiameter(Node root) {
        if (root == null) return 0;

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return leftH + rightH + 1;
    }

    int getHeight(Node root) {
        if (root == null) return 0;

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return Math.max(leftH, rightH) + 1;
    }

}
