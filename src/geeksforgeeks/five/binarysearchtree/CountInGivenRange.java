package geeksforgeeks.five.binarysearchtree;

//https://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
public class CountInGivenRange {

    //Count of nodes between [5, 45] is 3
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.root = new Node(10);
        tree.root.left     = new Node(5);
        tree.root.right     = new Node(50);
        tree.root.left.left = new Node(1);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(100);
        /* Let us constructed BST shown in above example
          10
        /    \
      5       50
     /       /  \
    1       40   100   */
        int l=5;
        int h=45;
        System.out.println("Count of nodes between [" + l + ", "
                + h+ "] is " + count(tree.root,
                l, h));
    }

    static int count(Node root, int l, int h) {
        if (root == null) return 0;
        if (root.data > h) return count(root.left, l, h);
        if (root.data < l) return count(root.right, l, h);
        return count(root.left, l, h) + count(root.right, l, h) + 1;
    }
}
