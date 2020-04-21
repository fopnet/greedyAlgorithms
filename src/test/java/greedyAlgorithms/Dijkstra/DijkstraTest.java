
package greedyAlgorithms.Dijkstra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

// import static junit.Assert.assertNotNull;
// import static org.junit.Assert.assertTrue;
// import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import greedyAlgorithms.Node.Node;

public class DijkstraTest {

    private List<Vertex> nodes;
    private List<Edge> edges;

    @Test
    public void testExcute() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 11; i++) {
            final Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLine("Edge_0", 0, 1, 85);
        addLine("Edge_1", 0, 2, 217);
        addLine("Edge_2", 0, 4, 173);
        addLine("Edge_3", 2, 6, 186);
        addLine("Edge_4", 2, 7, 103);
        addLine("Edge_5", 3, 7, 183);
        addLine("Edge_6", 5, 8, 250);
        addLine("Edge_7", 8, 9, 84);
        addLine("Edge_8", 7, 9, 167);
        addLine("Edge_9", 4, 9, 502);
        addLine("Edge_10", 9, 10, 40);
        addLine("Edge_11", 1, 10, 600);

        // Lets check from location Loc_1 to Loc_10
        final Graph graph = new Graph(nodes, edges);
        final Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(nodes.get(0));
        final LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (int i = 0; i < path.size(); i++) {
            assertEquals("Node_0", path.get(0).toString());
            assertEquals("Node_2", path.get(1).toString());
            assertEquals("Node_7", path.get(2).toString());
            assertEquals("Node_9", path.get(3).toString());
            assertEquals("Node_10", path.get(4).toString());
            System.out.println(path.get(i));
        }

    }

    private void addLine(final String laneId, final int sourceLocNo, final int destLocNo, final int duration) {
        final Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
    
    @Test 
    public void testExecute2() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 9; i++) {
            final Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLine("Edge_0", 0, 1, 4);
        addLine("Edge_0", 0, 7, 8);
        addLine("Edge_1", 1, 7, 11);
        addLine("Edge_1", 1, 2, 8);
        addLine("Edge_2", 2, 8, 2);
        addLine("Edge_2", 2, 7, 7);
        addLine("Edge_2", 2, 4, 5);
        addLine("Edge_3", 3, 5, 14);
        addLine("Edge_3", 3, 4, 9);
        addLine("Edge_5", 5, 3, 14);
        addLine("Edge_6", 6, 8, 6);
        addLine("Edge_6", 6, 5, 2);
        addLine("Edge_5", 5, 4, 10);
        addLine("Edge_7", 7, 6, 1);
        addLine("Edge_7", 7, 8, 7);
        addLine("Edge_7", 7, 1, 11);
        addLine("Edge_8", 8, 6, 6);
        addLine("Edge_8", 8, 2, 2);

        // Lets check from location Loc_1 to Loc_10
        final Graph graph = new Graph(nodes, edges);
        final Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(nodes.get(0));
        final LinkedList<Vertex> path = dijkstra.getPath(nodes.get(4));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        // System.out.println("The shorted path from node :");
        // for (int i = 0; i < 4; i++)
        // System.out.println(nodes.get(0) + " to " + i + " is " +
        // dijkstra.getWeight(nodes.get(i)));

        // for (final Vertex vertex : path) {
        System.out.println("Vertex \t \t Distance from Source");
        for (int i = 0; i < path.size(); i++) {
            Vertex v = path.get(i);
            System.out.printf("%s\t\t\t%s\n", v.getId(), dijkstra.getWeight(v));
            assertEquals("Node_0", path.get(0).toString());
            assertEquals(0, dijkstra.getWeight(path.get(0)).intValue());

            assertEquals("Node_1", path.get(1).toString());
            assertEquals(4, dijkstra.getWeight(path.get(1)).intValue());

            assertEquals("Node_2", path.get(2).toString());
            assertEquals(12, dijkstra.getWeight(path.get(2)).intValue());

            assertEquals("Node_4", path.get(3).toString());
            assertEquals(17, dijkstra.getWeight(path.get(3)).intValue());
            // System.out.println(path.get(i));
        }
    }

    /**
     * Dijkstra priority queue Time complexity O (lov n )
     */
    @Test
    public void testDpq() {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<Node>> adj = new ArrayList<List<Node>>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        // Inputs for the DPQ graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculate the single source shortest path
        DPQ dpq = new DPQ(V);
        dpq.dijkstra(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is " + dpq.dist[i]);
    }

    /** Dijkstra priority queue */
    public void testDpq2() {

        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<Node>> adj = new ArrayList<List<Node>>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        // Inputs for the DPQ graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculate the single source shortest path
        DPQ dpq = new DPQ(V);
        dpq.dijkstra(adj, source).printDistances(source);
    }

    /**
     * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
     * 
     * Input Format
     *
     * The first line contains an integer, , the number of queries.
     *
     * Each of the following sets of lines is as follows:
     *
     * The first line contains two space-separated integers, and , the number of
     * nodes and the number of edges. Each of the next lines contains two
     * space-separated integers, and , describing an edge connecting node to node .
     * The last line contains a single integer, , the index of the starting node.
     */
    @Test
    public void bfsTest() {

        System.setIn(DijkstraTest.class.getResourceAsStream("./input2.txt"));
        Scanner scanner = new Scanner(System.in);

        int numberOfQueries = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < numberOfQueries; tItr++) {
            int[] graphSize = Arrays.stream(scanner.nextLine().split("\s")).mapToInt(num -> Integer.parseInt(num))
                    .toArray();
            int numNodes = graphSize[0];
            int numLinks = graphSize[1];

            // Adjacency list representation of the
            // connected edges
            List<List<Node>> adj = new ArrayList<List<Node>>();
            for (int i = 0; i < numNodes; i++) {
                adj.add(new ArrayList<Node>());
            }

            for (int line = 0; line < numLinks; line++) {
                int[] edges = Arrays.stream(scanner.nextLine().split("\s")).mapToInt(num -> Integer.parseInt(num))
                        .toArray();
                adj.get(edges[0] - 1).add(new Node(edges[1] - 1, 6));
            }

            int source = scanner.nextInt() - 1;

            if (scanner.hasNext())
                scanner.nextLine();

            // Calculate the single source shortest path
            DPQ dpq = new DPQ(numNodes);
            dpq.dijkstra(adj, source).printBFS(source, Integer.MAX_VALUE, -1);

        }

        scanner.close();
    }

    /**
     * Youtube sample https://www.youtube.com/watch?v=gdmfOwyQlcI
     * 
     * Asnwser: weight 11 
     * path: A, B, D, F
     */
    @Test
    public void youtubeTest() {

        System.setIn(DijkstraTest.class.getResourceAsStream("./youtubeSample.txt"));
        Scanner scanner = new Scanner(System.in);

        int numberOfQueries = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < numberOfQueries; tItr++) {
            int[] graphSize = Arrays.stream(scanner.nextLine().split("\s")).mapToInt(num -> Integer.parseInt(num))
                    .toArray();
            int numNodes = graphSize[0];
            int numLinks = graphSize[1];

            // Adjacency list representation of the
            // connected edges
            List<List<Node>> adj = new ArrayList<List<Node>>();
            for (int i = 0; i < numNodes; i++) {
                adj.add(new ArrayList<Node>());
            }

            for (int line = 0; line < numLinks; line++) {
                int[] edges = Arrays.stream(scanner.nextLine().split("\s")).mapToInt(num -> Integer.parseInt(num))
                        .toArray();
                adj.get(edges[0] - 1).add(new Node(edges[1] - 1, edges[2]));
            }

            int source = scanner.nextInt() - 1;

            if (scanner.hasNext())
                scanner.nextLine();

            // Calculate the single source shortest path
            DPQ dpq = new DPQ(numNodes);
            dpq.dijkstra(adj, source).printBFSLetters(source, Integer.MAX_VALUE, -1, 6);

        }

        scanner.close();
    }
}