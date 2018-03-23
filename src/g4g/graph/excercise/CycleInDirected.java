package g4g.graph.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CycleInDirected {
    // https://www.geeksforgeeks.org/detect-cycle-in-a-graph/

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
        }

        public String toString() {
            return graph.toString();
        }

        boolean hasCycle() {
            List<Integer> visited = new ArrayList<>();

            // although it goes back to visited node, visited node may not have a way coming back.
            // e.g.  1->2, 1->3, 3->2 (2 is visited. but there is no direction 2->3)
            Set<Integer> recStack = new HashSet<>();

            for (Map.Entry<Integer,List<Integer>> e : graph.entrySet()) {
                if (hasCycle(e.getKey(), visited, recStack)) return true;
            }
            return false;
        }

        boolean hasCycle(int node, List<Integer> visited, Set<Integer> recStack) {
            if (!visited.contains(node)) {
                visited.add(node);
                recStack.add(node);

                List<Integer> adjacents = graph.get(node);

                for (int a : adjacents) {
                    if (!visited.contains(a) && hasCycle(a, visited, recStack)) return true;
                    else if (recStack.contains(a)) {
                        return true;
                    }
                }
            }

            recStack.remove(node);
            return false;
        }
    }

}
