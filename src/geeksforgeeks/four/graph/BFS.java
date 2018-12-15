package geeksforgeeks.four.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class BFS {

    public static void main(String[] args) {

        Graph g = new Graph();
        g.addNode(new Node(0));
        g.addNode(new Node(1));
        g.addNode(new Node(2));
        g.addNode(new Node(3));

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);  // 2 0 3 1  or 2 0 1 3
    }

    static class Node {
        List<Node> neighbors = new LinkedList<>();
        int data;

        Node(int data) {
            this.data = data;
        }

        public int hashCode() {
            return Objects.hash(data);
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Node)) return false;
            Node n = (Node) o;
            return n.data == this.data;
        }

        public String toString() {
            return "node: " + data;
        }
    }

    static class Graph {

        Map<Integer, Node> nodes = new HashMap<>();

        void addEdge(int u, int v) {
            nodes.get(u).neighbors.add(nodes.get(v));
            nodes.get(v).neighbors.add(nodes.get(u));
        }

        void addNode(Node n) {
            nodes.put(n.data, n);
        }

        void BFS(int start) {
            Queue<Node> q = new LinkedList<>();
            Set<Node> visited = new HashSet<>();

            Node n = nodes.get(start);
            q.add(n);
            visited.add(n);

            while (!q.isEmpty()) {
                Node u = q.remove();
                System.out.println("node: " + u.data);

                for (Node v : u.neighbors) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        q.add(v);
                    }
                }
            }
        }
    }

}


