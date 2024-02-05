package binaryTree.problems;

import binaryTree.problems.traversals.RightView;

public class LowestCommonAncestor {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    Node lca(Node root, int n1,int n2)
    {
        // Your code here
        if(root==null){
            return null;
        }
        int n = root.data;

        if(n==n1 || n==n2){
            return root;
        }

        Node left = lca(root.left,n1,n2);
        Node right = lca(root.right,n1,n2);

        if(left!=null && right!=null) return root;
        else if(left!=null && right==null) return left;
        else if(left==null && right!=null) return right;
        else return right;
        //https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
    }
}
