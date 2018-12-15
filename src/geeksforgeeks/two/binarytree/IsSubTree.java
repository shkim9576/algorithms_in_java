package geeksforgeeks.two.binarytree;

public class IsSubTree {

    Node root1, root2;
    public static void main(String[] args) {
        IsSubTree tree = new IsSubTree();

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        tree.root2 = new Node(10);
        tree.root2.right = new Node(6);
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);

        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean isSubtree(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;

        Node sameNode = findNode(n1, n2);
        return isSame(sameNode, n2);
    }

    boolean isSame(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;

        return n1.data == n2.data && isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
    }

    Node findNode (Node n1, Node n2) {
        if (n1 == null || n2 == null) return null;
        if (n1.data == n2.data) return n1;

        Node left = findNode(n1.left, n2);
        if (left != null) return left;
        Node right = findNode(n1.right, n2);
        if (right != null) return right;

        return null;
    }
}
