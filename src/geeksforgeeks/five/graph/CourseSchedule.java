package geeksforgeeks.five.graph;

import java.util.*;

//https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/369/discuss/58669/Concise-JAVA-solutions-based-on-BFS-and-DFS-with-explanation
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule o = new CourseSchedule();
        // should take 12 first before 11. {11,12}
        // 11 12 13 10
        int[][] pre = {{11, 10}, {13, 10}, {11, 12}};
        System.out.println(o.canFinish(4, pre));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;

        Map<Integer, List<Integer>> G = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int[] pre : prerequisites) {
            int child = pre[0];
            int parent = pre[1];

            if (!G.containsKey(parent)) G.put(parent, new ArrayList());
            if (!G.containsKey(child)) G.put(child, new ArrayList());

            List<Integer> list = G.get(parent);
            list.add(child);
            G.put(parent, list);

            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i : G.keySet()) {
            if (!inDegree.containsKey(i) || inDegree.get(i) == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.printf("%d ", node);
            count++;

            for (int c : G.get(node)) {
                inDegree.put(c, inDegree.get(c) - 1);
                if (inDegree.get(c) == 0) q.add(c);
            }
        }

        return count == G.size();
    }
}
