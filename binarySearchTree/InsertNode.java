package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class InsertNode {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node root; // Make root a global variable

    static Node insertIntoBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertIntoBST(root.left, data);
        } else {
            root.right = insertIntoBST(root.right, data);
        }
        return root;
    }

    static void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data (-1 to stop): ");
        int data = sc.nextInt();
        while (data != -1) {
            root = insertIntoBST(root, data); // Update the global root
            data = sc.nextInt();
        }
        sc.close();
    }

    static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                Node temp = q.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            System.out.println();
        }
    }

    static void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        takeInput();
        //10 8 21 7 27 5 4 3 -1
        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);
        System.out.println("InOrder traversal of BST is always in a sorted manner : ");
        inOrderTraversal(root);
    }
}
