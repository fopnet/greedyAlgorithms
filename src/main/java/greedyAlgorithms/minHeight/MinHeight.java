package greedyAlgorithms.MinHeight;
    
import greedyAlgorithms.Node.TreeNode;


public class MinHeight {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(TreeNode root) {
        int maxHeightLeft = 0;
        int maxHeightRight = 0;
        if (root == null) return 0;
      	// Write your code here.
         if (root.left != null)   maxHeightLeft = heightUtil(root.left, 1);
         if (root.right != null)  maxHeightRight = heightUtil(root.right, 1);
        
         return maxHeightLeft >maxHeightRight ? maxHeightLeft : maxHeightRight;
    }

    public static int heightUtil( TreeNode node, int currentHeight) {

        int leftHeight = currentHeight , rightLength = currentHeight;
        if (node.left != null) leftHeight = heightUtil(node.left, currentHeight + 1);
        if (node.right != null) rightLength = heightUtil(node.right, currentHeight + 1);
        return leftHeight > rightLength ? leftHeight : rightLength;
    }

	

}