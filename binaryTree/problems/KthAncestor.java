package binaryTree.problems;

import java.util.ArrayList;

public class KthAncestor {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    boolean found = false;
    void solve(Node root, int k, int node, ArrayList<Integer> path){
        if(root==null || found){
            return;
        }
        path.add(root.data);
        if(root.data==node){
            found=true;
        }
        solve(root.left,k,node,path);
        solve(root.right,k,node,path);
        if(!found){
            path.remove(path.size()-1);
        }

    }
    public int kthAncestor(Node root, int k, int node)
    {
        //Write your code here
        ArrayList<Integer> path = new ArrayList<>();
        solve(root,k,node,path);
        int len = path.size();
        if (!found || k > len-1) {
            return -1;
        }

        return path.get(len - k - 1);
        //Time Complexity - O(N) as we are traversing each node only once
        //Space Complexity - O(N)
    }
    //https://www.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
}
