package geeksforgeeks.five.binarysearchtree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/find-pair-given-sum-bst/
public class FindPairGivenSum {

    //Pair is found (8, 25)
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(tree.root, 15);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 8);
        tree.insert(tree.root, 12);
        tree.insert(tree.root, 16);
        tree.insert(tree.root, 25);
        tree.insert(tree.root, 10);

        int sum = 33;
        int[] res = findPair(tree.root, sum);
        System.out.println(Arrays.toString(res));
    }

    static int[] findPair(Node root, int sum) {
        Set<Integer> set = new HashSet<>();
        return findPairPreorder(root, sum, set);
    }

    static int[] findPairPreorder(Node root, int sum, Set<Integer> set) {
        if (root == null) return null;

        if (set.contains(sum - root.data)) return new int[]{sum - root.data, root.data};
        else set.add(root.data);

        int[] l = findPairPreorder(root.left, sum, set);
        if (l != null) return l;

        return findPairPreorder(root.right, sum, set);
    }

    static int[] findPairInorder(Node root, int sum, Set<Integer> set) {
        if (root == null) return null;

        int[] l = findPairInorder(root.left, sum, set);
        if (l != null) return l;

        if (set.contains(sum - root.data)) return new int[]{sum - root.data, root.data};
        else set.add(root.data);

        return findPairInorder(root.right, sum, set);
    }

    static int[] findPairPostorder(Node root, int sum, Set<Integer> set) {
        if (root == null) return null;

        int[] l = findPairPostorder(root.left, sum, set);
        if (l != null) return l;

        int[] r = findPairPostorder(root.right, sum, set);

        if (set.contains(sum - root.data)) return new int[]{sum - root.data, root.data};
        else set.add(root.data);

        return r;
    }
}
