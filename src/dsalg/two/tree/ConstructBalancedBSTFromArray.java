package dsalg.two.tree;

public class ConstructBalancedBSTFromArray {

    public static void main(String[] args) {
        ConstructBalancedBSTFromArray tree = new ConstructBalancedBSTFromArray();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        Node root = tree.sortedArrayToBST(arr);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
    }

    Node sortedArrayToBST(int[] A) {
        return buildRec(A, 0, A.length - 1);
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    Node buildRec(int[] A, int s, int e) {
        if (s > e) return null;

        int m = (s + e) / 2;
        Node root = new Node(A[m]);
        root.left = buildRec(A, s, m - 1);
        root.right = buildRec(A, m + 1, e);

        return root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }
}
