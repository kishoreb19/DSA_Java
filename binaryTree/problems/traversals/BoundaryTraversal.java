package binaryTree.problems.traversals;

import java.util.ArrayList;

public class BoundaryTraversal {
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    void traverseLeft(Node root, ArrayList<Integer> list){
        if(root==null || root.left==null && root.right==null){
            return;
        }
        list.add(root.data);
        if(root.left!=null){//If left node exists
            traverseLeft(root.left,list);
        }else{ //Else go with right node
            traverseLeft(root.right,list);
        }
    }

    void traverseLeaf(Node root,ArrayList<Integer>list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            list.add(root.data);
        }
        traverseLeaf(root.left, list);
        traverseLeaf(root.right, list);
    }

    void traverseRight(Node root,ArrayList<Integer>list){
        if(root==null || root.left==null && root.right==null){
            return;
        }
        if(root.right!=null){
            traverseRight(root.right,list);
        }else{
            traverseRight(root.left,list);
        }
        //will add in reverse.
        list.add(root.data);
    }

    ArrayList <Integer> boundary(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return null;
        }
        result.add(root.data);

        traverseLeft(root.left,result);

        traverseLeaf(root.left,result);
        traverseLeaf(root.right,result);

        traverseRight(root.right,result);
        return result;
    }
    //https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
}
