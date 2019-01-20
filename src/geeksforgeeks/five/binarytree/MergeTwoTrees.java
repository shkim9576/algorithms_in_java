package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/merge-two-binary-trees-node-sum/
public class MergeTwoTrees {

    //The Merged Binary Tree is:
    //7 3 5 5 2 10 12
    public static void main(String[] args) {
         /* Let us construct the first Binary Tree 
                 1 
               /   \ 
              2     3 
             / \     \ 
            4   5     6 
         */

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.right = new Node(6); 
        
         /* Let us construct the second Binary Tree 
                4 
              /   \ 
             1     7 
            /     /  \ 
           3     2    6   */
        Node root2 = new Node(4);
        root2.left = new Node(1);
        root2.right = new Node(7);
        root2.left.left = new Node(3);
        root2.right.left = new Node(2);
        root2.right.right = new Node(6);

        Node root3 = mergeTrees(root1, root2);
        System.out.printf("The Merged Binary Tree is:\n");
        Utils.inorder(root3);
    }

    static Node mergeTrees(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        n1.key += n2.key;

        n1.left = mergeTrees(n1.left, n2.left);
        n1.right = mergeTrees(n1.right, n2.right);

        return n1;
    }
}
