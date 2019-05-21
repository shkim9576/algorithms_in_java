package geeksforgeeks.six.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Traversal {

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.bfs(2);
        System.out.println();
        g.dfs(2, new HashSet<>());
    }

    static class Graph {
        LinkedList<Integer>[] adj;

        Graph(int v) {
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
        }

        void dfs(int s, Set<Integer> visited) {
            if (!visited.contains(s)) {
                System.out.print(s + " ");
                visited.add(s);
                for (int c : adj[s]) {
                    dfs(c, visited);
                }
            }
        }

        void bfs(int s) {
            Set<Integer> visited = new HashSet<>();

            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            while (!q.isEmpty()) {
                int n = q.remove();
                System.out.print(n + " ");
                visited.add(n);

                for (int c : adj[n]) {
                    if (!visited.contains(c)) {
                        q.add(c);
                    }
                }
            }
        }
    }
}
