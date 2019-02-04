package geeksforgeeks.five.graph;

import java.util.*;

//https://www.geeksforgeeks.org/graph-and-its-representations/
//https://www.geeksforgeeks.org/graph-representations-using-set-hash/
public class Graph {

    /*
    0 -- 1 -- 2
    |  / |  /
    | /  | /
    4 -- 3
     */

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(4, 3);

        g.printGraph(0);
        System.out.println("BFS:");
        g.bfs(0);
        System.out.println();
        System.out.println("DFS:");
        g.dfs(0, new HashSet<>());
        System.out.println();
        System.out.println("DFS Itr:");
        g.dfsItr(0);

    }

    Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

    void addEdge(int u, int v) {
        LinkedList<Integer> edges = graph.getOrDefault(u, new LinkedList<>());
        edges.add(v);
        graph.put(u, edges);
    }

    void printGraph(int root) {
        System.out.println(graph);
    }

    void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(root);
        visited.add(root);

        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.printf("%1d ", node);
            for (int c : graph.get(node)) {
                if (!visited.contains(c)) {
                    q.add(c);
                    visited.add(c);
                }
            }
        }
    }

    void dfs(int root, HashSet<Integer> visited) {
        visited.add(root);
        System.out.printf("%1d ", root);

        for (int c : graph.get(root)) {
            if (!visited.contains(c)) {
                dfs(c, visited);
            }
        }
    }

    void dfsItr(int root) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        visited.add(root);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.printf("%1d ", node);
            for (int c : graph.get(node)) {
                if (!visited.contains(c)) {
                    stack.push(c);
                    visited.add(c);
                }
            }

        }


    }
}
