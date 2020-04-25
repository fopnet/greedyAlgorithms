
package greedyAlgorithms.DfsGraph;

import org.junit.Test;

import greedyAlgorithms.Graph.GraphArray;

/**
 * DfsTest
 */
public class DfsTest {

   
    @Test
    public void testDfs() {
        final GraphArray g = new GraphArray(4);

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 4);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

        g.DFS(2); // 2 -> 0 -> 1 -> 3 
    }

}