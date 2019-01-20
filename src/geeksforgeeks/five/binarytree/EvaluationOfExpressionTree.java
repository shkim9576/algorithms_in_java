package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/evaluation-of-expression-tree/
public class EvaluationOfExpressionTree {

    public static void main(String[] args) {
        Node root = new Node("+");
        root.left = new Node("*");
        root.right = new Node("-");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right.left = new Node("100");
        root.right.right = new Node("20");
        System.out.println(evaluate(root)); //100

        root = new Node("+");
        root.left = new Node("*");
        root.right = new Node("-");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right.left = new Node("100");
        root.right.right = new Node("/");
        root.right.right.right = new Node("2");
        root.right.right.left = new Node("20");
        System.out.println(evaluate(root)); //110
    }

    static int evaluate(Node root) {
        if (root == null) return 0;

        if (isOperator(root.key)) {
            int l = evaluate(root.left);
            int r = evaluate(root.right);

            if (root.key == "+") return l + r;
            if (root.key == "-") return l - r;
            if (root.key == "*") return l * r;
            if (root.key == "/") return l / r;
        }

        return Integer.valueOf(root.key);
    }

    static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    static class Node {
        String key;
        Node left, right;

        Node(String k) {
            this.key = k;
        }
    }
}
