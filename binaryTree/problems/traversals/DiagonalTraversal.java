package binaryTree.problems.traversals;
import java.util.*;
public class DiagonalTraversal {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    public ArrayList<Integer> diagonal(Node root)
    {
        //add your code here.
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<Node>leftNodes = new LinkedList<>();
        Node temp = root;
        while(temp!=null){
            if(temp.left!=null){
                leftNodes.add(temp.left);
            }
            result.add(temp.data);
            temp = temp.right;
            if(temp==null && !leftNodes.isEmpty()){
                temp = leftNodes.poll();
            }
        }
        return result;
    }
    //https://www.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
}
