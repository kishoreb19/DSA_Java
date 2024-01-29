package binaryTree.problems;

public class IsTreeIdentical {
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
    boolean isIdentical(Node root1, Node root2){
        // Code Here
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }

        boolean rootData = (root1.data == root2.data);
        boolean left = isIdentical(root1.left,root2.left);
        boolean right = isIdentical(root1.right,root2.right);

        return rootData && left && right;
    }
    //https://www.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
}
