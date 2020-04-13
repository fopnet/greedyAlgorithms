package greedyAlgorithms.Bfs;

import org.junit.Test;

/**
 * BfsTest
 */
public class BfsTest {

    @Test
    public void testBfs() {
        final GraphArray g = new GraphArray(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

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

        g.BFS(2); // -> 2 - 5
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

        g.BFS(2); // -> 2 - 5
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

        g.BFS(2); // -> 2 - 1 - 5 - 3 - 4
    }

    /**
     * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem BFS:
     * Shortest Reach in a Graph
     */
    @Test
    public void testShortestReachBaseTestCase2() {
        final GraphList g = new GraphList(7);

        // v -> 7, edge >4
        // g.addBidirectionalEdge(7, 4, 6); // 7->4
        g.addBidirectionalEdge(1, 2, 6); // 1->2
        g.addBidirectionalEdge(1, 3, 6); // 1->3
        g.addBidirectionalEdge(3, 4, 6); // 3->4
        g.addBidirectionalEdge(2, 5, 6); // 2->5

        System.out.println("ShortestReach" + "(starting from vertex 2)");

        g.ShortestReach(2); // -> 6 12 18 6 -1 -1
    }

    /**
     * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem BFS:
     * Shortest Reach in a Graph
     */
    @Test
    public void testShortestReachBaseTestCase1() {
        final GraphList g = new GraphList(6);

        // v -> 4, edge >2
        g.addEdge(1, 2, 6); // 1->2
        g.addEdge(2, 3, 6); // 2->3
        g.addEdge(3, 4, 6); // 3->4
        g.addEdge(1, 5, 6); // 3->4

        System.out.println("ShortestReach" + "(starting from vertex 1)");

        g.ShortestReach(1); // 6 -> 12 -> 18 -> 6 -> -1
    }

    /**
     * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem BFS:
     * Shortest Reach in a Graph
     */
    @Test
    public void testShortestReachBaseTestCase0() {
        GraphList g = new GraphList(4);

        // v -> 4, edge >2
        g.addEdge(1, 2, 6); // 1->2
        g.addEdge(1, 3, 6); // 1->3

        System.out.println("ShortestReach" + "(starting from vertex 1)");

        g.ShortestReach(1); // -> 6 -> 6 -> -1

        // query 2
        g = new GraphList(3);

        // v -> 3, edge >1
        g.addEdge(2, 3, 6); // 2->3

        System.out.println("\nShortestReach" + "(starting from vertex 2)");

        g.ShortestReach(2); // -> -1 -> 6
    }

    /**
     * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem BFS:
     * Shortest Reach in a Graph
     */
    @Test
    public void testShortestReachTestCase1() {
        System.out.println("ShortestReachTestCase1");

        String[] args = { "testCase1.txt" };
        Solution.main(args);
    }
}