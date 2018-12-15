package geeksforgeeks.four.graph;


import java.util.Arrays;

public class Dijkstra {

    public static void main(String[] args) {

        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                    {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                    {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                    {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                    {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                    {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                    {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                    {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                    {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Graph g = new Graph(graph);
        g.dijkstra(0);
    }

    static class Graph {
        int[][] graph;
        int V = 0;

        Graph(int[][] g) {
            this.graph = g;
            this.V = g.length;
        }

        void printGraph(int[] distances) {
            System.out.println("Vertex   Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t\t " + distances[i]);
        }

        int minDistance(int[] distances, boolean[] visited) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int v = 0; v < V; v++) {
                if (!visited[v] && distances[v] < min) {
                    min = distances[v];
                    index = v;
                }
            }
            return index;
        }

        void dijkstra(int start) {
            int[] distances = new int[V];
            boolean[] visited = new boolean[V];

            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[start] = 0;

            // find shortest path for all nodes
            for (int n = 0; n < V - 1; n++) {
                int u = minDistance(distances, visited);
                visited[u] = true;

                // update distance for all adjacent nodes of u.
                for (int v = 0; v < V; v++) {
                    if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + graph[u][v] < distances[v]) {
                        distances[v] = distances[u] + graph[u][v];
                    }
                }
            }

            printGraph(distances);
        }

    }

}

