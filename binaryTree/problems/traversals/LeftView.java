package binaryTree.problems.traversals;
import java.util.*;
public class LeftView {
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
        Pair(Node first,int second){
            this.first = first;
            this.second = second;
        }
    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Map<Integer,Integer> leftNodes = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level=1;

        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                Node curr = q.poll();
                if(!leftNodes.containsKey(level)){
                    leftNodes.put(level,curr.data);
                }

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            level++;
        }
        for(int i : leftNodes.keySet()){
            result.add(leftNodes.get(i));
        }

        return result;
    }


    //Using Recursion
    void leftViewFast(Node root,Map<Integer,Integer>leftNodes,int level){
        if(root==null){
            return;
        }
        if(!leftNodes.containsKey(level)){
            leftNodes.put(level,root.data);
        }

        leftViewFast(root.left,leftNodes,level+1);
        leftViewFast(root.right,leftNodes,level+1);
    }
    ArrayList<Integer> leftView_Recursion(Node root)
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer,Integer> leftNodes = new HashMap<>();
        leftViewFast(root,leftNodes,0);
        for(int i : leftNodes.keySet()){
            result.add(leftNodes.get(i));
        }
        return result;
    }
    //https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
}
