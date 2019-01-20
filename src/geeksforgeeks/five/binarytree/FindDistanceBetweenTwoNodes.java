package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
public class FindDistanceBetweenTwoNodes {

    //Dist(4, 5) = 2
    //Dist(4, 6) = 4
    //Dist(3, 4) = 3
    //Dist(2, 4) = 1
    //Dist(8, 5) = 5
    public static void main(String[] args) {
        // Let us create binary tree given in the above example
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
        System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
        System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));
        System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));
        System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));
    }

    static int findDistance(Node root, int a, int b) {
        int x = distance(root, a, 0);
        int y = distance(root, b, 0);
        int lca = lca(root, a, b);
        int z = distance(root, lca, 0);

        return x + y - 2 * z;
    }

    static int distance(Node root, int a, int depth) {
        if (root == null) return -1;
        if (root.key == a) return depth;

        int l = distance(root.left, a, depth + 1);
        int r = distance(root.right, a, depth + 1);

        return Math.max(l, r);
    }

    static int lca(Node root, int a, int b) {
        if (root == null) return -1;
        if (root.key == a || root.key == b) return root.key;

        int l = lca(root.left, a, b);
        int r = lca(root.right, a, b);

        if (l > 0 && r > 0) return root.key;

        return Math.max(l, r);
    }
}
