package heaps.problems;

import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeHeap {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    boolean isHeap(Node tree) {
        // code here
        Queue<Node> q = new LinkedList<>();
        boolean seen = false;
        q.add(tree);
        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.left!=null){
                if(seen || curr.left.data>curr.data) return false;
                q.add(curr.left);
            }else{
                seen = true;
            }
            if(curr.right!=null){
                if(seen || curr.right.data>curr.data) return false;
                q.add(curr.right);
            }else{
                seen = true;
            }
        }
        return true;
    }
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    //https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1
}
