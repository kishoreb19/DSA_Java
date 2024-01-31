package binaryTree.problems.traversals;
import java.util.*;
public class BottomView {
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
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return null;
        }

        Map<Integer,Integer> bottomNodes = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        int minHd = Integer.MAX_VALUE, maxHd = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            Pair temp = q.poll();
            Node curr = temp.first;
            int hd = temp.second;

            bottomNodes.put(hd,curr.data);
            minHd = Math.min(minHd,hd);
            maxHd = Math.max(maxHd,hd);

            if(curr.left!=null){
                q.add(new Pair(curr.left,hd-1));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right,hd+1));
            }
        }

        for(int i=minHd;i<=maxHd;i++){
            result.add(bottomNodes.get(i));
        }

        return result;
    }
    //https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
}
