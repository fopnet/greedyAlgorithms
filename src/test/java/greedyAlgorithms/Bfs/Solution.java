package greedyAlgorithms.Bfs;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        System.setIn(Solution.class.getResourceAsStream("./" + args[0]));
        Scanner scanner = new Scanner(System.in);

        int numberOfQueries = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < numberOfQueries; tItr++) {
            int[] graphSize = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(num -> Integer.parseInt(num))
                    .toArray();
            int numNodes = graphSize[0];
            int numLinks = graphSize[1];

            // Solution bfs = new Solution(numNodes);
            GraphList bfs = new GraphList(numNodes);

            for (int line = 0; line < numLinks; line++) {
                int[] edges = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(num -> Integer.parseInt(num))
                        .toArray();
                bfs.addBidirectionalEdge(edges[0], edges[1], 6);
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
