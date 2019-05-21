package dsalg.two.graph;

import java.util.HashSet;
import java.util.Set;

public class HasPath {

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
        g.addEdge(1, 3);

        boolean ans = g.hasPath(0, 4, new HashSet<>());
        System.out.println(ans);
    }

    static class Graph {
        boolean[][] adj;
        int V;

        Graph(int v) {
            this.V = v;
            adj = new boolean[v][v];
        }

        void addEdge(int u, int v) {
            adj[u][v] = true;
        }

        boolean hasPath(int s, int d, Set<Integer> visited) {
            if (s == d) return true;

            visited.add(s);

            for (int i = 0; i < this.V; i++) {
                if (adj[s][i] && !visited.contains(i)) {
                    boolean found = hasPath(i, d, visited);
                    if (found) return true;
                }
            }

            return false;
        }
    }
}
