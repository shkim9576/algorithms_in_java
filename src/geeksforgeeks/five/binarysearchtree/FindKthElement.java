package geeksforgeeks.five.binarysearchtree;

//https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
public class FindKthElement {

    public static void main(String args[]) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println(findKthElement(root, 3)); //10
    }

    static int result;
    static int count;

    static int findKthElement(Node root, int k) {
        inorder(root, k);
        return result;
    }

    static void inorder(Node root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        if (++count == k) {
            result = root.data;
            return;
        }
        inorder(root.right, k);
    }
}
