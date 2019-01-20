package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/sum-nodes-binary-tree/
public class SumOfAllNodes {

    //Sum of all the elements is: 36
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        int sum = addBT(root);
        System.out.println("Sum of all the elements is: " + sum);
    }

    static int addBT(Node root) {
        if (root == null) return 0;
        return root.key + addBT(root.left) + addBT(root.right);
    }
}
