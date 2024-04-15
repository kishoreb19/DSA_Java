package binarySearchTree;
import java.util.*;
public class DeletionInBST {
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
    //------------------------------------------------------------------------------------------------------------------
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
    static Node deleteFromBST(Node root, int data){
        if(root==null){
            return root;
        }
        if(root.data==data){
            //For 0 Child
            if(root.left==null && root.right==null){
                return null;
            }
            //For 1 Child
            if(root.left!=null && root.right==null){
                Node temp = root.left;
                return temp;
            }
            if(root.right!=null && root.left==null){
                Node temp = root.right;
                return temp;
            }
            //For 2 Child
            if(root.left!=null && root.right!=null){
                int minVal = min(root.right);
                root.data = minVal;
                root.right = deleteFromBST(root.right,minVal);
                return root;
            }
        }
        if(data>root.data){
            root.right = deleteFromBST(root.right,data);

        }else{
            root.left = deleteFromBST(root.left,data);

        }
        return root;
    }

    public static void main(String[] args) {
        takeInput();
        //10 8 21 7 27 5 4 3 -1
        levelOrderTraversal(root);
        System.out.println("After Deletion");
        deleteFromBST(root,7);
        levelOrderTraversal(root);
    }
}
