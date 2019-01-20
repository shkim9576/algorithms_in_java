package geeksforgeeks.five.binarysearchtree;

//https://www.geeksforgeeks.org/sum-k-smallest-elements-bst/
public class SumKSmallest {

    //22
    public static void main(String[] args) {

        /*    20
            /    \
           8     22
         /   \
        4     12
             /   \
            10    14
              */
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 8);
        tree.insert(tree.root, 4);
        tree.insert(tree.root, 12);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 14);
        tree.insert(tree.root, 22);

        int k = 3;
        System.out.println(ksmallestElementSum(tree.root, k));

    }

    static int count = 0;
    static int ksmallestElementSum(Node root, int k) {
        if (root == null || k < count) return 0;

        int res = ksmallestElementSum(root.left, k);

        if (count < k) {
            res += root.data;
        }
        else {
            return res;
        }
        count++;

        return res + ksmallestElementSum(root.right, k);
    }
}
