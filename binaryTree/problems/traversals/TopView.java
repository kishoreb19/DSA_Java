package binaryTree.problems.traversals;
import java.util.*;
public class TopView {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    static class Pair{
        Node first;
        int second;
        Pair(Node first, int second){
            this.first = first;
            this.second = second;
        }
    }
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return null;

        Map<Integer, Integer> topNodes = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int maxHd = Integer.MIN_VALUE, minHd = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Node frontNode = temp.first;
            int hd = temp.second;

            if (!topNodes.containsKey(hd)) {
                topNodes.put(hd, frontNode.data);

                minHd = Math.min(minHd, hd);
                maxHd = Math.max(maxHd, hd);
            }

            if (frontNode.left != null) {
                q.add(new Pair(frontNode.left, hd - 1));
            }
            if (frontNode.right != null) {
                q.add(new Pair(frontNode.right, hd + 1));
            }
        }

        for(int i=minHd;i<=maxHd;i++){
            result.add(topNodes.get(i));
        }

        return result;
    }
    //https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
}
