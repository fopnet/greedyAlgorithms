package greedyAlgorithms.Dijkstra;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import greedyAlgorithms.Node.Node;

/**
 * Dijsktra Priority Queue
 */
public class DPQ {
    int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int V; // Number of vertices
    List<List<Node>> adj;
    private Map<Integer, Integer> predecessors;

    public DPQ(int V) {
        this.V = V;
        this.predecessors = new HashMap<>();
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    // Function for Dijkstra's Algorithm
    public DPQ dijkstra(List<List<Node>> adj, int src) {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        // Distance to the source is 0
        dist[src] = 0;
        while (settled.size() != V && !pq.isEmpty()) {

            // remove the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // adding the node whose distance is
            // finalized
            settled.add(u);

            e_Neighbours(u);
        }

        return this;
    }

    // Function to process all the neighbours
    // of the passed node
    private void e_Neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node edge = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(edge.node)) {
                edgeDistance = edge.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[edge.node]) {
                    dist[edge.node] = newDistance;
                    predecessors.put(edge.node, u);
                }

                // Add the current node to the queue
                pq.add(new Node(edge.node, dist[edge.node]));
            }
        }
    }

    public void printDistances(int source) {
        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < this.dist.length; i++)
            System.out.println(source + " to " + i + " is " + this.dist[i]);
    }

    public void printBFS(int source, int replaceFrom, int replaceTo) {
        for (int i = 0; i < this.dist.length; i++) {
            if (i == source)
                continue;
            if (dist[i] == replaceFrom)
                dist[i] = replaceTo;
            System.out.print(this.dist[i] + " ");
        }
        System.out.println();
    }

    public void printBFSLetters(int source, int replaceFrom, int replaceTo, int target) {
        int letterA = 65; // -> A

        char origin = (char) (letterA + source);
        List<Integer> path = this.getPath(target - 1);
        for (int i = 0; i < this.dist.length; i++) {
            if (i == source)
                continue;
            if (dist[i] == replaceFrom)
                dist[i] = replaceTo;

            char destiny = (char) (char) (letterA + i);
            if (i == target - 1) {
                for (Iterator<Integer> it = path.iterator(); it.hasNext();) {
                    destiny = (char) (letterA + it.next());

                    System.out.print(destiny);

                    if (it.hasNext())
                        System.out.print(" -> ");
                }
                System.out.println(" = " + this.dist[i]);
            } else
                System.out.println(origin + " -> " + destiny + " = " + this.dist[i] + " ");
        }
        System.out.println("============== next query  ");
        System.out.println();

    }

    /*
     * This method returns the path from the source to the selected target and NULL
     * if no path exists
     */
    public List<Integer> getPath(final Integer target) {
        final List<Integer> path = new LinkedList<Integer>();
        Integer step = target;
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

    public DPQ replaceInfiniteTo(int src, int target) {
        this.dist = Arrays.stream(this.dist).map(i -> (src == i ? target : i)).toArray();
        return this;
    }

}
