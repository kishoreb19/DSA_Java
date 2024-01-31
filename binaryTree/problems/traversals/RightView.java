package binaryTree.problems.traversals;
import java.util.*;
public class RightView {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    ArrayList<Integer> rightView(Node root)
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Map<Integer,Integer> rightNodes = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level=1;

        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                Node curr = q.poll();
                if(!rightNodes.containsKey(level)){
                    rightNodes.put(level,curr.data);
                }

                if(curr.right!=null){
                    q.add(curr.right);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
            }
            level++;
        }
        for(int i : rightNodes.keySet()){
            result.add(rightNodes.get(i));
        }

        return result;
    }

    //Using Recursion
    void rightViewFast(Node root,Map<Integer,Integer>rightNodes,int level){
        if(root==null){
            return;
        }
        if(!rightNodes.containsKey(level)){
            rightNodes.put(level,root.data);
        }

        rightViewFast(root.right,rightNodes,level+1);
        rightViewFast(root.left,rightNodes,level+1);
    }
    ArrayList<Integer> rightView_Recursion(Node root) {
        //add code here.
        ArrayList<Integer>result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Map<Integer,Integer>rightNodes = new HashMap<>();
        rightViewFast(root,rightNodes,0);
        for(int i : rightNodes.keySet()){
            result.add(rightNodes.get(i));
        }
        return result;
    }
    //https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1
}
