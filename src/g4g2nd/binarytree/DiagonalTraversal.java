package g4g2nd.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversal {

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.right = new Node(10);
        root.right.left = new Node(6);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(7);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        /*
        8 10 14
        3 6 7 13
        1 4
        */
        DiagonalTraversal ob = new DiagonalTraversal();
        ob.printDiagnoal(root);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    public void printDiagnoal(Node root) {
        Map<Integer, List<Node>> levelNodeMap = new TreeMap<>();
        printDiagonal(root, levelNodeMap, 0);

        for (Map.Entry<Integer, List<Node>> entry : levelNodeMap.entrySet()) {
            List<Node> list = entry.getValue();
            for (Node n : list) {
                System.out.print(n.data + " ");
            }
            System.out.println();
        }
    }

    public void printDiagonal(Node root, Map<Integer, List<Node>> map, int level) {
        if (root == null) return;

        List<Node> list = map.getOrDefault(level, new ArrayList<>());
        list.add(root);
        map.put(level, list);

        printDiagonal(root.left, map, level+1);
        printDiagonal(root.right, map, level);
    }

}
