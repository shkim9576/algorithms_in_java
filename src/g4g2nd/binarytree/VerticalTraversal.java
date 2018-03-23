package g4g2nd.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        /*
        4
        2
        1 5 6
        3 8
        7
        9
        */
        VerticalTraversal ob = new VerticalTraversal();
        ob.printVertical(root);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }


    void printVertical(Node root) {
        Map<Integer, List<Node>> levelNodeMap = new TreeMap<>();
        printVertical(root, levelNodeMap, 0);

        for(Map.Entry<Integer, List<Node>> entry : levelNodeMap.entrySet()) {
            List<Node> list = entry.getValue();
            for (Node n : list) {
                System.out.print(n.data + " ");
            }
            System.out.println();
        }
    }

    void printVertical(Node root, Map<Integer, List<Node>> map, int level) {
        if (root == null) return;

        List<Node> list = map.getOrDefault(level, new ArrayList<>());
        list.add(root);
        map.put(level, list);

        printVertical(root.left, map, level - 1);
        printVertical(root.right, map, level + 1);
    }

}
