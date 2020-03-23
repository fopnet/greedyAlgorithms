
package greedyAlgorithms.Dijkstra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

// import static junit.Assert.assertNotNull;
// import static org.junit.Assert.assertTrue;
// import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

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

        addLane("Edge_0", 0, 1, 85);
        addLane("Edge_1", 0, 2, 217);
        addLane("Edge_2", 0, 4, 173);
        addLane("Edge_3", 2, 6, 186);
        addLane("Edge_4", 2, 7, 103);
        addLane("Edge_5", 3, 7, 183);
        addLane("Edge_6", 5, 8, 250);
        addLane("Edge_7", 8, 9, 84);
        addLane("Edge_8", 7, 9, 167);
        addLane("Edge_9", 4, 9, 502);
        addLane("Edge_10", 9, 10, 40);
        addLane("Edge_11", 1, 10, 600);

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

    private void addLane(final String laneId, final int sourceLocNo, final int destLocNo, final int duration) {
        final Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }

    @Test
    public void testExcute2() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 9; i++) {
            final Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Edge_0", 0, 1, 4);
        addLane("Edge_0", 0, 7, 8);
        addLane("Edge_1", 1, 7, 11);
        addLane("Edge_1", 1, 2, 8);
        addLane("Edge_2", 2, 8, 2);
        addLane("Edge_2", 2, 7, 7);
        addLane("Edge_2", 2, 4, 5);
        addLane("Edge_3", 3, 5, 14);
        addLane("Edge_3", 3, 4, 9);
        addLane("Edge_5", 5, 3, 14);
        addLane("Edge_6", 6, 8, 6);
        addLane("Edge_6", 6, 5, 2);
        addLane("Edge_5", 5, 4, 10);
        addLane("Edge_7", 7, 6, 1);
        addLane("Edge_7", 7, 8, 7);
        addLane("Edge_7", 7, 1, 11);
        addLane("Edge_8", 8, 6, 6);
        addLane("Edge_8", 8, 2, 2);

        // Lets check from location Loc_1 to Loc_10
        final Graph graph = new Graph(nodes, edges);
        final Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.execute(nodes.get(0));
        final LinkedList<Vertex> path = dijkstra.getPath(nodes.get(4));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        // for (final Vertex vertex : path) {
        for (int i = 0; i < path.size(); i++) {
            assertEquals("Node_0", path.get(0).toString());
            assertEquals("Node_1", path.get(1).toString());
            assertEquals("Node_2", path.get(2).toString());
            assertEquals("Node_4", path.get(3).toString());
            System.out.println(path.get(i));
        }
    }
}