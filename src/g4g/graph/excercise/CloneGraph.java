package g4g.graph.excercise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class CloneGraph {
    // https://www.programcreek.com/2012/12/leetcode-clone-graph-java/

    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);

        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n1.neighbors.add(n5);
        n2.neighbors.add(n1);
        n2.neighbors.add(n4);
        n3.neighbors.add(n1);
        n3.neighbors.add(n4);
        n3.neighbors.add(n5);
        n4.neighbors.add(n2);
        n4.neighbors.add(n3);
        n4.neighbors.add(n5);
        n5.neighbors.add(n1);
        n5.neighbors.add(n3);
        n5.neighbors.add(n4);

        CloneGraph ob = new CloneGraph();
        System.out.println("--- Original Graph ---");
        ob.breadthFirstSearch(n3);

        GraphNode newNode = ob.clone(n3);
        System.out.println("--- Cloned Graph ---");
        ob.breadthFirstSearch(newNode);
    }

    static class GraphNode {
        int val;
        Set<GraphNode> neighbors = new TreeSet<>(new Comparator<GraphNode>() {
            @Override
            public int compare(GraphNode n1, GraphNode n2) {
                return n1.val - n2.val;
            }
        });
        boolean visited;

        GraphNode(int val) {
            this.val = val;
        }
    }

    public GraphNode clone(GraphNode node) {
        if (node == null) return null;

        Map<GraphNode, GraphNode> map = new HashMap<>();
        Queue<GraphNode> q = new LinkedList<>();

        GraphNode newNode = new GraphNode(node.val);
        q.add(node);
        map.put(node, newNode);

        while (!q.isEmpty()) {
            GraphNode curr = q.remove();
            Set<GraphNode> neighbors = curr.neighbors;

            for (GraphNode n : neighbors) {
                if (map.containsKey(n)) {
                    map.get(curr).neighbors.add(map.get(n));
                } else {
                    GraphNode copy = new GraphNode(n.val);
                    map.put(n, copy);
                    map.get(curr).neighbors.add(map.get(n));
                    q.add(n);
                }
            }
        }

        return newNode;
    }


    public void breadthFirstSearch(GraphNode root) {

        Queue<GraphNode> q = new LinkedList();
        root.visited = true;
        q.add(root);

        while (!q.isEmpty()) {
            GraphNode node = q.remove();
            System.out.println(node.val);

            for (GraphNode n : node.neighbors) {
                if (!n.visited) {
                    n.visited = true;
                    q.add(n);
                }
            }
        }
    }

}
