package ctci.second.TreeAndGraph;

import java.util.*;

public class RouteBetweenNodes {

    public static void main(String[] args) {
        RouteBetweenNodes o = new RouteBetweenNodes();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n3.neighbors.add(n5);
        n3.neighbors.add(n6);
        n2.neighbors.add(n3); //cycle
        n4.neighbors.add(n1);

        System.out.println(o.hasRouteBFS(n1, n6)); //true
        System.out.println(o.hasRouteBFS(n1, n4)); //false

        System.out.println(o.hasRouteDFS(n1, n6)); //true
        System.out.println(o.hasRouteDFS(n1, n4)); //false

        System.out.println(o.hasRouteDFSItr(n1, n6)); //true
        System.out.println(o.hasRouteDFSItr(n1, n4)); //false
    }

    private boolean hasRouteDFSItr(Node src, Node dest) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(src);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            if (n.val == dest.val) return true;
            visited.add(n);
            for (Node nei : n.neighbors) {
                if (!visited.contains(nei)) {
                    stack.push(nei);
                }
            }
        }
        return false;
    }

    private boolean hasRouteDFS(Node src, Node dest) {
        return dfsRec(src, dest, new HashSet<>());
    }

    private boolean dfsRec(Node src, Node dest, Set<Node> visited) {
        if (src.val == dest.val) return true;
        visited.add(src);
        for (Node nei : src.neighbors) {
            if (!visited.contains(nei)) {
                boolean found = dfsRec(nei, dest, visited);
                if (found) return true;
            }
        }
        return false;
    }

    private boolean hasRouteBFS(Node src, Node dest) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.val == dest.val) return true;
            visited.add(n);
            for (Node nei : n.neighbors) {
                if (!visited.contains(nei)) q.add(nei);
            }
        }

        return false;
    }

    static class Node {
        int val;
        List<Node> neighbors = new ArrayList<>();

        Node(int val) {
            this.val = val;
        }
    }
}
