package binarySearchTree;

import javax.swing.tree.TreeNode;

public class KthSmallestInBST {
      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  //--------------------------------------------------------------------------------------------------------------------
    public static int solve(TreeNode root, int[] count, int k) {
        if (root == null) {
            return -1;
        }

        // L
        int left = solve(root.left, count, k);
        if (left != -1) {
            return left;
        }
        // N
        count[0]++;
        if (count[0] == k) {
            return root.val;
        }
        // R
        int right = solve(root.right, count, k);
        if(right!=-1){
            return right;
        }
        return -1;
    }

    public static int kthSmallest(TreeNode root, int k) {
        // Array to hold count as a reference
        int[] count = {0};
        return solve(root, count, k);
    }
    //Time  Complexity - O(N)
    //Space Complexity - O(H)
    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
}
