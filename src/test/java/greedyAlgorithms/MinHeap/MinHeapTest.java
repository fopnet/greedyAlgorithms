

package greedyAlgorithms.MinHeap;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

import greedyAlgorithms.MinHeight.MinHeight;
import greedyAlgorithms.Node.TreeNode;

/**
 * MinHeapTest
 */
public class MinHeapTest {

    @Test
    public void testMinHeap() {
        System.out.println("The Min Heap is "); 
		MinHeap minHeap = new MinHeap(15); 
		minHeap.insert(5); 
		minHeap.insert(3); 
		minHeap.insert(17); 
		minHeap.insert(10); 
		minHeap.insert(84); 
		minHeap.insert(19); 
		minHeap.insert(6); 
		minHeap.insert(22); 
		minHeap.insert(9); 
		minHeap.minHeap(); 

		minHeap.print(); 
		System.out.println("The Min val is " + minHeap.remove()); 
	}
    
    @Test
	public void testInput() {
		System.setIn(MinHeapTest.class.getResourceAsStream("./input.txt"));

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
		int height = MinHeight.height(root);
		assertEquals( "O valor esperado seria 3", 3, height);
        System.out.println("Tree height is " + height);
        // expected 3
	}

	public static TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}