package greedyAlgorithms.BfsGraph;

import org.junit.Test;

import greedyAlgorithms.Graph.GraphArray;
import greedyAlgorithms.Graph.GraphList;

/**
 * BfsTest
 */
public class BfsTest {

    @Test
    public void testBfs() {
        final GraphArray g = new GraphArray(4);

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 4);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.BFS(2);
    }

    @Test
    public void testBaseTestCase0() {
        final GraphArray g = new GraphArray(4);

        g.addEdge(4, 2); // 4->2
        g.addEdge(1, 2); // 1->2
        g.addEdge(1, 3); // 1->3

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 1)");

        g.BFS(1); // --> 1, 2, 3
    }

    @Test
    public void testBaseTestCase2() {
        final GraphArray g = new GraphArray(7);

        g.addEdge(1, 2); // 1->2
        g.addEdge(1, 3); // 1->3
        g.addEdge(3, 4); // 3->4
        g.addEdge(2, 5); // 2->5

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.BFS(2); //  2 -> 5
    }

    @Test
    public void testBaseTestCase2Bidirectional() {
        final GraphArray g = new GraphArray(7);

        // g.addBidirectionalEdge(7, 4); // 7->4
        g.addBidirectionalEdge(1, 2); // 1->2
        g.addBidirectionalEdge(1, 3); // 1->3
        g.addBidirectionalEdge(3, 4); // 3->4
        g.addBidirectionalEdge(2, 5); // 2->5

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.BFS(2); // -> 2 - 1 - 5 - 3 - 4
    }

    @Test
    public void testBaseTestCase2GraphList() {
        final GraphList g = new GraphList(7);

        // v -> 7, edge >4
        // g.addEdge(7, 4, 6); // 7->4
        g.addEdge(1, 2, 6); // 1->2
        g.addEdge(1, 3, 6); // 1->3
        g.addEdge(3, 4, 6); // 3->4
        g.addEdge(2, 5, 6); // 2->5

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.BFS(2); // -> 2 -> 5
    }

    @Test
    public void testBaseTestCase2BidirectionalGraphList() {
        final GraphList g = new GraphList(7);

        // v -> 7, edge >4
        // g.addBidirectionalEdge(7, 4, 6); // 7->4
        g.addBidirectionalEdge(1, 2, 6); // 1->2
        g.addBidirectionalEdge(1, 3, 6); // 1->3
        g.addBidirectionalEdge(3, 4, 6); // 3->4
        g.addBidirectionalEdge(2, 5, 6); // 2->5

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.BFS(2); // -> 2 -> 1 -> 5 -> 3 -> 4
    }

   
}