package geeksforgeeks.five.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/replace-node-binary-tree-sum-inorder-predecessor-successor/
public class ReplaceNodeBinaryTreeSumInorderPredecessorSuccessor {

    //Preorder Traversal before tree modification:
    //1 2 4 5 3 6 7
    //Preorder Traversal after tree modification:
    //11 9 2 3 13 4 3
    public static void main(String args[]) {
        // binary tree formation
        Node root = getNode(1);       //         1
        root.left = getNode(2);        //       /   \
        root.right = getNode(3);       //     2      3
        root.left.left = getNode(4);  //    /  \  /   \
        root.left.right = getNode(5); //   4   5  6   7
        root.right.left = getNode(6);
        root.right.right = getNode(7);

        System.out.println("Preorder Traversal before tree modification:");
        preorderTraversal(root);

        replaceNodeWithSumUtil(root);

        System.out.println("\nPreorder Traversal after tree modification:");
        preorderTraversal(root);
    }

    static Node getNode(int i) {
        return new Node(i);
    }

    static void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    static void replaceNodeWithSumUtil(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] index = new int[1];
        index[0] = 0;
        sum(root, list, index);
    }

    static void sum(Node root, List<Integer> list, int[] index) {
        if (root != null) {
            sum(root.left, list, index);
            int left = index[0] == 0 ? 0 : list.get(index[0] - 1);
            int right = index[0] == list.size() - 1 ? 0 : list.get(index[0] + 1);
            root.key = left + right;
            index[0]++;
            sum(root.right, list, index);
        }
    }

    static void inorder(Node root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.key);
            inorder(root.right, list);
        }
    }
}
