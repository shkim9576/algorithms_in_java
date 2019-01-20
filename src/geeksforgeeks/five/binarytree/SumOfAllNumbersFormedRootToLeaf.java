package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
public class SumOfAllNumbersFormedRootToLeaf {

    //Sum of all paths is 13997
    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.right = new Node(4);
        root.left.right.left = new Node(7);

        System.out.print("Sum of all paths is " + treePathsSum(root));
    }

    static int treePathsSum(Node root) {
        return treePathsSum(root, 0);
    }

    static int treePathsSum(Node root, int sum) {
        if (root == null) return 0;

        sum *= 10;
        sum += root.key;
        if (root.left == null && root.right == null) return sum;

        return treePathsSum(root.left, sum) + treePathsSum(root.right, sum);
    }
}
