package binarySearchTree;
import java.util.*;
public class BSTtoLinkedList {
    class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static void inOrder(TreeNode<Integer>root,ArrayList<TreeNode<Integer>>list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);
        }
        public static TreeNode<Integer> flatten(TreeNode<Integer> root) {
            // Write your code here
            ArrayList<TreeNode<Integer>>list = new ArrayList<>();
            inOrder(root, list);
            int i=0;
            for(i=0;i<list.size()-1;i++){
                list.get(i).left = null;
                list.get(i).right = list.get(i+1);
            }
            list.get(i).left=null;
            list.get(i).right=null;
            return list.get(0);
        }
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
        //https://www.naukri.com/code360/problems/flatten-bst-to-a-sorted-list_1169459?leftPanelTab=0&leftPanelTabValue=PROBLEM
}
