package g4g1st.graph.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IsValidTree {


    public static void main(String[] args) {
        IsValidTree ob = new IsValidTree();

        int[] e1 = new int[] {0,1};
        int[] e2 = new int[] {1,2};
        int[] e3 = new int[] {2,3};
        int[] e4 = new int[] {0,4};

        int[][] edges = new int[][] {e1, e2, e3, e4};

        System.out.println(ob.isValidTreeDFS(5, edges));
        System.out.println(ob.isValidTreeBFS(5, edges));
    }

    boolean isValidTreeBFS(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int top = q.remove();
            if(visited[top]) return false;

            visited[top] = true;

            for(int i: map.get(top)) {
                if(!visited[i]) q.add(i);
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }


    boolean isValidTreeDFS(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        if(!helper(0, -1, map, visited)) return false;

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    boolean helper(int curr, int parent, Map<Integer, ArrayList<Integer>> map, boolean[] visited) {
        if (visited[curr]) return false;

        visited[curr] = true;

        for (int n : map.get(curr)) {
            if (parent != n && !helper(n, curr, map, visited)) return false;
        }

        return true;
    }

}
