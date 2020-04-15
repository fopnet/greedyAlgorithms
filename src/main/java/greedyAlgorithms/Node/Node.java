package greedyAlgorithms.Node;

import java.util.Comparator;

// Class to represent a node in the graph 
public class Node implements Comparable<Node>, Comparator<Node> {
    public int node;
    public int cost;
    public boolean visited;
    public int level;

    public Node() {
        this.visited = false;
        this.level = 0;
    }

    public Node(int node, int cost) {
        this();
        this.node = node;
        this.cost = cost;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public int getWeight() {
        return this.level * this.cost;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        Node e = (Node) o;
        return (this.node == e.node);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + this.node;
        return result;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.node < node2.node)
            return -1;
        if (node1.node > node2.node)
            return 1;
        return 0;
        // if (node1.cost < node2.cost)
        // return -1;
        // if (node1.cost > node2.cost)
        // return 1;
        // return 0;
    }

    @Override
    public int compareTo(Node o) {
        return this.compare(this, o);
    }
}
