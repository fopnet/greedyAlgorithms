package greedyAlgorithms.SwapNodes;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class SwapNodesTest {

    @Test
    public void testSample1() {
        System.out.println("testSample0");
        try {
            String[] args = { "sample1.txt" };
            SwapNodesTest.main(args);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            System.out.println("\nExpected 4, 2, 1, 5, 3");
        }
    }

    @Test
    public void testInputSample0() {
        System.out.println("inputSample0.txt");
        try {
            String[] args = { "inputSample0.txt" };
            SwapNodesTest.main(args);
        } catch (Exception e) {
            System.err.println(e);
        }  finally {
            System.out.println("\nExpected 3, 1, 2");
            System.out.println("Expected 2, 1, 3");
        }
    
    }    
    
    @Test
    public void testInputSample1() {
        System.out.println("inputSample1.txt");
        try {
            String[] args = { "inputSample1.txt" };
            SwapNodesTest.main(args);
        } catch (Exception e) {
            System.err.println(e);
        }  finally {
            System.out.println("\nExpected  14 8 5 9 2 4 13 7 12 1 3 10 15 6 17 11 16");
            System.out.println("Expected 9 5 14 8 2 13 7 12 4 1 3 17 11 16 6 10 15");
        }
    
    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        SwapNode swap = new SwapNode(indexes);

        int[][] result = new int[queries.length][indexes.length];
        for (int i = 0; i < queries.length; i++) {
            int h = queries[i];

            result[i] = swap.visit(h);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(SwapNodesTest.class.getResourceAsStream("./" + args[0]));
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                // bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));
                System.out.print(result[resultRowItr][resultColumnItr]);

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    // bufferedWriter.write(" ");
                    System.out.print(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                // bufferedWriter.write("\n");
                System.out.println();
            }
        }

        // bufferedWriter.newLine();

        // bufferedWriter.close();
        scanner.close();
    }
}