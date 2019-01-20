package geeksforgeeks.five.binarytree;

import java.util.Vector;

//https://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/
public class FindAllPossibleTreesWithInorder {

    public static void main(String args[]) {
        int in[] = {4, 5, 7};
        int n = in.length;

        Vector<Node> trees = getTrees(in, 0, n - 1);
        System.out.println("Preorder traversal of different binary trees are:");

        for (int i = 0; i < trees.size(); i++) {
            preOrder(trees.get(i));
            System.out.println();
        }
    }

    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static Vector<Node> getTrees(int[] in, int l, int r) {
        Vector<Node> trees = new Vector<>();
        if (l > r) {
            trees.add(null);
            return trees;
        }

        for (int i = l; i <= r; i++) {
            Vector<Node> lTrees = getTrees(in, l, i - 1);
            Vector<Node> rTrees = getTrees(in, i + 1, r);

            for (int j = 0; j < lTrees.size(); j++) {
                for (int k = 0; k < rTrees.size(); k++) {
                    Node node = new Node(in[i]);
                    node.left = lTrees.get(j);
                    node.right = rTrees.get(k);
                    trees.add(node);
                }
            }
        }

        return trees;
    }
}
