package binarySearchTree;

public class LCA {
    class TreeNode {
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
    //Using Recursion
    public static TreeNode LCAinaBST_Recursion(TreeNode root, TreeNode p, TreeNode q) {
        // Write your code here.
        if(root==null){
            return root;
        }
        if(root.data<p.data && root.data<q.data){
            return LCAinaBST_Recursion(root.right, p, q);
        }
        if(root.data>p.data && root.data>q.data){
            return LCAinaBST_Recursion(root.left, p, q);
        }
        return root;
        //Time  Complexity - O(N)
        //Space Complexity - O(H)
    }
    //Using Iterative Method
    public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
        // Write your code here.
        while(root!=null){
            if(root.data<p.data && root.data<q.data){
                root = root.right;
            }else if(root.data>p.data && root.data>q.data){
                root = root.left;
            }else{
                return root;
            }
        }
        return null;
        //Time  Complexity - O(N)
        //Space Complexity - O(1)
    }
}
