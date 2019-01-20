package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/sum-leaf-nodes-minimum-level/
public class SumLeafMinLevel {

    //11
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right.left.right = new Node(9);

        System.out.println("Sum = " + sumOfLeafNodesAtMinLevel(root));
    }

    static int sum = 0;

    static int sumOfLeafNodesAtMinLevel(Node root) {
        int ml = getMinLevel(root);
        getSum(root, 1, ml);
        return sum;
    }

    static void getSum(Node root, int curr, int target) {
        if (root == null) return;
        if (curr == target && root.left == null && root.right == null) sum += root.key;
        getSum(root.left, curr + 1, target);
        getSum(root.right, curr + 1, target);
    }

    static int getMinLevel(Node root) {
        if (root == null) return 0;
        return Math.min(getMinLevel(root.left), getMinLevel(root.right)) + 1;
    }
}
