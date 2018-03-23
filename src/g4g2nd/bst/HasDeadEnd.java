package g4g2nd.bst;

import java.util.HashMap;
import java.util.Map;

public class HasDeadEnd {

    Node root;
    public static void main(String[] args) {
        /*       8
               /   \
              5    11
             /  \
            2    7
             \
              3
               \
                4 */
        HasDeadEnd tree = new HasDeadEnd();
        tree.root = new Node(8);
        tree.root.left = new Node(5);
        tree.root.right = new Node(11);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(7);
        tree.root.left.left.right = new Node(3);
        tree.root.left.left.right.right = new Node(4);

        System.out.println(tree.hasDeadEnd(tree.root));
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean hasDeadEnd(Node root) {
        Map<Integer, Node> allNodes = new HashMap<>();
        Map<Integer, Node> allLeaves = new HashMap<>();
        inorder(root, allNodes, allLeaves);

        for (int k : allLeaves.keySet()) {
            if(allNodes.containsKey(k+1) || allNodes.containsKey(k-1)) return true;
        }
        return false;
    }

    void inorder(Node root, Map<Integer, Node> allNodes, Map<Integer, Node> allLeaves) {
        if (root != null) {
            inorder(root.left, allNodes, allLeaves);
            allNodes.put(root.data, root);
            if (root.left == null && root.right == null) {
                allLeaves.put(root.data, root);
            }
            inorder(root.right, allNodes, allLeaves);
        }
    }
}
