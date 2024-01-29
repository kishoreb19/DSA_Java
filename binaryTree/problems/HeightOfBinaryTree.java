package binaryTree.problems;

public class HeightOfBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int height(Node node) {
        // code here
        if(node==null) return 0;
        int heightOfLeftTree  = height(node.left) ;
        int heightOfRightTree = height(node.right);
        return Math.max(heightOfLeftTree,heightOfRightTree) + 1;
        //Time  Complexity - O(N)
        //Space Complexity - O(H)
        // H: height N: Nodes
        //https://www.geeksforgeeks.org/problems/height-of-binary-tree/1
    }
}
