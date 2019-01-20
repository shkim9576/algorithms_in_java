package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
public class FindMaxSumPath {

    //         10
    //        /   \
    //       -2    7
    //      /   \
    //     8    -4
    //Following are the nodes on maximum sum path
    //7 10
    //Sum of nodes is : 17
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        System.out.println("Following are the nodes " +
                "on maximum sum path");
        int sum = maxSumPath(root);
        System.out.println();
        System.out.println("Sum of nodes is : " + sum);
    }

    static int max = 0;
    static Node target;

    static int maxSumPath(Node root) {
        maxSumPath(root, 0);
        printTarget(root);
        return max;
    }

    static boolean printTarget(Node root) {
        if (root == null) return false;
        if (root == target || printTarget(root.left) || printTarget(root.right)) {
            System.out.print(root.key + " ");
            return true;
        }

        return false;
    }

    static void maxSumPath(Node root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.key + sum);
            target = root;
        }

        maxSumPath(root.left, sum + root.key);
        maxSumPath(root.right, sum + root.key);
    }

}
