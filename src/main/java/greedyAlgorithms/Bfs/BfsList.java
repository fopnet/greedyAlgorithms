
package greedyAlgorithms.Bfs;

import java.util.*;

import greedyAlgorithms.Node.Node;

/**
 * Breadth First Search is a graph traversal algorithm which explores the
 * neighbor nodes first, before moving to the next level neighbors Time
 * 
 * Topological Sort Topological Sort is the linear ordering of a directed
 * graph's nodes such that for every edge from node u to node v, u comes before
 * v in the ordering Time Complexity: O(|V| + |E|)
 * 
 * Complexity: O(|V| + |E|)
 */
class GraphList {
    private final List<Collection<Node>> adj;
    private final Map<Integer, Node> nodeMap;

    public GraphList(int n) {
        this.adj = new ArrayList<Collection<Node>>(n);
        while (adj.size() <= n - 1) {
            adj.add(new PriorityQueue<>());
            // adj.add(new ArrayList<>());
        }
        this.nodeMap = new HashMap<>();
    }

    Node getNode(int v) {
        return getNode(v, 6);
    }

    Node getNode(int v, int w) {
        Integer key = v - 1;
        Node node = this.nodeMap.get(key);
        if (node == null) {
            node = new Node(key, w);
            nodeMap.put(key, node);
        }

        return node;
    }

    public void addEdge(final int v, final int edge, final int w) {

        Node edgeNode = getNode(edge, w);
        getNode(v, w);

        this.adj.get(v - 1).add(edgeNode);
    }

    public void addBidirectionalEdge(final int v, final int edge, final int w) {
        this.addEdge(v, edge, w);
        this.addEdge(edge, v, w);
    }

    public void BFS(int s) {
        final boolean visited[] = new boolean[this.adj.size()];

        final Queue<Integer> queue = new LinkedList<>();

        visited[s - 1] = true;
        queue.add(s - 1);

        while (queue.size() > 0) {
            // dequeue value
            s = queue.poll();
            System.out.print((s + 1) + " ");

            Iterator<Node> it = this.adj.get(s).iterator();
            // Iterator<Node> it = this.adj.get(s).listIterator();
            while (it.hasNext()) {
                Node n = it.next();

                if (!visited[n.node]) {
                    queue.add(n.node);

                    visited[n.node] = true;
                }
            }
        }
    }

    public void ShortestReach(int s) {
        // final boolean visited[] = new boolean[this.adj.size()];
        final int weights[] = new int[this.adj.size()];

        final Queue<Node> queue = new LinkedList<>();

        // visited[s - 1] = true;
        Node v = this.getNode(s);
        queue.add(v);

        // int level = v.getLevel();

        while (!queue.isEmpty()) {
            // dequeue value
            v = queue.poll();
            // boolean isAddedLevel = false;

            // boolean visited[] = new boolean[this.adj.size()];
            // visited[v.node] = true;
            v.setVisited();

            // Iterator<Node> it = this.adj.get(s).listIterator();
            Iterator<Node> it = this.adj.get(v.node).iterator();
            while (it.hasNext()) {
                Node edge = it.next();

                // level = v.getLevel();

                // if (!visited[edge.node]) {
                if (!edge.isVisited()) {
                    // if (!isAddedLevel) {
                    // isAddedLevel = !isAddedLevel;
                    // level++;
                    // }

                    edge.setLevel(v.getLevel() + 1);
                    // weights[n.node] = level * n.cost;
                    weights[edge.node] = edge.getWeight();

                    // queue.add(edge.node);
                    queue.add(edge);

                    // visited[edge.node] = true;
                    edge.setVisited();
                }
            }
        }

        for (int i = 0; i < weights.length; i++) {
            if (i != s - 1) {
                System.out.print((weights[i] == 0 ? "-1" : weights[i]) + " ");
            }
        }
    }

}