package leetcode.one.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
public class MaximumDepthOfNAryTree {

    public static void main(String[] args) {
        MaximumDepthOfNAryTree o = new MaximumDepthOfNAryTree();

        Node n3 = new Node(3, new ArrayList<>());
        List l1 = new ArrayList();
        l1.add(n3);
        Node root = new Node(1, l1);

        System.out.println(o.maxDepth(root)); //2
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        for (Node c : root.children) {
            if (c != null) maxDepth = Math.max(maxDepth, maxDepth(c));
        }
        return maxDepth + 1;
    }
}