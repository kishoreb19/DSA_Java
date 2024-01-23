package linkedList.problems;

import java.util.PriorityQueue;

public class FlattenLinkedList {

    class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }
    public  Node flatten(Node root) {
        //Write your code here
        Node curr = root;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        while(curr!=null){
            q.add(curr.data);
            Node flat = curr.bottom;
            while(flat!=null){
                q.add(flat.data);
                flat = flat.bottom;
            }
            curr = curr.next;
        }
        Node dummy = new Node(-1);
        Node tail = dummy;
        while(!q.isEmpty()){
            Node temp = new Node(q.poll());
            tail.bottom = temp;
            tail = tail.bottom;
        }
        return dummy.bottom;
        //Time Complexity - O(NLogN)
        //Space Complexity - O(N)
    }
    //https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
}
