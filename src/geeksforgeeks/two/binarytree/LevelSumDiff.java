package geeksforgeeks.two.binarytree;

public class LevelSumDiff {

    Node root;
    public static void main(String[] args) {
        LevelSumDiff tree = new LevelSumDiff();
        tree.root = new Node(5);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        tree.root.left.right.left = new Node(3);
        tree.root.right.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.right.right.left = new Node(7);

        //-9 is the required difference
        System.out.println(tree.getLevelDiff(tree.root) +
                           " is the required difference");
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    static class IntWrapper {
        int data;
    }

    int getLevelDiff(Node root) {
        if (root == null) return 0;
        return root.data - getLevelDiff(root.left) - getLevelDiff2(root.right);
    }

    int getLevelDiff2(Node root) {
        if (root == null) return 0;
        IntWrapper res = new IntWrapper();
        helper(root, res, 0);
        return res.data;
    }

    void helper(Node root, IntWrapper res, int level) {
        if (root == null) return;
        if (level % 2 == 1) {
            res.data -= root.data;
        } else {
            res.data += root.data;
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
