package greedyAlgorithms.SwapNodes;

import java.util.LinkedList;
import java.util.Queue;

import greedyAlgorithms.Node.TreeNode;

public class SwapNode {

    TreeNode root;
    int nodes = 0;
    Queue<TreeNode> queue = null;

    public SwapNode(int[][] nodes) {
        this.nodes = nodes.length;
        this.queue = new LinkedList<>();
        this.root = nodes.length > 0 ? new TreeNode(1) : null;
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
         
        TreeNode last = this.queue.poll();

    
        return root;
    }

    public int[] visit(int h) {
        return new InOrderSwapVisitor(h, this.nodes).visit(this.root);
    }

  
}