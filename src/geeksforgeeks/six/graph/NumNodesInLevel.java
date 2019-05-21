package geeksforgeeks.six.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumNodesInLevel {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);

        int level = 2;


        System.out.println(" ans: " + g.numNodes(0, level, new HashSet<>()));

    }

    static class Graph {
        LinkedList<Integer> adj[];
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


        int numNodes(int s, int level, Set<Integer> visited) {
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            visited.add(s);
            int l = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                if (l++ == level) return size;

                for (int i = 0; i < size; i++) {
                    int n = q.remove();
                    visited.add(n);
                    System.out.print(n + " ");

                    for (int c : adj[n]) {
                        if (!visited.contains(c)) q.add(c);
                    }
                }
            }

            return -1;
        }

    }
}
