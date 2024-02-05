import binaryTree.BTBuild_Traversal;

import java.util.*;

public class Test {

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

    static void traverseLeaf(Node root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.println(root.data);
        }
        traverseLeaf(root.left);
        traverseLeaf(root.right);
    }
    static int fibo(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibo(n-2)+fibo(n-1);
    }
    static void traverseLeft(Node root){
        if(root==null){
            return;
        }

        traverseLeft(root.left);
        System.out.println(root.data);
    }
    public static void main(String[] args) {
        //1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
//        Node root = buildTree();
//        System.out.println("\nLevel Order:");
//        levelOrderTraversal(root);
//        System.out.println("\nLeaf:");
//        traverseLeaf(root);
//        System.out.println("kkkk");
//        traverseLeft(root);
        String s = "   helooo wrodl bro   ";
       // s= Arrays.toString(s.trim().split(" "));
        s= s.strip();
        System.out.println(s);
    }
}