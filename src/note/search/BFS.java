package note.search;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

        BFS bfs = new BFS();
        bfs.traverse(F);
    }

    public void traverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}