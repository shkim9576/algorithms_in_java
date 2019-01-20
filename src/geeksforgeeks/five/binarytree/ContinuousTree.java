package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/continuous-tree/
public class ContinuousTree {

    public static void main(String args[]) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(5);
        if (treeContinuous(root))
            System.out.println("Yes");
        else
            System.out.println("No");

        root = new Node(7);
        root.left = new Node(5);
        root.right = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(4);
        root.right.right = new Node(10);
        if (treeContinuous(root))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static boolean treeContinuous(Node root) {
        if (root == null) return true;
        if (root.left != null && Math.abs(root.key - root.left.key) != 1) return false;
        if (root.right != null && Math.abs(root.key - root.right.key) != 1) return false;

        return treeContinuous(root.left) && treeContinuous(root.right);
    }
}
