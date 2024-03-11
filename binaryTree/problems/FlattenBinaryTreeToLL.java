package binaryTree.problems;

public class FlattenBinaryTreeToLL {
    public static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void flatten(Node root){
        //Without Recursion or Stack
        //Time Complexity - O(N)
        //Space Complexity - O(1)
        Node curr = root;
        while(curr!=null){
            if(curr.left!=null){
                Node pred = curr.left;
                while(pred.right!=null){
                    pred = pred.right;
                }
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    public static Node flatten_recursion(Node root) {
        // Write your code here.
        if(root==null){
            return root;
        }
        Node left = flatten_recursion(root.left);
        Node right = flatten_recursion(root.right);
        if(left!=null){
            root.right = left;
            root.left = null;
            while(left.right!=null){
                left = left.right;
            }
            left.right = right;
        }
        return root;
        //Time Complexity - O(N)
        //Space Complexity - O(N)
    }
}
