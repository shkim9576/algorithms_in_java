package ctci.first.treegraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuildOrder {

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};

        BuildOrder ob = new BuildOrder();
        Graph graph = ob.buildGraph(projects, dependencies);
        String[] result = ob.sort(graph);
        System.out.println(Arrays.toString(result)); // f e a b d c
    }


    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String p : projects) graph.addNode(p);
        for (String[] d : dependencies) graph.addEdge(d);
        return graph;
    }

    String[] sort(Graph graph) {
        String[] result = new String[graph.nodeMap.size()];
        Set<String> processed = new HashSet<>();
        Set<String> toBeProcessed = new HashSet<>();

        for (String node : graph.nodeMap.keySet()) toBeProcessed.add(node);

        int index = 0;
        for (String node : graph.nodeMap.keySet()) {
            // has no dependency
            if (!graph.edgeMap.containsKey(node) && toBeProcessed.contains(node)) {
                result[index++] = node;
                processed.add(node);
                toBeProcessed.remove(node);
            }
        }

        while (toBeProcessed.size() > 0) {
            for (String node : graph.nodeMap.keySet()) {
                // its dependency has processed
                if (processed.contains(graph.edgeMap.get(node)) && toBeProcessed.contains(node)) {
                    result[index++] = node;
                    processed.add(node);
                    toBeProcessed.remove(node);
                }
            }
        }

        return result;
    }


    static class Project {
        String name;
        List<Project> neighbors = new ArrayList<>();

        Project(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    // project is NODE and dependency is EDGE
    static class Graph {
        Map<String, Project> nodeMap = new HashMap<>(); // <node_name : node_object>
        Map<String, String> edgeMap = new HashMap<>();  // <start_edge_name : end_edge_name>

        void addNode(String name) {
            Project project = new Project(name);
            nodeMap.put(name, project);
        }

        void addEdge(String[] edge) {
            Project start = nodeMap.get(edge[0]);
            Project end = nodeMap.get(edge[1]);
            start.neighbors.add(end);
            edgeMap.put(edge[1], edge[0]); // reverse direction. edge[1] depends on edge[0]
        }

    }
}
