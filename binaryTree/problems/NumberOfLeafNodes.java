package binaryTree.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfLeafNodes {
     class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        public BinaryTreeNode(T data) {
            this.data = data;
        }
     }
     public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
         // Write your code here.
         if(root==null) {
             return 0;
         }
         if(root.left ==null && root.right==null){
             return 1;
         }
         int count = noOfLeafNodes(root.left) + noOfLeafNodes(root.right);
         return count;
     }
    public static int noOfLeafNodesAlternative(BinaryTreeNode<Integer> root) {
        // Write your code here.
        int count =0;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> temp = q.poll();
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            if(temp.right==null && temp.left==null){
                count++;
            }
        }
        return count;
    }
}

