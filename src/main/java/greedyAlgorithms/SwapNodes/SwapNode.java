package greedyAlgorithms.SwapNodes;

import java.util.LinkedList;
import java.util.Queue;

import greedyAlgorithms.Node.TreeNode;

public class SwapNode {

    TreeNode root;
    boolean visited[] = null;
    Queue<TreeNode> queue = null;

    public SwapNode(int[][] nodes) {
        this.queue = new LinkedList<>();
        this.root = nodes.length > 0 ? new TreeNode(1) : null;
        this.visited = new boolean[nodes.length];
        this.buildTree(nodes);
    }

    private void buildTree(int[][] nodes) {
        for (int[] pair : nodes) {
            this.insertTraverseOrder(this.root, pair[0], pair[1]);
        }
    }

    public TreeNode insertTraverseOrder(TreeNode root, int left, int right) {
        return insert(root, left, right, null);
    }

    private TreeNode insert(TreeNode root, int left, int right, TreeNode parent) {
        if (root == null || (left == 0 && right == 0))
            return root;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == rightHeight) {
            if (root.left == null && root.right == null) {
                if (left > 0) {
                    root.left = new TreeNode(left, root);
                    queue.add(root.left);
                }
                if (right > 0) {
                    root.right = new TreeNode(right, root);
                    queue.add(root.right);
                }
            } else {
                return insert(root.left, left, right, parent);
            }
        } else if (leftHeight > rightHeight) {
            return insert(root.right, left, right, parent);
        } else {
            return insert(root.left, left, right, parent);
        }

        return root;
    }

    public int[] visit(int h) {
        return new InOrderSwapVisitor(h, visited.length).visit(this.root);
    }

    public  int height(TreeNode root) {
        int maxHeightLeft = 0;
        int maxHeightRight = 0;
        if (root == null) return 0;
      	// Write your code here.
         if (root.left != null)   maxHeightLeft = height(root.left, 1);
         if (root.right != null)  maxHeightRight = height(root.right, 1);
        
         return maxHeightLeft >maxHeightRight ? maxHeightLeft : maxHeightRight;
    }

    private  int height( TreeNode node, int currentHeight) {

        int leftHeight = currentHeight , rightLength = currentHeight;
        if (node.left != null) leftHeight = height(node.left, currentHeight + 1);
        if (node.right != null) rightLength = height(node.right, currentHeight + 1);
        return leftHeight > rightLength ? leftHeight : rightLength;
    }


}