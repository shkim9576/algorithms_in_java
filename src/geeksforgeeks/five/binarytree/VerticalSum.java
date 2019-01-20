package geeksforgeeks.five.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

//https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
public class VerticalSum {

    public static void main(String[] args) { 
        /* Create following Binary Tree 
              1 
            /    \ 
          2        3 
         / \      / \ 
        4   5    6   7 
   
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Following are the values of" +
                " vertical sums with the positions" +
                " of the columns with respect to root ");
        verticalSumMain(root);
    }

    static void verticalSumMain(Node root) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        sum(root, map, 0);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) sb.append(e).append(" ");

        System.out.println(sb.toString());
    }

    static void sum(Node root, Map<Integer, Integer> map, int vl) {
        if (root == null) return;
        map.put(vl, map.getOrDefault(vl, 0) + root.key);
        sum(root.left, map, vl - 1);
        sum(root.right, map, vl + 1);
    }
}
