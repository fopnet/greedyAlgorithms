
package greedyAlgorithms.Dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Dijkstra's Algorithm is an algorithm for finding the shortest path between
 * nodes in a graph Time Complexity: O(|V|^2)
 * 
 * Dijkstra’s algorithm is a Greedy algorithm and time complexity is O(VLogV)
 * (with the use of Fibonacci heap). Dijkstra doesn’t work for Graphs with
 * negative weight edges, Bellman-Ford works for such graphs.
 * 
 * Bellman-Ford is also simpler than Dijkstra and suites well for distributed
 * systems. But time complexity of Bellman-Ford is O(VE), which is more than
 * Dijkstra.
 */
public class Dijkstra {

    private final List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;

    public Dijkstra(final Graph graph) {
        new ArrayList<Vertex>(graph.getVertexes());
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }

    public void execute(final Vertex source) {
        settledNodes = new HashSet<Vertex>();
        unSettledNodes = new HashSet<Vertex>();
        distance = new HashMap<Vertex, Integer>();
        predecessors = new HashMap<Vertex, Vertex>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            final Vertex node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(final Vertex node) {
        final List<Vertex> adjacentNodes = getNeighbors(node);
        for (final Vertex target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private int getDistance(final Vertex node, final Vertex target) {
        for (final Edge edge : edges) {
            if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(final Vertex node) {
        final List<Vertex> neighbors = new ArrayList<Vertex>();
        for (final Edge edge : edges) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(final Set<Vertex> vertexes) {
        Vertex minimum = null;
        for (final Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(final Vertex vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(final Vertex destination) {
        final Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and NULL
     * if no path exists
     */
    public LinkedList<Vertex> getPath(final Vertex target) {
        final LinkedList<Vertex> path = new LinkedList<Vertex>();
        Vertex step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

}