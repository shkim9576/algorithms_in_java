package leetcode.one.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
public class NaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal o = new NaryTreeLevelOrderTraversal();
        o.levelOrder(o);
    }

    public void levelOrder(NaryTreeLevelOrderTraversal o) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        Node n5 = new Node(5, null);
        Node n6 = new Node(6, null);

        List<Node> l1 = new ArrayList<>();
        l1.add(n3);
        l1.add(n2);
        l1.add(n4);
        List<Node> l2 = new ArrayList<>();
        l2.add(n5);
        l2.add(n6);

        n1.children = l1;
        n3.children = l2;

        System.out.println(o.levelOrder(n1));
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> result = new ArrayList<>();

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                if (n.children != null) for (Node c : n.children) q.add(c);
                list.add(n.val);
            }

            result.add(list);
        }
        return result;
    }

    class Node {
        int val;
        List<Node> children;

        public Node(int v, List<Node> c) {
            this.val = v;
            this.children = c;
        }
    }
}
