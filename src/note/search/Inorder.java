package note.search;

public class Inorder {

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

        Inorder inorder = new Inorder();
        inorder.traverse(F);
    }

    void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            System.out.print(root.data + " ");
            traverse(root.right);
        }
    }
}
