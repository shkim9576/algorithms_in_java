package geeksforgeeks.six.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class TraversalIterative {

    public static void main(String[] args) {
        // Total 5 vertices in graph
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        System.out.println("Following is the Depth First Traversal");
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            if (!visited.contains(i)) g.dfsItr(i, visited);
        }

    }

    static class Graph {
        LinkedList<Integer>[] adj;
        int V = 0;

        Graph(int v) {
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
            this.V = v;
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
        }

        void dfsItr(int s, Set<Integer> visited) {
            Stack<Integer> stack = new Stack<>();
            stack.push(s);
            while (!stack.isEmpty()) {
                int i = stack.pop();
                visited.add(i);
                System.out.print(i + " ");

                for (int c : adj[i]) {
                    if (!visited.contains(c)) stack.push(c);
                }
            }
        }
    }
}
