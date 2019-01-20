package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
public class RootToLeafPathSumEqualToGivenNumber {

    public static void main(String args[]) {
        int sum = 21; 
          
        /* Constructed binary tree is 
              10 
             /  \ 
           8     2 
          / \   / 
         3   5 2 
        */
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        if (haspathSum(root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }

    static boolean haspathSum(Node root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.key == sum) return true;
        return haspathSum(root.left, sum - root.key) || haspathSum(root.right, root.key);
    }
}
