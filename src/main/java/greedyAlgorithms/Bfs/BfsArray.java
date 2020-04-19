
package greedyAlgorithms.Bfs;

import java.util.Iterator;
import java.util.LinkedList;

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
 class GraphArray {
    private final int V;
    private final LinkedList<Integer> adj[];

    public GraphArray(final int v) {
        this.V = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(final int v, final int w) {
        this.adj[v - 1].add(w - 1);
    }

    public void addBidirectionalEdge(final int v, final int w) {
        this.adj[v - 1].add(w - 1);
        this.adj[w - 1].add(v - 1);
    }

    public void BFS(int s) {
        final boolean visited[] = new boolean[V];

        final LinkedList<Integer> queue = new LinkedList<>();

        visited[s - 1] = true;
        queue.add(s - 1);

        while (queue.size() > 0) {
            // dequeue value
            s = queue.poll();
            System.out.print((s + 1) + " ");

            Iterator<Integer> it = this.adj[s].listIterator();
            while (it.hasNext()) {
                int n = it.next();

                if (!visited[n]) {
                    queue.add(n);

                    visited[n] = true;
                }
            }
        }
    }

}