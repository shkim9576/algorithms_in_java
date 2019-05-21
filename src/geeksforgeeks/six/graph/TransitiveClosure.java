package geeksforgeeks.six.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class TransitiveClosure {

    public static void main(String[] args) {

        // Create a graph given
        // in the above diagram
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure " +
                "matrix is");

        g.transitiveClosure();

        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(g.ans[i]));
        }
    }

    static class Graph {
        LinkedList<Integer>[] adj;
        boolean[][] ans;
        int V;

        Graph(int v) {
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
            this.V = v;
            ans = new boolean[v][v];
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
        }

        void transitiveClosure() {
            for (int i = 0; i < this.V; i++) {
                dfs(i, i);
            }
        }

        void dfs(int s, int v) {
            ans[s][v] = true;
            for (int n : adj[v]) {
                if (!ans[s][n]) dfs(s, n);
            }
        }
    }
}
