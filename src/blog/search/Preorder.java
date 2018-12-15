package blog.search;

public class Preorder {

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

        Preorder preorder = new Preorder();
        preorder.traverse(F);
    }

    void traverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            traverse(root.left);
            traverse(root.right);
        }
    }
}

