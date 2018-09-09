package g4g1st.hash.excercise;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderBTree {
    // https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        VerticalOrderBTree ob = new VerticalOrderBTree();
        ob.printVerticalOrder(root);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    void printVerticalOrder(TreeNode root) {
        if (root == null) return;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        buildVerticalOrder(root, 0, map);

        for (List<Integer> vList : map.values()) {
            for (int n : vList) System.out.print(n + " ");
            System.out.println("");
        }
    }

    void buildVerticalOrder(TreeNode root, int hd, TreeMap<Integer, List<Integer>> map) {
        if (root == null) return;

        List<Integer> vList = map.get(hd);
        if (vList == null) vList = new ArrayList<>();

        vList.add(root.val);
        map.put(hd, vList);

        buildVerticalOrder(root.left, hd - 1, map);
        buildVerticalOrder(root.right, hd + 1, map);
    }

}
