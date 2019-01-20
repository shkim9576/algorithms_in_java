package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/sum-nodes-maximum-depth-binary-tree/
public class SumNodesMaxDepth {

    // 22
    public static void main(String[] args) {

        /*     1
              / \
             2   3
            / \ / \
            4 5 6 7     */

        // Constructing tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        // call to calculate required sum
        System.out.println(sumMaxLevel(root));
    }

    static int sumMaxLevel(Node root) {
        int depth = getMaxDepth(root);
        return sum(root, depth);
    }

    static int sum(Node root, int d) {
        if (root == null) return 0;
        if (d == 1) return root.key;
        return sum(root.left, d - 1) + sum(root.right, d - 1);
    }

    static int getMaxDepth(Node root) {
        if (root == null) return 0;
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }
}
