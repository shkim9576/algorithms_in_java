package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
public class LevelOrderTraversalInSpiralForm {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        System.out.println("Spiral order traversal of Binary Tree is ");
        printSpiral(root);
    }

    static void printSpiral(Node node) {
        int h = height(node);

        boolean ltr = false;
        for (int i = 1; i <= h; i++) {
            printGivenLevel(node, i, ltr);
            ltr = !ltr;
        }
    }

    static int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static void printGivenLevel(Node node, int level, boolean ltr) {
        if (node == null) return;

        if (level == 1) System.out.print(node.key + " ");
        else if (level > 1) {
            if (ltr) {
                printGivenLevel(node.left, level - 1, ltr);
                printGivenLevel(node.right, level - 1, ltr);
            } else {
                printGivenLevel(node.right, level - 1, ltr);
                printGivenLevel(node.left, level - 1, ltr);
            }
        }
    }
}
