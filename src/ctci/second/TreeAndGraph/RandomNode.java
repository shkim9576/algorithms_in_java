package ctci.second.TreeAndGraph;

import java.util.Random;

public class RandomNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.insert(3);
        root.insert(7);
        root.insert(2);
        root.insert(0);
        root.insert(8);
        root.insert(6);
        root.insert(1);
        root.insert(4);
        root.insert(5);

        System.out.println("=== Find ===");
        System.out.println(root.find(3).val);
        System.out.println(root.find(2).val);
        System.out.println(root.find(7).val);
        System.out.println(root.find(9).val);

        System.out.println("=== Get random node ===");
        System.out.println(root.getRandomNode().val);
        System.out.println(root.getRandomNode().val);
        System.out.println(root.getRandomNode().val);
        System.out.println(root.getRandomNode().val);
        System.out.println(root.getRandomNode().val);
    }

    static class TreeNode {
        int val;
        int size;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.size = 1;
        }

        TreeNode getRandomNode() {
            Random random = new Random();
            int i = random.nextInt(this.size);
            int leftSize = left == null ? 0 : left.size;

            if (leftSize == i) return this;
            else if (leftSize < i) return right.getRandomNode();
            return left.getRandomNode();
        }

        void insert(int val) {
            if (val > this.val) {
                if (this.right == null) this.right = new TreeNode(val);
                else right.insert(val);
            } else {
                if (this.left == null) this.left = new TreeNode(val);
                else left.insert(val);
            }
            this.size++;
        }

        TreeNode find(int val) {
            if (val == this.val) return this;
            if (right != null && val > this.val) return right.find(val);
            if (left != null && val < this.val) return left.find(val);
            return null;
        }
    }
}
