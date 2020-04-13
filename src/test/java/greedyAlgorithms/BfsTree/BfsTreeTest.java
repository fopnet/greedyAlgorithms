package greedyAlgorithms.BfsTree;

import java.util.Scanner;

import org.junit.Test;

import greedyAlgorithms.BFSTree.LevelOrderTraversal;
import greedyAlgorithms.Node.TreeNode;

public class BfsTreeTest {

    @Test
    public void testBfsTree() {
        System.setIn(BfsTreeTest.class.getResourceAsStream("./input2.txt"));
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = LevelOrderTraversal.insert(root, data);
        }
        scan.close();
        LevelOrderTraversal.levelOrder(root);
        // expected input 1 => 1 2 5 3 6 4
        // expected input 2 => 1 14 3 15 2 7 4 13 5 10 6 8 11 9 12 
    }
}