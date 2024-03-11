package binaryTree.problems;

import java.util.ArrayList;

public class KSumPath {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public int count =0;
    void solve(Node root, int k, ArrayList<Integer> path) {
        // Base case
        if (root == null)
            return;

        path.add(root.data);

        // Check for K Sum
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k)
                count++;
        }

        solve(root.left, k, path);
        solve(root.right, k, path);

        path.remove(path.size() - 1);
    }

    int sumK(Node root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        solve(root, k,path);
        return count;
        //Time Complexity - O(N) as we are traversing each node only once
        //Space Complexity - O(Height of Tree)
        //https://www.geeksforgeeks.org/problems/k-sum-paths/1
    }
}
