package binaryTree.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CreateTreeFromLevelOrder {
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
    public static Node createTreeFromLevelOrderRecursion(int arr[], int i) {
        if (i < arr.length) {
            Node root = new Node(arr[i]);
            root.left = createTreeFromLevelOrderRecursion(arr, 2 * i + 1);
            root.right = createTreeFromLevelOrderRecursion(arr, 2 * i + 2);
            return root;
        }
        return null; // Return null when the index is out of bounds
    }

    public static Node createTreeFromLevelOrder(){
        Queue<Node> q = new LinkedList<>();
        System.out.println("Enter data for root (-1 for null): ");
        Scanner sc = new Scanner(System.in);
        Node root = new Node(sc.nextInt());
        q.add(root);
        while (!q.isEmpty()){
            Node curr = q.poll();
            System.out.println("Enter data to be inserted in left of "+curr.data+": ");
            int leftData = sc.nextInt();
            if(leftData!=-1){
                curr.left = new Node(leftData);
                q.add(curr.left);
            }
            System.out.println("Enter data to be inserted in right of "+curr.data+": ");
            int rightData = sc.nextInt();
            if(rightData!=-1){
                curr.right = new Node(rightData);
                q.add(curr.right);
            }
        }
        return root;
    }


    static void inOrderTraversal(Node root){
        //L N R
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
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

    public static void main(String[] args) {
        int[] arr = {1,3,7,4,9,7};
        Node root = createTreeFromLevelOrder();
//        Node root = createTreeFromLevelOrderRecursion(arr,0);
        inOrderTraversal(root);
        System.out.println();
        levelOrderTraversal(root);
    }
}
