package geeksforgeeks.six.tree;

public class EvaluateExpressionTree {

    public static void main(String[] args) {
        {
            EvaluateExpressionTree o = new EvaluateExpressionTree();

            // create a syntax tree  
            Node root = new Node("+");
            root.left = new Node("*");
            root.left.left = new Node("5");
            root.left.right = new Node("4");
            root.right = new Node("-");
            root.right.left = new Node("100");
            root.right.right = new Node("20");
            System.out.println(o.evaluate(root));

            root = new Node("+");
            root.left = new Node("*");
            root.left.left = new Node("5");
            root.left.right = new Node("4");
            root.right = new Node("-");
            root.right.left = new Node("100");
            root.right.right = new Node("/");
            root.right.right.left = new Node("20");
            root.right.right.right = new Node("2");

            System.out.println(o.evaluate(root));
        }
    }

    int evaluate(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return Integer.valueOf(root.data);

        int l = evaluate(root.left);
        int r = evaluate(root.right);

        switch (root.data) {
            case "+":
                return l + r;
            case "-":
                return l - r;
            case "*":
                return l * r;
            case "/":
                return l / r;
        }

        return 0;
    }

    static class Node {
        String data;
        Node left;
        Node right;

        Node(String d) {
            this.data = d;
        }
    }
}
