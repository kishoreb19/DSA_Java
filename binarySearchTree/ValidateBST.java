package binarySearchTree;

public class ValidateBST {
    static class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    static boolean solve(BinaryTreeNode root, int min, int max){
        if(root==null){
            return true;
        }
        if(min<=root.data && root.data<=max){
            boolean left = solve(root.left, min, root.data);
            boolean right = solve(root.right,root.data,max);
            return left && right;
        }else{
            return false;
        }
        //Time Complexity - O(N)
        //Space Complexity - O(H)
        //https://www.naukri.com/code360/problems/validate-bst_799483?leftPanelTab=0&leftPanelTabValue=PROBLEM
    }
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        return solve(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
