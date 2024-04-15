package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class PredecessorSuccessor {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    //------------------------------------------------------------------------------------------------------------------


    //Predecessor -> leftSubtree  -> Max Element
    //Successor   -> rightSubtree -> Min Element
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        if(root==null){
            return null;
        }
        TreeNode temp = root;
        int pre=-1;
        int suc=-1;
        while(temp!=null){
            if(temp.data==key){
                break;
            }else if (key>temp.data){
                pre = temp.data;
                temp = temp.right;
            }else{
                suc = temp.data;
                temp = temp.left;
            }
        }
        //Key Node Found !

        //Suc
        if(temp!=null && temp.right!=null){
            TreeNode rightTree = temp.right;
            while(rightTree.left!=null){
                rightTree = rightTree.left;
            }
            suc = rightTree.data;
        }
        //Pre
        if(temp!=null && temp.left!=null){
            TreeNode leftTree = temp.left;
            while(leftTree.right!=null){
                leftTree = leftTree.right;
            }
            pre = leftTree.data;
        }
        List<Integer> list = new ArrayList<>();
        list.add(pre);
        list.add(suc);
        return list;
        //Time Complexity - O(N)
        //Space Complexity - O(1)
        //https://www.naukri.com/code360/problems/_893049?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&leftPanelTabValue=PROBLEM
    }
}
