package greedyAlgorithms.Dfs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class represents a directed graph using adjacency list representation
 * Depth First Search is a graph traversal algorithm which explores as far as
 * possible along each branch before backtracking.
 * 
 * Time Complexity: O(|V| + |E|)
 */
class Graph {
    private final int V; // No. of vertices

    // Array of lists for Adjacency List Representation
    private final LinkedList<Integer> adj[];

    // Constructor
    Graph(final int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    // Function to add an edge into the graph
    void addEdge(final int v, final int w) {
        adj[v].add(w); // Add w to v's list.
    }

    // A function used by DFS
    private void DFSUtil(final int v, final boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        final Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            final int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(final int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        final boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
}

// This code is contributed by Aakash Hasija
