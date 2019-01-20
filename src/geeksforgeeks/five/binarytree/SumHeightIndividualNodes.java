package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/sum-heights-individual-nodes-binary-tree/
public class SumHeightIndividualNodes {

    //Sum of heights of all Nodes = 8
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Sum of heights of all Nodes = " + getTotalHeight(root));
    }

    static int sum = 0;

    static int getTotalHeight(Node root) {
        getTotalHeightRec(root);
        return sum;
    }

    static int getTotalHeightRec(Node root) {
        if (root == null) return 0;
        int h = Math.max(getTotalHeightRec(root.left), getTotalHeightRec(root.right)) + 1;
        sum += h;
        return h;
    }
}
