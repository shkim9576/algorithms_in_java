package ctci.second.TreeAndGraph;

public class Successor {
    public static void main(String[] args) {
        Successor o = new Successor();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        //         n6
        //        /   \
        //       n2    n8
        //      /  \   /
        //     n1  n4 n7
        //        /  \
        //       n3  n5
        n6.left = n2;
        n6.right = n8;
        n2.left = n1;
        n2.right = n4;
        n8.left = n7;
        n4.left = n3;
        n4.right = n5;
        n1.parent = n2;
        n4.parent = n2;
        n3.parent = n4;
        n5.parent = n4;
        n7.parent = n8;
        n2.parent = n6;
        n8.parent = n6;

        System.out.println(o.nextSuccessor(n1).val);
        System.out.println(o.nextSuccessor(n2).val);
        System.out.println(o.nextSuccessor(n3).val);
        System.out.println(o.nextSuccessor(n4).val);
        System.out.println(o.nextSuccessor(n5).val);
        System.out.println(o.nextSuccessor(n6).val);
        System.out.println(o.nextSuccessor(n7).val);
        System.out.println(o.nextSuccessor(n8));
    }

    TreeNode nextSuccessor(TreeNode root) {
        if (root.right != null) {
            return mostLeftNode(root.right);
        } else {
            return parentHavingLeft(root);
        }
    }

    TreeNode parentHavingLeft(TreeNode root) {
        if (root == null) return null;
        TreeNode p = root.parent;
        TreeNode q = root;
        while (p != null && p.left != q) {
            q = p;
            p = p.parent;
        }
        return p;
    }

    TreeNode mostLeftNode(TreeNode root) {
        if (root == null) return null;
        TreeNode parent = root;
        TreeNode curr = parent.left;
        while (curr != null) {
            parent = curr;
            curr = curr.left;
        }
        return parent;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
