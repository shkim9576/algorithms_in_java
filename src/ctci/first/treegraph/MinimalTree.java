package ctci.first.treegraph;

public class MinimalTree {

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 10, 15, 20};

        MinimalTree ob = new MinimalTree();
        Node result = ob.build(A, 0, A.length - 1);
        System.out.println(result);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    Node build(int[] A, int l, int r) {
        if (l <= r) {
            int m = l + (r - l) / 2;
            Node n = new Node(A[m]);
            n.left = build(A, l, m - 1);
            n.right = build(A, m + 1, r);
            return n;
        }
        return null;
    }
}
