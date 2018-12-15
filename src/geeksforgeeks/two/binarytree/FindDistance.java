package geeksforgeeks.two.binarytree;

public class FindDistance {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        /*
        Dist(4, 5) = 2
        Dist(4, 6) = 4
        Dist(3, 4) = 3
        Dist(2, 4) = 1
        Dist(8, 5) = 5
         */
        FindDistance ob = new FindDistance();
        System.out.println("Dist(4, 5) = " + ob.getDistance(root, 4, 5));
        System.out.println("Dist(4, 6) = " + ob.getDistance(root, 4, 6));
        System.out.println("Dist(3, 4) = " + ob.getDistance(root, 3, 4));
        System.out.println("Dist(2, 4) = " + ob.getDistance(root, 2, 4));
        System.out.println("Dist(8, 5) = " + ob.getDistance(root, 8, 5));
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    int findDistance(Node lca, int node, int distance) {
        if (lca == null) return 0;
        if (lca.data == node) return distance;

        int left = findDistance(lca.left, node, distance + 1);
        int right = findDistance(lca.right, node, distance + 1);

        return Math.max(left, right);
    }

    int getDistance(Node root, int n1, int n2) {
        Node lca = findLCA(root, n1, n2);
        return findDistance(lca, n1, 0) + findDistance(lca, n2, 0);
    }

    Node findLCA(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;

        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if (left != null && right != null) return root;
        return (left == null) ? right : left;
    }

}
