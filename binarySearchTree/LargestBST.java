package binarySearchTree;

public class LargestBST {
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
    //------------------------------------------------------------------------------------------------------------------
    static class Info{
        int max,min,count;
        boolean isBST;
        Info(int max, int min, int count, boolean isBST){
            this.max = max;
            this.min = min;
            this.count = count;
            this.isBST = isBST;
        }
    }

    static Info solve(TreeNode root, int[] maxBST){
        if(root==null){
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE,0,true);
        }

        Info left = solve(root.left,maxBST);
        Info right = solve(root.right,maxBST);

        Info currNode = new Info(0, 0, 0, false);
        currNode.max = Math.max(root.data,Math.max(left.max,right.max));
        currNode.min = Math.min(root.data,Math.min(left.min,right.min));
        currNode.count = left.count + right.count + 1;
        currNode.isBST = (left.max<root.data && root.data<right.min) && (left.isBST && right.isBST);
        if(currNode.isBST){
            maxBST[0] = Math.max(currNode.count,maxBST[0]);
        }
        return currNode;
    }
    public static int largestBST(TreeNode root) {
        // Write your code here.
        if(root==null) return 0;
        if(root.left == null && root.right==null) return 1;

        int []maxBST = {-1};
        solve(root,maxBST);
        return maxBST[0];
        //Time  Complexity - O(N)
        //Space Complexity - O(H)
        //https://www.naukri.com/code360/problems/largest-bst-subtree_893103?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
    }
}
