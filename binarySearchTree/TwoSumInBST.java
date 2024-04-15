package binarySearchTree;
import java.util.*;
public class TwoSumInBST {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    static void inOrder(BinaryTreeNode<Integer>root,ArrayList<Integer>list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.data);
        inOrder(root.right,list);
    }
    public static boolean twoSumInBST(BinaryTreeNode<Integer> root, int target) {
        // Write your code here!
        ArrayList<Integer> list = new ArrayList<>();
        inOrder( root,list);
        int low = 0, high = list.size()-1;
        while(low<high){
            if(list.get(low)+list.get(high)==target){
                return true;
            }else if (list.get(low)+list.get(high)>target){
                high = high-1;
            }else{
                low = low+1;
            }
        }
        return false;
    }
    //Time  Complexity - O(N)
    //Space Complexity - O(N)
    //https://www.naukri.com/code360/problems/two-sum-in-a-bst_1062631?leftPanelTab=0&leftPanelTabValue=PROBLEM
}
