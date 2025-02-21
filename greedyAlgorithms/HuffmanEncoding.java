package greedyAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffmanEncoding {

    class Node{
        int data;
        char ch;
        Node left, right;
        Node(int data, char ch){
            this.data = data;
            this.ch = ch;
            this.left = null;
            this.right = null;
        }
    }

    void preOrderTraversal(Node root, String temp, ArrayList<String> ans){
        if(root.left == null && root.right == null){
            ans.add(temp.length() == 0 ? "0" : temp);
            return;
        }

        preOrderTraversal(root.left,temp+"0",ans);
        preOrderTraversal(root.right,temp+"1",ans);
    }

    public ArrayList<String> huffmanCodes(String s, int f[], int n) {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b)-> (a.data != b.data) ? a.data - b.data : 1);

        for(int i=0; i<n; i++){
            pq.add(new Node(f[i],s.charAt(i)));
        }

        while(pq.size() > 1){
            Node a = pq.poll();
            Node b = pq.poll();

            Node temp = new Node(a.data + b.data, '-');
            temp.left = a;
            temp.right = b;
            pq.add(temp);
        }

        Node root = pq.poll();

        ArrayList<String> ans = new ArrayList<>();

        preOrderTraversal(root,"",ans);

        return ans;
        //Time  Complexity - O(NlogN)+O(NlogN)+O(N) -> O(NlogN)
        //Space Complexity - O(N)+O(N)+O(N)+O(N) -> O(N)
    }
    //https://www.geeksforgeeks.org/problems/huffman-encoding3345/1
}
