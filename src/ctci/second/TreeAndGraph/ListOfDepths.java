package ctci.second.TreeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {

    public static void main(String[] args) {
        ListOfDepths o = new ListOfDepths();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n5.right = n7;

        List<List<Integer>> ans = o.buildListOfDepthBFS(n1);
        System.out.println(ans);

        List<List<Integer>> ansDFS = new ArrayList<>();
        o.buildListOfDepthDFS(n1, 0, ansDFS);
        System.out.println(ansDFS);
    }

    void buildListOfDepthDFS(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) return;
        if (ans.size() <= level) ans.add(new LinkedList<>());
        ans.get(level).add(root.val);
        buildListOfDepthDFS(root.left, level + 1, ans);
        buildListOfDepthDFS(root.right, level + 1, ans);
    }

    List<List<Integer>> buildListOfDepthBFS(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.remove();
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
                list.add(n.val);
            }
            ans.add(list);
        }

        return ans;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
