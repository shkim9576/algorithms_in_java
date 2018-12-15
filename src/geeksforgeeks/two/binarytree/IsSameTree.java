package geeksforgeeks.two.binarytree;

import java.util.ArrayList;
import java.util.List;

public class IsSameTree {

    Node root1;
    Node root2;
    public static void main(String[] args) {
        IsSameTree tree = new IsSameTree();

        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);

        if (tree.identicalTrees(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
    }

    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
        }
    }

    boolean identicalTrees(Node root1, Node root2) {
        List<Integer> list1 = getList(root1);
        List<Integer> list2 = getList(root2);
        return list1.equals(list2);
    }

    List<Integer> getList(Node node) {
        List<Integer> res = new ArrayList<>();
        getList(node, res);
        return res;
    }

    void getList(Node root, List<Integer> res) {
        if (root != null) {
            getList(root.left, res);
            res.add(root.data);
            getList(root.right, res);
        }
    }
}
