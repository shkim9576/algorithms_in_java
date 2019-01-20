package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/
public class FindLargestSubtreeSum {

    public static void main(String args[]) {
    /*
              1
            /   \
          -2     3
          / \   / \
         4   5 -6  2
    */

        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);

        System.out.println(findLargestSubtreeSum(root));
    }

    static int max = Integer.MIN_VALUE;

    static int findLargestSubtreeSum(Node root) {
        findLargestSubtreeSumRec(root);
        return max;
    }

    static int findLargestSubtreeSumRec(Node root) {
        if (root == null) return 0;

        int sum = root.key + findLargestSubtreeSumRec(root.left) + findLargestSubtreeSumRec(root.right);
        max = Math.max(max, sum);

        return sum;
    }
}
