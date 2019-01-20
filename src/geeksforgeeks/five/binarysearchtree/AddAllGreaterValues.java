package geeksforgeeks.five.binarysearchtree;

//https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
public class AddAllGreaterValues {

    //350 330 300 260 210 150 80
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(); 
          
          /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */

        tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        modifyBST(tree.root);

        // print inoder tarversal of the modified BST 
        inorder(tree.root);
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static int sum = 0;
    static void modifyBST(Node root) {
        if (root == null) return;
        modifyBST(root.right);

        sum += root.data;
        root.data = sum;

        modifyBST(root.left);
    }
}
