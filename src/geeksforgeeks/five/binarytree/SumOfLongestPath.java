package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/sum-nodes-longest-path-root-leaf-node/
public class SumOfLongestPath {

    //Sum = 13
    public static void main(String args[]) {
        // binary tree formation
        Node root = new Node(4);         /*        4        */
        root.left = new Node(2);         /*       / \       */
        root.right = new Node(5);        /*      2   5      */
        root.left.left = new Node(7);    /*     / \ / \     */
        root.left.right = new Node(1);   /*    7  1 2  3    */
        root.right.left = new Node(2);   /*      /          */
        root.right.right = new Node(3);  /*     6           */
        root.left.right.left = new Node(6);

        System.out.println("Sum = "
                + sumOfLongRootToLeafPathUtil(root));
    }

    static int maxSum = 0;
    static int maxLength = 0;

    static int sumOfLongRootToLeafPathUtil(Node root) {
        sumOfLongRootToLeafPath(root, maxLength, maxSum);
        return maxSum;
    }

    static void sumOfLongRootToLeafPath(Node root, int length, int sum) {
        if (root == null) {
            if (length > maxLength) {
                maxSum = sum;
                maxLength = length;
            } else if (length == maxLength && maxSum < sum) {
                maxSum = sum;
            }
            return;
        }

        sumOfLongRootToLeafPath(root.left, length + 1, sum + root.key);
        sumOfLongRootToLeafPath(root.right, length + 1, sum + root.key);
    }
}
