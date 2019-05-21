package dsalg.two.graph;

import java.util.HashSet;
import java.util.Set;

public class CountPath {

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int s = 2, d = 3;
        System.out.println(g.countPath(s, d, new HashSet<>(), ""));
    }

    static class Graph {
        boolean[][] adj;
        int V = 0;

        Graph(int v) {
            this.V = v;
            adj = new boolean[v][v];
        }

        void addEdge(int u, int v) {
            adj[u][v] = true;
        }

        int count = 0;

        int countPath(int s, int t, Set<Integer> visited, String path) {
            if (s == t) {
                count++;
                System.out.println(path + t);
            } else {
                visited.add(s);
                for (int i = 0; i < this.V; i++) {
                    if (!visited.contains(i) && adj[s][i]) {
                        countPath(i, t, visited, path + s + " ");
                    }
                }
                visited.remove(s);
            }
            return count;
        }
    }
}
