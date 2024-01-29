package binaryTree.problems;

public class DiameterOfBinaryTree {
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
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public Pair diameterFast(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        //'first' stores diameter and 'second' stores height of the tree
        //get diameter and height of left & right subtrees
        Pair left = diameterFast(root.left);
        Pair right = diameterFast(root.right);

        int op1 = left.first;//Diameter of left subtree
        int op2 = right.first;//Diameter of right subtree
        int op3 = left.second + right.second + 1; //height of left subtree + height of right subtree + root

        int diameter = Math.max(op1, Math.max(op2, op3));
        int height= Math.max(left.second, right.second) + 1;

        return new Pair(diameter,height);
        //Time Complextity - O(N)
        //Space Complexity - O(H) H: height of the tree
    }

    public int diameter(Node root) {
        return diameterFast(root).first;
    }
    //https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1
}
