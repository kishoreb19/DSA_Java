package binarySearchTree;

import java.util.Scanner;

public class Min_Max_BST {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
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

    static int min(Node root){
        Node temp = root;
        while (temp.left!=null){
            temp = temp.left;
        }
        return temp.data;
    }
    static int max(Node root){
        Node temp = root;
        while (temp.right!=null){
            temp = temp.right;
        }
        return temp.data;
    }

    public static void main(String[] args) {
        takeInput();
        System.out.println("MIN : "+min(root)+" MAX : "+max(root));
    }
}
