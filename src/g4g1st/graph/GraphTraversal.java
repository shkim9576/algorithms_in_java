package g4g1st.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphTraversal {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(3);
        g.addNode(5);
        g.addNode(7);
        g.addNode(9);
        g.addNode(100);
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(5, 7);
        g.addEdge(5, 9);
        g.addEdge(3, 9);

        System.out.println("-- GRAPH --");
        System.out.println(g);

        System.out.println("-- BFS --");
        g.bfs(1);
        System.out.println("");

        System.out.println("-- DFS --");
        g.dfs(1);
        System.out.println("");

        System.out.println("-- DFS w disconnected nodes --");
        g.dfsIncludingDisconnected();
        System.out.println("");

        System.out.println("-- DFS Ite --");
        g.dfsItr(1);
    }

    static class Graph {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        void addNode(int node) {
            graph.put(node, new LinkedList<>());
        }

        void addEdge(int src, int dest) {
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        public String toString() {
            return graph.toString();
        }

        void dfsIncludingDisconnected() {
            List<Integer> visited = new ArrayList<>();
            Set<Integer> nodes = graph.keySet();
            for (int n : nodes) {
                if (!visited.contains(n)) dfs(n, visited);
            }

        }

        void dfsItr(int node) {

            List<Integer> visited = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(node);
            visited.add(node);

            while (!stack.isEmpty()) {
                int n = stack.pop();
                System.out.print(n + " ");

                List<Integer> adjacents = graph.get(n);

                for (int a : adjacents) {
                    if (!visited.contains(a)) {
                        stack.push(a);
                        visited.add(a);
                    }
                }
            }
        }

        void dfs(int node) {
            List<Integer> visited = new ArrayList<>();
            dfs(node, visited);
        }

        void dfs(int node, List<Integer> visited) {
            visited.add(node);
            System.out.print(node + " ");

            List<Integer> adjacents = graph.get(node);

            for (int a : adjacents) {
                if (!visited.contains(a)) {
                    dfs(a, visited);
                }
            }
        }

        void bfs(int node) {

            List<Integer> visited = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            visited.add(node);

            while (!q.isEmpty()) {
                int n = q.remove();
                System.out.print(n + " ");

                List<Integer> adjacents = graph.get(n);
                for (int a : adjacents) {
                    if (!visited.contains(a)) {
                        q.add(a);
                        visited.add(a);
                    }
                }
            }
        }
    }
}
