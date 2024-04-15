package binarySearchTree;

public class SearchInBST {
    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //Using Recursion
    public static boolean searchInBST_Recursion(BinaryTreeNode root, int x) {
        // Write your code here.
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }else if(x<root.data){
            return searchInBST_Recursion(root.left, x);
        }else{
            return searchInBST_Recursion(root.right, x);
        }
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }
    //Iterative Method
    public static boolean searchInBST(BinaryTreeNode root, int x) {
        // Write your code here.
        BinaryTreeNode temp = root;
        while(temp!=null){
            if(temp.data==x){
                return true;
            }
            if(x<temp.data){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return false;
        //Time  Complexity - O(N)
        //Space Complexity - O(1)
        //https://www.naukri.com/code360/problems/search-in-bst_1402878?leftPanelTabValue=PROBLEM
    }
}
