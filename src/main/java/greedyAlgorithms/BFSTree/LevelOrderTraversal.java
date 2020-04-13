package greedyAlgorithms.BFSTree;

import java.util.LinkedList;
import java.util.Queue;

import greedyAlgorithms.Node.TreeNode;
 

public class LevelOrderTraversal {
    private Queue<TreeNode> queue;

     LevelOrderTraversal () {
         this.queue = new LinkedList<>();;
     }


     void addQueue(TreeNode node) {
        if (node != null) this.queue.add(node);
     }
  
    void traverse(TreeNode root) {
        queue.add(root);
        // System.out.printf("%d",root.data);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.printf("%d ",curr.data);
            addQueue(curr.left);
            addQueue(curr.right);
        }
     }
	 
	public static void levelOrder(TreeNode root) {
       new LevelOrderTraversal().traverse(root);
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

    public static void main(String[] args) {
        
    }	
}