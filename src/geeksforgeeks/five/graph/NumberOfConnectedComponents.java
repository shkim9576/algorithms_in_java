package geeksforgeeks.five.graph;

import java.util.*;

//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class NumberOfConnectedComponents {

    public static void main(String[] args) {
        NumberOfConnectedComponents o = new NumberOfConnectedComponents();
        int ans = o.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
        System.out.println(ans);
    }

    public int countComponents(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, graph, visited);
                ans++;
            }
        }
        return ans;
    }

    void dfs(int root, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        visited.add(root);
        if (graph.get(root) != null) {
            for (int n : graph.get(root)) {
                if (!visited.contains(n)) dfs(n, graph, visited);
            }
        }
    }

    Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<>());
            if (!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
}
