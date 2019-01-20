package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
public class FindSumLeftLeaves {

    //Sum of left leaves is 78
    public static void main(String args[]) {
        Node root = new Node(20);
        root.left = new Node(9);
        root.right = new Node(49);
        root.left.right = new Node(12);
        root.left.left = new Node(5);
        root.right.left = new Node(23);
        root.right.right = new Node(52);
        root.left.right.right = new Node(12);
        root.right.right.left = new Node(50);

        System.out.println("The sum of leaves is " +
                leftLeavesSum(root));
    }

    static int leftLeavesSum(Node root) {
        if (root == null) return 0;

        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) res += root.left.key;
        else res += leftLeavesSum(root.left);

        res += leftLeavesSum(root.right);

        return res;
    }
}
