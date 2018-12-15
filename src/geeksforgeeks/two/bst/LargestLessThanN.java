package geeksforgeeks.two.bst;

public class LargestLessThanN {

    public static void main(String[] args) {
            /*
                  5
               /   \
             2     12
           /  \    /  \
          1   3   9   21
                     /   \
                    19   25  */
        Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(12);
        root.right.left = new Node(9);
        root.right.right = new Node(21);
        root.right.right.right = new Node(25);
        root.right.right.left = new Node(19);

        LargestLessThanN ob = new LargestLessThanN();
        int res = ob.largestLessThan(root, 4);
        System.out.println(res); // 3
    }

    static class Node {
        int data;
        Node left, right;

        Node (int d) {
            data = d;
        }
    }

    static class IntWrapper {
        int data;
    }

    int largestLessThan(Node root, int k) {

        IntWrapper res = new IntWrapper();
        reverseInorder(root, k, res);
        return res.data;
    }

    void reverseInorder(Node root, int k, IntWrapper res) {
        if (root != null) {
            reverseInorder(root.right, k, res);
            if (root.data <= k && res.data == 0) {
                res.data = root.data;
                return;
            }
            reverseInorder(root.left, k, res);
        }
    }
}
