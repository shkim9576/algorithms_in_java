package blog.search;

import java.util.HashSet;
import java.util.Set;

public class DFSGraph {

    public static void main(String[] args) {

        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");

        F.left = B;
        F.right = G;
        B.left = A;
        B.right = D;
        D.left = C;
        D.right = E;
        G.right = I;
        I.left = H;
        H.right = F; // loop

        DFSGraph dfsGraph = new DFSGraph();
        Set<TreeNode> visited = new HashSet();

        dfsGraph.traverse(F, visited);
    }

    void traverse(TreeNode root, Set<TreeNode> visited) {
        if (root != null) {
            if (!visited.contains(root.left)) {
                traverse(root.left, visited);
            }

            System.out.print(root.data + " ");
            visited.add(root);

            if (!visited.contains(root.right)) {
                traverse(root.right, visited);
            }
        }
    }

}
