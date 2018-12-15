package blog.datastructure;

public class GraphNode {
    int data;

    public GraphNode(int data) {
        this.data = data;
    }

    public int hashCode() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GraphNode)) return false;

        GraphNode node = (GraphNode) obj;
        return node.data == this.data;
    }
}