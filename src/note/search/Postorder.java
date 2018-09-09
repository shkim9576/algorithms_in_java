package note.search;

public class Postorder {

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

        Postorder postorder = new Postorder();
        postorder.traverse(F);
    }

    void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            traverse(root.right);
            System.out.print(root.data + " ");
        }
    }
}
