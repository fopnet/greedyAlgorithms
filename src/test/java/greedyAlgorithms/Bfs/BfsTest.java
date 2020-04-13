package greedyAlgorithms.Bfs;

import org.junit.Test;

/**
 * BfsTest
 */
public class BfsTest {

    @Test
    public void testBfs() {
        GraphArray g = new GraphArray(4);

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
    public void testTestCase0() {
        GraphArray g = new GraphArray(4);

        g.addEdge(4, 2); // 4->2
        g.addEdge(1, 2); // 1->2
        g.addEdge(1, 3); // 1->3

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 1)");

        g.BFS(1); // --> 1, 2, 3
    }

    @Test
    public void testTestCase2() {
        GraphArray g = new GraphArray(7);

        g.addEdge(1, 2); // 1->2
        g.addEdge(1, 3); // 1->3
        g.addEdge(3, 4); // 3->4
        g.addEdge(2, 5); // 2->5

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.BFS(2); // -> 2 - 5
    }

    @Test
    public void testTestCase2Bidirectional() {
        GraphArray g = new GraphArray(7);

        // g.addBidirectionalEdge(7, 4); // 7->4
        g.addBidirectionalEdge(1, 2); // 1->2
        g.addBidirectionalEdge(1, 3); // 1->3
        g.addBidirectionalEdge(3, 4); // 3->4
        g.addBidirectionalEdge(2, 5); // 2->5

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.BFS(2); // -> 2 - 1 - 5 - 3 - 4
    }

    @Test
    public void testTestCase2GraphList() {
        GraphList g = new GraphList(7);

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
    public void testTestCase2BidirectionalGraphList() {
        GraphList g = new GraphList(7);

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
     * TESTANDO PARA VER SE A SOLUÇÃO SE RESOLVE COM O ALGORIMO BFS
     * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem BFS:
     * Shortest Reach in a Graph
     */
    @Test
    public void testShortestReachTestCase2() {
        GraphList g = new GraphList(7);

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
     * TESTANDO PARA VER SE A SOLUÇÃO SE RESOLVE COM O ALGORIMO BFS
     * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem BFS:
     * Shortest Reach in a Graph
     */
    @Test
    public void testShortestReachTestCase1() {
        GraphList g = new GraphList(6);

        // v -> 4, edge >2
        g.addBidirectionalEdge(1, 2, 6); // 1->2
        g.addBidirectionalEdge(2, 3, 6); // 2->3
        g.addBidirectionalEdge(3, 4, 6); // 3->4
        g.addBidirectionalEdge(1, 5, 6); // 3->4

        System.out.println("ShortestReach" + "(starting from vertex 1)");

        g.ShortestReach(1); // 6 -> 12 -> 18 -> 6  -> -1
    }


    /**
     * TESTANDO PARA VER SE A SOLUÇÃO SE RESOLVE COM O ALGORIMO BFS
     * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem BFS:
     * Shortest Reach in a Graph
     */
    @Test
    public void testShortestReachTestCase0() {
        GraphList g = new GraphList(4);

        // v -> 4, edge >2
        g.addBidirectionalEdge(1, 2, 6); // 1->2
        g.addBidirectionalEdge(1, 3, 6); // 1->3

        System.out.println("ShortestReach" + "(starting from vertex 1)");

        g.ShortestReach(1); // -> 6 -> 6 -> -1

        // query 2
        g = new GraphList(3);

        // v -> 3, edge >1
        g.addBidirectionalEdge(2, 3, 6); // 2->3

        System.out.println("\nShortestReach" + "(starting from vertex 2)");

        g.ShortestReach(2); // -> -1 -> 6
    }

}