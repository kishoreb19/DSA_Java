package binarySearchTree;

import java.util.ArrayList;

public class NormalBSTtoBalancedBST {
    static class TreeNode<T>
    {
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
    static void inOrder(TreeNode<Integer>root, ArrayList<Integer> list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.data);
        inOrder(root.right,list);
    }

    static TreeNode<Integer> inOrderToBST(int l, int h, ArrayList<Integer>list){
        if(l>h) return null;
        int mid = l-(l-h)/2;
        TreeNode<Integer> root = new TreeNode<>(list.get(mid));
        root.left = inOrderToBST(l, mid-1, list);
        root.right = inOrderToBST(mid+1, h, list);
        return root;
    }

    public static TreeNode<Integer> balancedBst(TreeNode<Integer> root)
    {
        //    Write your code here.
        ArrayList<Integer>list = new ArrayList<>();
        inOrder(root, list);
        return inOrderToBST(0, list.size()-1, list);
    }
    //Time  Complexity - O(N)
    //Space Complexity - O(N)
}
