package binaryTree.problems.traversals;

import binaryTree.problems.FlattenBinaryTreeToLL;

public class MorrisTraversal {
    public static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void morrisTraversal(Node root){
        Node curr = root;
        while (curr!=null){
            if(curr.left==null){
                System.out.print(curr.data+" ");
                curr = curr.right;
            }else{
                //Find InOrder Predecessor
                Node pred = curr.left;
                while (pred.right!=null && pred.right!=curr){
                    pred = pred.right;
                }
                //predecessor found
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    pred.right = null;
                    System.out.print(curr.data+" ");
                    curr = curr.right;
                }
            }
        }
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }
}
