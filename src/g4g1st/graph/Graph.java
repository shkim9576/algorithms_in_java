package g4g1st.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    // https://www.programcreek.com/2012/11/top-10-algorithms-for-coding-interview/

    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);

        n1.neighbors = new GraphNode[] {n2,n3,n5};
        n2.neighbors = new GraphNode[] {n1,n4};
        n3.neighbors = new GraphNode[] {n1,n4,n5};
        n4.neighbors = new GraphNode[] {n2,n3,n5};
        n5.neighbors = new GraphNode[] {n1,n3,n4};

        Graph ob = new Graph();
        System.out.println(ob.breadthFirstSearch(n1, 3));
    }


    static class GraphNode {
        int val;
        GraphNode[] neighbors;
        boolean visited;

        GraphNode(int val) {
            this.val = val;
        }
    }

    public boolean breadthFirstSearch(GraphNode root, int x) {
        if (root.val == x) {
            System.out.println("found in root");
            return true;
        }

        Queue<GraphNode> q = new LinkedList();
        root.visited = true;
        q.add(root);

        while(!q.isEmpty()) {
            GraphNode node = q.remove();
            for (GraphNode n : node.neighbors) {
                if (!n.visited) {
                    if (n.val == x) return true;
                    n.visited = true;
                    q.add(n);
                }
            }
        }

        return false;
    }

}
