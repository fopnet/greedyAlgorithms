package greedyAlgorithms.BFSTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import greedyAlgorithms.Node.Node;
 

class LevelOrderTraversal {
    private Queue<Node> queue;

     LevelOrderTraversal () {
         this.queue = new LinkedList<>();;
     }


     void addQueue(Node node) {
        if (node != null) this.queue.add(node);
     }
  
    void traverse(Node root) {
        queue.add(root);
        // System.out.printf("%d",root.data);
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.printf("%d ",curr.data);
            addQueue(curr.left);
            addQueue(curr.right);
        }
     }
	 
	public static void levelOrder(Node root) {
       new LevelOrderTraversal().traverse(root);
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

    public static void main(String[] args) {
        System.setIn(LevelOrderTraversal.class.getResourceAsStream("./input2.txt"));
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
        // expected input 1 => 1 2 5 3 6 4
        // expected input 2 => 1 14 3 15 2 7 4 13 5 10 6 8 11 9 12 
    }	
}