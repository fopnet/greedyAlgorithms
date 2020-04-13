
package greedyAlgorithms.Dfs;

import org.junit.Test;

/**
 * DfsTest
 */
public class DfsTest {

    @Test
    public void testDfs() {
        final Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

        g.DFS(2); // 2 -> 0 -> 1 -> 3 
    }

}