package greedyAlgorithms.ShortestReach;

import org.junit.Test;

import greedyAlgorithms.Graph.GraphList;

public class ShortestReachTest {

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
        try {
            Solution.main(args);
        } catch (Exception e) {
            System.err.println(e);
        }
    }   
    
    /**
     * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem BFS:
     * Shortest Reach in a Graph
     */
    @Test
    public void testShortestReachTestCase5() {
        System.out.println("ShortestReachTestCase5");

        String[] args = { "testCase5.txt" };
        try {
            Solution.main(args);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}