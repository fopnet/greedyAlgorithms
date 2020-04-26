
package greedyAlgorithms.Graph;

import java.util.ArrayList;
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
 public class GraphArray {
    private final int V;
    private final ArrayList<LinkedList<Integer>> adj;

    public GraphArray(final int v) {
        this.V = v;
        this.adj = new ArrayList<LinkedList<Integer>>(v); // new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj.add( new LinkedList<Integer>());
        }
    }

    public void addEdge(final int v, final int w) {
        this.adj.get(v - 1).add(w - 1);
    }

    public void addBidirectionalEdge(final int v, final int w) {
        this.adj.get(v - 1).add(w - 1);
        this.adj.get(w - 1).add(v - 1);
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

            Iterator<Integer> it = this.adj.get(s).listIterator();
            while (it.hasNext()) {
                int n = it.next();

                if (!visited[n]) {
                    queue.add(n);

                    visited[n] = true;
                }
            }
        }
    }


    // A function used by DFS
    private void DFSUtil(final int v, final boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        final Iterator<Integer> i = adj.get(v).listIterator();
        while (i.hasNext()) {
            final int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    public void DFS(final int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        final boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

}