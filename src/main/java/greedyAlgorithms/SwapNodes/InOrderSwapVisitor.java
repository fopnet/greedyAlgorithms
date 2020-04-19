package greedyAlgorithms.SwapNodes;

import greedyAlgorithms.Node.TreeNode;
import greedyAlgorithms.TreeVisitor.InOrderVisitor;

public class InOrderSwapVisitor extends InOrderVisitor {
    private int swapHeight;

    boolean[] visited;

    public InOrderSwapVisitor(int h, int nodes) {
        this.swapHeight = h;
        this.visited = new boolean[nodes];
    }

    @Override
    protected void _visit(TreeNode node, int h) {
        if (node == null)
            return;

        swap(node, h);

        super._visit(node, h);
    }

    private void swap(TreeNode parent, int h) {

        int parentIdx = parent != null ? parent.data - 1 : -1;
        if (this.swapHeight == h + 1 && parentIdx >= 0 && !this.visited[parentIdx]) {
            this.visited[parentIdx] = true;
            TreeNode left = parent.left;
            parent.left = parent.right;
            parent.right = left;
        }
    }
}