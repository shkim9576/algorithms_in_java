package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/sum-parent-nodes-child-node-x/
public class SumParentNodesChildNodeX {

    public static void main(String args[]) {
        // binary tree formation
        Node root = new Node(4);         //         4
        root.left = new Node(2);         //        / \
        root.right = new Node(5);         //      2   5
        root.left.left = new Node(7);     //     / \ / \
        root.left.right = new Node(2);       // 7  2 2  3
        root.right.left = new Node(2);
        root.right.right = new Node(3);

        int x = 2;

        System.out.println("Sum = " + sumOfParentOfXUtil(root, x));
    }

    static int sum = 0;

    static int sumOfParentOfXUtil(Node root, int x) {
        if (root == null) return 0;
        if ((root.left != null && root.left.key == x) || (root.right != null && root.right.key == x))
            sum += root.key;
        sumOfParentOfXUtil(root.left, x);
        sumOfParentOfXUtil(root.right, x);

        return sum;
    }

}
