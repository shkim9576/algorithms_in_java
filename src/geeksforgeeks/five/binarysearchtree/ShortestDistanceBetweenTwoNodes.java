package geeksforgeeks.five.binarysearchtree;

public class ShortestDistanceBetweenTwoNodes {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 12);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 9);
        tree.insert(tree.root, 21);
        tree.insert(tree.root, 19);
        tree.insert(tree.root, 25);

        System.out.println(shortestDistance(tree.root, tree.root.left.right, tree.root.right.left)); //4
    }

    static int shortestDistance(Node root, Node n1, Node n2) {
        Node lca = findLCA(root, n1, n2);
        return getDistance(lca, n1) + getDistance(lca, n2);
    }

    static Node findLCA(Node root, Node n1, Node n2) {
        if (root == null) return null;
        if (root.data > n1.data && root.data > n2.data) return findLCA(root.left, n1, n2);
        if (root.data < n1.data && root.data < n2.data) return findLCA(root.right, n1, n2);
        return root;
    }

    static int getDistance(Node root, Node t) {
        if (root == null || root.data == t.data) return 0;
        return root.data > t.data ? getDistance(root.left, t) + 1 : getDistance(root.right, t) + 1;
    }
}
