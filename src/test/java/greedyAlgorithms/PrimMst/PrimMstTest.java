
package greedyAlgorithms.PrimMst;

import org.junit.Test;

/**
 * PrimMstTest
 */
public class PrimMstTest {

    @Test
    public void testPrimMst() {
        /*! Let us create the following graph 
            2   3 
        (0)--(1)--(2) 
        |   / \    | 
       6| 8/   \5  |7 
        | /     \  | 
        (3)-------(4) 
              9          
        */
        PrimMst t = new PrimMst();
        int graph[][] = new int[][] { 
                { 0, 2, 0, 6, 0 }, 
                { 2, 0, 3, 8, 5 }, 
                { 0, 3, 0, 0, 7 }, 
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } 
            };

        // Print the solution
        t.primMST(graph);
    }
}