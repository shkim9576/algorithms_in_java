package geeksforgeeks.five.binarysearchtree;

//https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
public class LowestCommonAncestor {

    //LCA of 10 and 14 is 12
    //LCA of 14 and 8 is 8
    //LCA of 10 and 22 is 20
    public static void main(String args[]) {
        // Let us construct the BST shown in the above figure 
        BinaryTree tree = new BinaryTree();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = lca(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = lca(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = lca(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }

    static Node lca(Node root, int n1, int n2) {
        if (root == null) return null;
        if (n1 > root.data && n2 > root.data) return lca(root.right, n1, n2);
        if (n1 < root.data && n2 < root.data) return lca(root.left, n1, n2);
        return root;
    }
}
