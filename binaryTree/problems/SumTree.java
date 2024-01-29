package binaryTree.problems;

public class SumTree {
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
    Pair<Boolean,Integer> isSumTreeFast(Node root){
        if (root == null) {
            return new Pair<>(true, 0);
        }

        if (root.left == null && root.right == null) { // Leaf Nodes
            return new Pair<>(true, root.data);
        }

        Pair<Boolean, Integer> left = isSumTreeFast(root.left);
        Pair<Boolean, Integer> right = isSumTreeFast(root.right);

        boolean sum = (root.data == (left.second + right.second));
        boolean isSumTree = sum && left.first && right.first;
        int totalSum = root.data + left.second + right.second;

        return new Pair<>(isSumTree, totalSum);
        //Time Complextity - O(N)
        //Space Complexity - O(H) H: height of the tree
    }
    boolean isSumTree(Node root)
    {
        // Your code here
        return isSumTreeFast(root).first;
        //https://www.geeksforgeeks.org/problems/sum-tree/1
    }
}
