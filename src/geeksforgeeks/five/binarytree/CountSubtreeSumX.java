package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/count-subtress-sum-given-value-x/
public class CountSubtreeSumX {
    public static void main(String args[]) {
    /* binary tree creation      
                5  
            / \  
        -10     3  
        / \ / \  
        9 8 -4 7  
    */
        Node root = new Node(5);
        root.left = new Node(-10);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(8);
        root.right.left = new Node(-4);
        root.right.right = new Node(7);

        int x = 7;

        System.out.println("Count = " +
                countSubtreesWithSumXUtil(root, x));
    }

    static int count = 0;

    static int countSubtreesWithSumXUtil(Node root, int x) {
        sum(root, x);
        return count;
    }

    static int sum(Node root, int x) {
        if (root == null) return 0;
        int sum = sum(root.left, x) + sum(root.right, x) + root.key;
        if (sum == x) count++;
        return sum;
    }
}
