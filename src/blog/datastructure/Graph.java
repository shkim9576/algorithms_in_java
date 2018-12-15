package blog.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

    HashMap<GraphNode, LinkedList<GraphNode>> adjList = new HashMap<>();

    public static void main(String[] args) {
        Graph graph = new Graph();

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node2, node4);
        graph.addEdge(node3, node4);

        graph.printGraph();
    }

    public void addEdge(GraphNode from, GraphNode to) {
        if (adjList.get(from) == null) {
            adjList.put(from, new LinkedList<>());
        }

        adjList.get(from).add(to);
    }

    public void printGraph() {

        for (Map.Entry<GraphNode, LinkedList<GraphNode>> entry : adjList.entrySet()) {

            GraphNode node = entry.getKey();
            LinkedList<GraphNode> list = entry.getValue();

            System.out.print("node" + node.data + ": ");

            for (int i = 0; i < list.size(); i++) {

                System.out.print(list.get(i).data);

                if (i != list.size() - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        }
    }
}


