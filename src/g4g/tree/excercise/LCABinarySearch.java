package g4g.tree.excercise;

public class LCABinarySearch {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

    public static void main(String args[]) {
        // Let us construct the BST shown in the above figure
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        LCABinarySearch ob = new LCABinarySearch();
        System.out.println(ob.lca(root, new Node(10), new Node(14)).data); //12
        System.out.println(ob.lca(root, new Node(14), new Node(8)).data);  //8
        System.out.println(ob.lca(root, new Node(10), new Node(22)).data); //20
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node lca(Node root, Node n1, Node n2) {
        if (root == null || n1 == null || n2 == null) return null;

        if (n1.data < root.data && n2.data < root.data) return lca(root.left, n1, n2);
        if (n1.data > root.data && n2.data > root.data) return lca(root.right, n1, n2);

        return root;
    }

}
