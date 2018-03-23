package ctci.treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Route {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        a.neighbors.add(b);
        a.neighbors.add(c);
        b.neighbors.add(d);
        d.neighbors.add(e);
        c.neighbors.add(e);
        f.neighbors.add(a);

        Route ob = new Route();
        System.out.println(ob.BFS(a, e));
        System.out.println(ob.BFS(a, f));

        Node a1 = new Node(1);
        Node b1 = new Node(2);
        Node c1 = new Node(3);
        Node d1 = new Node(4);
        Node e1 = new Node(5);
        Node f1 = new Node(6);
        a1.neighbors.add(b1);
        a1.neighbors.add(c1);
        b1.neighbors.add(d1);
        d1.neighbors.add(e1);
        c1.neighbors.add(e1);
        f1.neighbors.add(a1);

        System.out.println(ob.DFS(a1, e1));
        System.out.println(ob.DFS(a1, f1));
    }

    static class Node {
        int val;
        List<Node> neighbors = new ArrayList<>();
        boolean visited;

        Node(int val) {
            this.val = val;
        }
    }

    boolean BFS(Node src, Node dest) {
        if (src == null || dest == null) return false;
        if (src == dest) return true;

        Queue<Node> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            Node u = q.remove();
            for (Node v : u.neighbors) {
                if (v == dest) return true;
                if (!v.visited) {
                    q.add(v);
                    v.visited = true;
                }
            }
        }

        return false;
    }

    boolean DFS(Node src, Node dest) {
        if (src == dest) return true;

        src.visited = true;
        for (Node n : src.neighbors) {
            if (!n.visited) return DFS(n, dest);
        }

        return false;
    }
}
