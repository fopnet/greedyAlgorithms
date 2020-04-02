package greedyAlgorithms.minHeight;
    
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import greedyAlgorithms.Node.Node;


class MinHeight {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
        int maxHeightLeft = 0;
        int maxHeightRight = 0;
      	// Write your code here.
         if (root.left != null)   maxHeightLeft = heightUtil(root.left, 1);
         if (root.right != null)  maxHeightRight = heightUtil(root.right, 1);
        
         return maxHeightLeft >maxHeightRight ? maxHeightLeft : maxHeightRight;
    }

    public static int heightUtil( Node node, int currentHeight) {

        int leftHeight = currentHeight , rightLength = currentHeight;
        if (node.left != null) leftHeight = heightUtil(node.left, currentHeight + 1);
        if (node.right != null) rightLength = heightUtil(node.right, currentHeight + 1);
        return leftHeight > rightLength ? leftHeight : rightLength;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
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

    public static void main(String[] args) throws Exception {
        System.setIn(MinHeight.class.getResourceAsStream("./input.txt"));

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println("Tree height is " + height);
        // expected 3
    }
}