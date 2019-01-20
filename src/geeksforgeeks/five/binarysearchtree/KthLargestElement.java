package geeksforgeeks.five.binarysearchtree;

//https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
public class KthLargestElement {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(tree.root, 50);
        tree.insert(tree.root,30);
        tree.insert(tree.root,20);
        tree.insert(tree.root,40);
        tree.insert(tree.root,70);
        tree.insert(tree.root,60);
        tree.insert(tree.root,80);

        for(int i = 1; i < 8; i++) {
            System.out.println(kthLargest(tree.root, i));
            count = 0;
        }
    }

    static int count = 0;
    static int result = 0;

    static int kthLargest(Node root, int k) {
        inorder(root, k);
        return result;
    }

    static void inorder(Node root, int k) {
        if (root == null) return;

        inorder(root.right, k);

        if (++count == k) {
            result = root.data;
            return;
        }

        inorder(root.left, k);
    }
}
