package ctci.treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        ListOfDepths ob = new ListOfDepths();
        List<List<Node>> result = ob.getListOfDepths(root);

        for (List<Node> res : result) {
            System.out.print(res);
            System.out.println();
        }

    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    List<List<Node>> getListOfDepths(Node root) {
        List<List<Node>> lists = new ArrayList<>();
        create(root, lists, 0);
        return lists;
    }

    void create(Node root, List<List<Node>> lists, int level) {
        if (root == null) return;

        List<Node> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        create(root.left, lists, level + 1);
        create(root.right, lists, level + 1);
    }

}
