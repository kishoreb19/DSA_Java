package binaryTree.problems;

import binaryTree.problems.traversals.RightView;

public class SumOfNodesLongestPathRootToLeaf {
    static class Node{
        int data;
    Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    Pair solve(Node root){
        Pair result = new Pair(0,0);
        if(root==null){
            return result;
        }
        //'first' stores height and 'second' stores sum

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        if(left.first==right.first){//If heights are same
            int maxSum = Math.max(left.second,right.second) + root.data;
            return new Pair (left.first + 1, maxSum);
        }else if(left.first>right.first){
            return new Pair(left.first+1,left.second+root.data);
        }else{
            return new Pair(right.first+1,right.second+root.data);
        }
        //https://www.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
    }
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        Pair result = solve(root);
        return result.second;
    }
}
