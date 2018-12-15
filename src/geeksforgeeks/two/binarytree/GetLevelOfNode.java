package geeksforgeeks.two.binarytree;

public class GetLevelOfNode {

    Node root;

    public static void main(String[] args) {
        GetLevelOfNode tree = new GetLevelOfNode();

        /* Constructing tree given in the above figure */
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);


        /*
         Level of 1 is 3
         Level of 2 is 2
         Level of 3 is 1
         Level of 4 is 3
         Level of 5 is 2
         */
        for (int x = 1; x <= 5; x++) {
            int level = tree.getLevel(tree.root, x);
            if (level != 0)
                System.out.println("Level of " + x + " is "
                                   + tree.getLevel(tree.root, x));
            else
                System.out.println(x + " is not present in tree");
        }
    }

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    int getLevel(Node root, int key) {
        if (root == null) return -1;

        return getAllLevels(root, key, 1);
    }

    int getAllLevels(Node node, int data, int level) {
        if (node == null)
            return 0;

        if (node.data == data)
            return level;

        int downlevel = getAllLevels(node.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getAllLevels(node.right, data, level + 1);
        return downlevel;
    }
}
