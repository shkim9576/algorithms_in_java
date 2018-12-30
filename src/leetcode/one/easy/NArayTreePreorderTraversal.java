package leetcode.one.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class NArayTreePreorderTraversal {

    public static void main(String[] args) {
        NArayTreePreorderTraversal o = new NArayTreePreorderTraversal();

        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());

        List<Node> l1 = new ArrayList<>();
        l1.add(n3);
        l1.add(n2);
        l1.add(n4);

        List<Node> l2 = new ArrayList<>();
        l1.add(n5);
        l1.add(n6);

        n1.children = l1;
        n3.children = l2;

        System.out.println(o.preorder(n1));
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    public void helper(List<Integer> result, Node root) {
        if (root != null) {
            result.add(root.val);
            for (Node n : root.children) {
                helper(result, n);
            }
        }
    }
}
