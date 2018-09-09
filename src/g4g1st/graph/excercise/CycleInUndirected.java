package g4g1st.graph.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CycleInUndirected {
    // https://www.geeksforgeeks.org/detect-cycle-undirected-graph/

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(3);
        g.addNode(5);
        g.addNode(7);
        g.addNode(9);
        g.addNode(100);

        // g.addEdge(100,100); // a cycle
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(5, 7);
        g.addEdge(5, 9);
        g.addEdge(9, 1); // a cycle

        System.out.println("-- GRAPH --");
        System.out.println(g);

        System.out.println(g.hasCycle());
    }

    static class Graph {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        void addNode(int node) {
            graph.put(node, new LinkedList<>());
        }

        void addEdge(int src, int dest) {
            graph.get(src).add(dest);
            graph.get(dest).add(src); // add both direction since it is undirected g4g1st.graph.
        }

        public String toString() {
            return graph.toString();
        }

        boolean hasCycle() {

            List<Integer> visited = new ArrayList<>();

            for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()) {
                int node = e.getKey();
                if (!visited.contains(node)) {
                    if (hasCycle(node, visited, -1)) return true;
                }
            }

            return false;
        }

        boolean hasCycle(int node, List<Integer> visited, int parent) {
            visited.add(node);
            List<Integer> adjacents = graph.get(node);

            for (int a : adjacents) {
                if (!visited.contains(a)) {
                    if (hasCycle(a, visited, node)) return true;
                } else if (parent != a) {
                    return true;
                }
            }

            return false;
        }

    }

}
