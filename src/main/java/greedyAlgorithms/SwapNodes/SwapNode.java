package greedyAlgorithms.SwapNodes;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import greedyAlgorithms.Node.TreeNode;

public class SwapNode {

    TreeNode root;
    int nodes = 0;
    Queue<TreeNode> queue = null;

    public SwapNode(int[][] nodes) {
        this.nodes = nodes.length;
        this.root = nodes.length > 0 ? new TreeNode(1) : null;
        this.queue = new LinkedList<TreeNode>(Arrays.asList(this.root));
        this.buildTree(nodes);
    }

    private void buildTree(int[][] nodes) {
        for (int[] pair : nodes) {
            this.insertTraverseOrder(pair[0], pair[1]);
        }
    }

    public TreeNode insertTraverseOrder(int left, int right) {
        return insert(this.queue.poll(), left, right);
    }

    private TreeNode insert(TreeNode root, int left, int right) {

        if (left > 0) {
            root.left = new TreeNode(left, root);
            queue.add(root.left);
        }
        if (right > 0) {
            root.right = new TreeNode(right, root);
            queue.add(root.right);
        }

        return root;
    }

    public int[] visit(int h) {
        return new InOrderSwapVisitor(h, this.nodes).visit(this.root);
    }

}