package binaryTree.problems;

public class isBalanced {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    class Pair<T1,T2>{
        T1 first;
        T2 second;
        Pair(T1 first, T2 second){
            this.first = first;
            this.second = second;
        }
    }

    Pair<Boolean,Integer> isBalancedFast(Node root){
        if(root==null){
            return new Pair(true,0);
        }
        Pair<Boolean,Integer> left = isBalancedFast(root.left);
        Pair<Boolean,Integer> right = isBalancedFast(root.right);

        boolean isBalanced = left.first && right.first && Math.abs(left.second - right.second) <= 1;
        int height = Math.max(left.second, right.second) + 1;

        return new Pair<>(isBalanced, height);
        //Time Complextity - O(N)
        //Space Complexity - O(H) H: height of the tree
    }
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        // Your code here
        return isBalancedFast(root).first;
    }
    //A tree is height balanced if difference between heights of left and right subtrees
    //is not more than one for all nodes of tree.
    //(left and right subtree of the tree should also be balanced).

    //https://www.geeksforgeeks.org/problems/check-for-balanced-tree/1
}
