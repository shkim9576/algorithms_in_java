package g4g.algorithm.greedy;

public class DijkstraShortestPath {
    // https://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
    public static void main(String[] args) {
        /* output
        Vertex   Distance from Source
            0                0
            1                4
            2                12
            3                19
            4                21
            5                11
            6                9
            7                8
            8                14
         */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                    {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                    {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                    {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                    {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                    {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                    {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                    {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                    {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        DijkstraShortestPath ob = new DijkstraShortestPath();
        ob.shortestPath(graph, 0);
    }

    void shortestPath(int[][] graph, int start) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        for (int i = 0; i < V - 1; i++) {
            int u = findMin(dist, visited);
            visited[u] = true;

            // update key values
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && graph[u][v] + dist[u] < dist[v]) {
                    dist[v] = graph[u][v] + dist[u];
                    parent[v] = u;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) System.out.println(i + "-" + parent[i] + " : " + dist[i]);
    }

    int findMin(int[] keys, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < keys.length; i++) {
            if (!visited[i] && keys[i] < min) {
                min = keys[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

}
