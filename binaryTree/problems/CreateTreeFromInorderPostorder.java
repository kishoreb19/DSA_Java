package binaryTree.problems;

public class CreateTreeFromInorderPostorder {
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int value)
        {
            data = value;
            left = null;
            right = null;
        }
    }
    public static int findPosition(int[] in, int data, int inorderStart, int inorderEnd) {
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (in[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public static Node solve(int[] in, int[] post, int[] index, int inorderStart, int inorderEnd, int n) {
        if (index[0] <= -1 || inorderStart > inorderEnd) {
            return null;
        }

        int data = post[index[0]--];
        Node root = new Node(data);

        int pos = findPosition(in, data, inorderStart, inorderEnd);

        // Right Call
        root.right = solve(in, post, index, pos + 1, inorderEnd, n);

        //Left Call
        root.left = solve(in, post, index, inorderStart, pos - 1, n);

        return root;
    }
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        int[] index = {n-1};
        int inorderStart = 0;
        int inorderEnd = n - 1;

        return solve(in, post, index, inorderStart, inorderEnd, n);
        //Time  Complexity - O(N)
        //Space Complexity - O(H)
        //https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
    }
}
