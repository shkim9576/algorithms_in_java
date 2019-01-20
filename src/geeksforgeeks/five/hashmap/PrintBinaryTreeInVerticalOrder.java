package geeksforgeeks.five.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class PrintBinaryTreeInVerticalOrder {

    //Vertical order traversal is
    //4
    //2
    //1 5 6
    //3 8
    //7
    //9
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

        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }

    static void printVerticalOrder(Node root) {
        SortedMap<Integer, List<Integer>> map = new TreeMap<>();
        printVertical(root, map, 0);
        System.out.println(map);
    }

    static void printVertical(Node root, SortedMap<Integer, List<Integer>> map, int l) {
        if (root == null) return;
        List<Integer> list = map.getOrDefault(l, new ArrayList<>());
        list.add(root.data);
        map.put(l, list);

        printVertical(root.left, map, l - 1);
        printVertical(root.right, map, l + 1);
    }

}
