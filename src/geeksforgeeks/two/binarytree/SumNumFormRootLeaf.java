package geeksforgeeks.two.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumNumFormRootLeaf {

    Node root;
    public static void main(String[] args) {
        SumNumFormRootLeaf tree = new SumNumFormRootLeaf();
        tree.root = new Node(6);
        tree.root.left = new Node(3);
        tree.root.right = new Node(5);
        tree.root.right.right = new Node(4);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(4);
        tree.root.left.right.left = new Node(7);

        System.out.print("Sum of all paths is " +
                         tree.treePathsSum(tree.root));
    }


    static class Node {
        long data;
        Node left, right;
        Node (long d) {
            data = d;
        }
    }

    static class LongWrapper {
        long data;
    }

    long treePathsSum(Node root) {
        if (root == null) return 0;
        List<Node> stack = new ArrayList<>();
        LongWrapper res = new LongWrapper();
        helper(root, stack, res);
        return res.data;
    }

    void helper(Node root, List<Node> path, LongWrapper res) {
        if (root == null) return;
        path.add(root);
        if (root.left == null && root.right == null) {
            long sum = formNumber(path);
            res.data += sum;
        }
        helper(root.left, path, res);
        helper(root.right, path, res);
        path.remove(path.size() - 1);
    }

    long formNumber(List<Node> path) {
        Stack<Node> stack = new Stack<>();
        for (Node n : path) {
            stack.push(n);
        }

        long sum = 0;
        long mul = 1;
        while(!stack.isEmpty()) {
            sum += (stack.pop().data * mul);
            mul *= 10;
        }
        return sum;
    }
}
