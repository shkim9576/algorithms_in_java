package geeksforgeeks.five.binarysearchtree;

//https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/
public class FindMinNode {

    //Minimum value in BST is 1
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = null;
        root = tree.insert(root, 4);
        tree.insert(root, 2);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 5);

        System.out.println("The minimum value of BST is " + minvalue(root));
    }

    static int minvalue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }
}
