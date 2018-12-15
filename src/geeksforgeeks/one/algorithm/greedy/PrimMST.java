package geeksforgeeks.one.algorithm.greedy;

public class PrimMST {
    // https://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/

    public static void main(String[] args) {
        PrimMST ob = new PrimMST();

        /* Let us create the following geeksforgeeks.g4g1st.one.graph
           2	3
        (0)--(1)--(2)
         |   / \   |
        6| 8/   \5 |7
         | /     \ |
        (3)-------(4)
             9
         */

        /* output
            Edge   Weight
            0 - 1    2
            1 - 2    3
            0 - 3    6
            1 - 4    5
        */
        int graph[][] = new int[][]{{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0}};

        ob.primMST(graph);
    }

    void primMST(int[][] graph) {
        int V = graph.length;
        int[] parent = new int[V];  // vertices in MST
        int[] keys = new int[V];  // vertex key
        boolean mstSet[] = new boolean[V]; // true if NOT included in MST

        for (int i = 0; i < V; i++) keys[i] = Integer.MAX_VALUE;

        keys[0] = 0; // first vertex is picked first
        parent[0] = -1; // first node is always root (-1) or MST

        // MST has V vertices
        for (int i = 0; i < V - 1; i++) {
            // pick min key vertex that is not in MST yet
            int u = minKey(keys, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                // geeksforgeeks.g4g1st.one.graph[u][v] is non zero only for adjacent vertices.
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if geeksforgeeks.g4g1st.one.graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < keys[v]) {
                    parent[v] = u;
                    keys[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph, V);
    }

    void printMST(int[] parent, int[][] graph, int V) {
        for (int i = 1; i < V; i++) System.out.println(parent[i] + "-" + i + " " + graph[i][parent[i]]);
    }

    int minKey(int keys[], boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && keys[v] < min) {
                min = keys[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

}
