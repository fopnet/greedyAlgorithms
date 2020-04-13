package greedyAlgorithms.Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }
    }

    private final List<List<Node>> adj;

    public Solution(int n) {
        this.adj = new ArrayList<List<Node>>(n);
        while (adj.size() <= n - 1) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(final int v, final int edge, final int w) {
        this.adj.get(v - 1).add(new Node(edge - 1, w));
    }

    public void ShortestReach(int s) {
        final boolean visited[] = new boolean[this.adj.size()];
        final int weights[] = new int[this.adj.size()];

        final Queue<Integer> queue = new LinkedList<>();

        int start = s;

        visited[s - 1] = true;
        queue.add(s - 1);
        int level = 0;

        while (queue.size() > 0) {
            // dequeue value
            s = queue.poll();
            boolean isAddedLevel = false;

            // System.out.print((s + 1) + " ");

            Iterator<Node> it = this.adj.get(s).listIterator();
            while (it.hasNext()) {
                Node n = it.next();

                if (!visited[n.node]) {
                    if (!isAddedLevel) {
                        isAddedLevel = !isAddedLevel;
                        level++;
                    }

                    weights[n.node] = level * n.cost;

                    queue.add(n.node);

                    visited[n.node] = true;
                }
            }
        }

        for (int i = 0; i < weights.length; i++) {
            if (i != start - 1) {
                System.out.print((weights[i] == 0 ? "-1" : weights[i]) + " ");
            }
        }
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */

        System.setIn(Solution.class.getResourceAsStream("./input.txt"));
        Scanner scanner = new Scanner(System.in);

        int numberOfQueries = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < numberOfQueries; tItr++) {
            int[] graphSize = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(num -> Integer.parseInt(num))
                    .toArray();
            int numNodes = graphSize[0];
            int numLinks = graphSize[1];

            Solution bfs = new Solution(numNodes);

            for (int line = 0; line < numLinks; line++) {
                int[] edges = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(num -> Integer.parseInt(num))
                        .toArray();
                bfs.addEdge(edges[0], edges[1], 6);
            }

            int source = scanner.nextInt();

            if (scanner.hasNext())
                scanner.nextLine();

            // Calculate the single source shortest path

            bfs.ShortestReach(source);

        }

        scanner.close();
    }
}
