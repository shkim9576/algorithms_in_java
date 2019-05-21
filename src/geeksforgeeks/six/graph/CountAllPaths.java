package geeksforgeeks.six.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CountAllPaths {

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int s = 2, d = 3;
        System.out.println(g.countPaths(s, d, new HashSet<>(), ""));
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


        int count = 0;

        int countPaths(int s, int e, Set<Integer> visited, String path) {
            if (s == e) {
                count++;
                System.out.println(path + e);
            } else {
                visited.add(s);
                path += s + " ";

                for (int c : adj[s]) {
                    if (!visited.contains(c)) countPaths(c, e, visited, path);
                }
                visited.remove(s);
            }
            return count;
        }
    }
}
