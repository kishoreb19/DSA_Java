package binaryTree.problems;

public class CreateTreeFromInorderPreorder {
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

    public static Node solve(int[] in, int[] pre, int[] index, int inorderStart, int inorderEnd, int n) {
        if (index[0] >= n || inorderStart > inorderEnd) {
            return null;
        }

        int data = pre[index[0]++];
        Node root = new Node(data);

        int pos = findPosition(in, data, inorderStart, inorderEnd);

        // Left call
        root.left = solve(in, pre, index, inorderStart, pos - 1, n);

        // Right call
        root.right = solve(in, pre, index, pos + 1, inorderEnd, n);

        return root;
    }

    public static Node buildTree(int[] in, int[] pre, int n) {
        int[] index = {0};
        int inorderStart = 0;
        int inorderEnd = n - 1;

        return solve(in, pre, index, inorderStart, inorderEnd, n);
        //Time  Complexity - O(N)
        //Space Complexity - O(H)
        //https://www.geeksforgeeks.org/problems/construct-tree-1/1
    }
}
