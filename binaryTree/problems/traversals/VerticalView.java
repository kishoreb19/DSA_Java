package binaryTree.problems.traversals;
import java.util.*;
public class VerticalView {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Pair{
        Node first;
        int second;
        Pair(Node first,int second){
            this.first = first;
            this.second = second;
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer>result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Map<Integer,ArrayList<Integer>> verticalNodes = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        int maxHd = Integer.MIN_VALUE, minHd = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Pair temp = q.poll();
            Node curr = temp.first;
            int hd = temp.second;

            if(!verticalNodes.containsKey(hd)){
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(curr.data);
                verticalNodes.put(hd,tempList);
            }else{
                verticalNodes.get(hd).add(curr.data);
            }
            minHd = Math.min(minHd, hd);
            maxHd = Math.max(maxHd, hd);

            if(curr.left!=null){
                q.add(new Pair(curr.left,hd-1));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right,hd+1));
            }
        }

        for(int i=minHd;i<=maxHd;i++){
            result.addAll(verticalNodes.get(i));
        }
        return result;
    }
    //https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
}
