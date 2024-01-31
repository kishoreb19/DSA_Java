package binaryTree.problems.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node curr = q.poll();
                if (leftToRight) {
                    levelNodes.add(curr.data);
                } else {
                    levelNodes.add(0, curr.data);
                }

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }

            result.addAll(levelNodes);
            leftToRight = !leftToRight;
        }
        return result;
    }
    //https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1
}
