package geeksforgeeks.one.tree.excercise;

public class FindDistance {
    // https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        FindDistance ob = new FindDistance();
        System.out.println("Dist(4, 5) = " + ob.findDistance(root, new Node(4), new Node(5))); //2
        System.out.println("Dist(4, 6) = " + ob.findDistance(root, new Node(4), new Node(6))); //4
        System.out.println("Dist(3, 4) = " + ob.findDistance(root, new Node(3), new Node(4))); //3
        System.out.println("Dist(2, 4) = " + ob.findDistance(root, new Node(2), new Node(4))); //1
        System.out.println("Dist(8, 5) = " + ob.findDistance(root, new Node(8), new Node(5))); //5
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }

    int findDistance(Node root, Node n1, Node n2) {
        if (root == null || n1 == null || n2 == null) return -1;

        Node lca = findLCA(root, n1, n2);
        int d1 = getDistance(lca, n1, 0);
        int d2 = getDistance(lca, n2, 0);

        return d1 + d2;
    }

    Node findLCA(Node root, Node n1, Node n2) {
        if (root == null || n1 == null || n2 == null) return null;

        if (n1.data == root.data || n2.data == root.data) return root;

        Node left = findLCA(root.left, n1 , n2);
        Node right = findLCA(root.right, n1, n2);

        if (left != null && right != null) return root;
        return left == null ? right : left;
    }


    int getDistance(Node lca, Node node, int dist) {
        if (lca == null || node == null) return -1;
        if (lca.data == node.data) return dist;

        int left = getDistance(lca.left, node, dist + 1);
        int right = getDistance(lca.right, node, dist + 1);
        return left == -1 ? right : left;
    }

}
