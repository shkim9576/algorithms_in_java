package geeksforgeeks.one.graph.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort {
    // https://www.geeksforgeeks.org/topological-sorting/

    public static void main(String[] args) {

        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addNode(5);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("-- GRAPH --");
        System.out.println(g);

        g.topologicalSort();  //5 4 2 3 1 0
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


        void topologicalSort() {

            List<Integer> visited = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for (Map.Entry<Integer, List<Integer>> e : graph.entrySet()) {
                int node = e.getKey();
                if (!visited.contains(node)) topologicalSort(node, visited, stack);
            }

            while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
        }

        void topologicalSort(int node, List<Integer> visited, Stack<Integer> stack) {
            visited.add(node);

            List<Integer> adjacents = graph.get(node);
            for (int a : adjacents) {
                if (!visited.contains(a)) topologicalSort(a, visited, stack);
            }

            stack.push(node);
        }
    }
}
