package geeksforgeeks.five.graph;

import java.util.Arrays;

// https://leetcode.com/problems/graph-valid-tree/
public class ValidTree {
    public static void main(String[] args) {
        ValidTree o = new ValidTree();
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(o.validTree(5, edges));
    }

    boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if (x == y) return false;
            //union
            nums[x] = y;
        }
        return edges.length == n - 1;
    }

    int find(int[] nums, int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
