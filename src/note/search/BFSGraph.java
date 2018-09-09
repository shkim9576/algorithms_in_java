package note.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSGraph {
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

        BFSGraph bfs = new BFSGraph();
        bfs.traverse(F);
    }

    public void traverse(TreeNode root) {
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.data + " ");
            visited.add(node);

            if (node.left != null && !visited.contains(node.left)) {
                queue.add(node.left);
            }

            if (node.right != null && !visited.contains(node.right)) {
                queue.add(node.right);
            }
        }
    }
}
