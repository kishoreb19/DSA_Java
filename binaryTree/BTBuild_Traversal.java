package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BTBuild_Traversal {
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
    static Scanner sc = new Scanner(System.in);

    static Node buildTree(){
        System.out.print("Enter data (-1 for null): ");
        int data = sc.nextInt();
        if(data==-1){
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter data for inserting in left of "+data+": ");
        root.left = buildTree();
        System.out.println("Enter data for inserting in right of "+data+": ");
        root.right = buildTree();
        return root;
        //Time  Complexity - O(N) N: no. of nodes
        //Space Complexity - O(N)
    }

    static void printCurrentLevel(Node root,int level){
        if(level==0 || root==null) return;
        if(level==1){
            System.out.print(root.data+" ");
        }else{
            printCurrentLevel(root.left,level-1);
            printCurrentLevel(root.right,level-1);
        }
        //Time Complexity - O(N)
    }

    static void levelOrderTraversal(Node root){
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curr = q.poll();
            if(curr==null){
                if(q.isEmpty()) return;
                q.add(curr);
                System.out.println();
                continue;
            }
            System.out.print(curr.data+" ");
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
    }

    static void inOrderTraversal(Node root){
        //L N R
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    static void preOrderTraversal(Node root){
        //N L R
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root){
        //L R N
        if(root==null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        Node root = buildTree();
        //1 3 4 -1 -1 9 -1 -1 7 7 -1 -1 -1
        System.out.println("\nLevel Order Traversal");
        levelOrderTraversal(root);
        System.out.println("\nInOrder Traversal");
        inOrderTraversal(root);
        System.out.println("\nPreOrder Traversal");
        preOrderTraversal(root);
        System.out.println("\nPostOrder Traversal");
        postOrderTraversal(root);
    }
}

//buildTree():
//
//Time Complexity - O(N), where N is the number of nodes in the binary tree.
//This is because the methods visit each node exactly once during the tree construction process.
//
//Space Complexity - O(N), in the worst case, where N is the number of nodes in the binary tree.
//This is due to the space used by the function call stack during the recursive calls.

//levelOrderTraversal(Node root):
//
//Time Complexity - O(N),  where N is the number of nodes in the binary tree.
//This is because the method visits each node exactly once during the traversal.
//
//Space Complexity - O(W), where W is the maximum width of the binary tree at any level.
//In the worst case, when the binary tree is completely balanced, the maximum width is N/2
//at the last level, hence the space complexity is O(N).

//
//inOrderTraversal(Node root), preOrderTraversal(Node root), postOrderTraversal(Node root):
//
//Time Complexity - O(N), where N is the number of nodes in the binary tree.
//This is because the methods visit each node exactly once during the traversal.
//
//Space Complexity - O(H), where H is the height of the binary tree.
//This is due to the space used by the function call stack during the recursive calls.
//In the worst case, for a skewed binary tree, the height could be O(N), making the space complexity O(N).
