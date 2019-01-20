package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/find-n-th-node-inorder-traversal/
public class FindNtoNodeInorder {

    //Input : n = 4
    //              10
    //            /   \
    //           20     30
    //         /   \
    //        40     50
    //Output : 10
    //Inorder Traversal is : 40 20 50 10 30
    //
    //Input :  n = 3
    //            7
    //          /   \
    //         2     3
    //             /   \
    //            8     5
    //Output : 8
    //Inorder: 2 7 8 3 5
    //3th node is 8

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        int n = 4;
        INT count = new INT(0);
        NthInorder(root, n, count);
        System.out.println(res);
    }

    static int res = 0;

    static void NthInorder(Node root, int n, INT count) {
        if (root != null) {
            NthInorder(root.left, n, count);
            count.data++;
            if (n == count.data) res = root.key;
            NthInorder(root.right, n, count);
        }
    }

    static class INT {
        int data;

        INT (int i) {
            this.data = i;
        }
    }
}
