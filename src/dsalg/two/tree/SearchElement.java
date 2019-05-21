package dsalg.two.tree;

public class SearchElement {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        SearchElement o = new SearchElement();
        System.out.println(o.search(root, 3));
        System.out.println(o.search(root, 8));
    }

    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return search(root.left, key) || search(root.right, key);
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
