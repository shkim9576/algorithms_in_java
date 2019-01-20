package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/subtree-given-sum-binary-tree/
public class SubtreeGivenSum {

    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(4);
        root.left.left = new Node(9);
        root.left.right = new Node(7);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(12);
        root.left.right.right.right = new Node(2);
        root.right.right = new Node(11);
        root.right.right.left = new Node(3);
        int sum = 22;

        if (sumSubtree(root, sum))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static boolean found = false;

    static boolean sumSubtree(Node root, int sum) {
        sum(root, sum);
        return found;
    }

    static int sum(Node root, int sum) {
        if (root == null) return 0;

        int s = sum(root.left, sum) + sum(root.right, sum) + root.key;
        if (sum == s) found = true;

        return s;
    }
}
