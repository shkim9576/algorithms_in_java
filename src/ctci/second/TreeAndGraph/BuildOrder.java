package ctci.second.TreeAndGraph;

import java.util.*;

public class BuildOrder {

    public static void main(String[] args) {
        BuildOrder o = new BuildOrder();

        int[][] edges = {{5, 2}, {2, 3}, {3, 1}, {5, 0}, {4, 0}, {4, 1}, {10, 11}};

        List<Integer> ans = o.topologicalSortBFS(edges, 8);
        System.out.println(ans);
    }

    private List<Integer> topologicalSortBFS(int[][] edges, int N) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        // build inDegree and graph
        for (int[] edge : edges) {
            inDegree.put(edge[1], inDegree.getOrDefault(edge[1], 0) + 1);
            inDegree.putIfAbsent(edge[0], 0);

            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }

        // add zero indegree nodes to queue
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) q.add(entry.getKey());
        }

        while (!q.isEmpty()) {
            int n = q.remove();
            ans.add(n);
            for (int nei : graph.get(n)) {
                // remove incoming edges
                inDegree.put(nei, inDegree.get(nei) - 1);
                if (inDegree.get(nei) == 0) q.add(nei);
            }
        }

        if (ans.size() != N) {
            System.out.println("can't build topological sort");
        }

        return ans;
    }
}
