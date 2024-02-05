package extraQuestions.linkedList;

import java.util.ArrayList;
import java.util.Collections;

public class MergeKSortedLists {
 class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class LinkedListNode<T>{
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data){
            this.data = data;
            this.next = null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public Node merge(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node dummyTail = dummy;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                Node temp = new Node(head1.data);
                dummyTail.next = temp;
                dummyTail = dummyTail.next;
                head1 = head1.next;
            }else{
                Node temp = new Node(head2.data);
                dummyTail.next = temp;
                dummyTail = dummyTail.next;
                head2 = head2.next;
            }
        }
        while(head1!=null){
            Node temp = new Node(head1.data);
            dummyTail.next = temp;
            dummyTail = dummyTail.next;
            head1 = head1.next;
        }
        while(head2!=null){
            Node temp = new Node(head2.data);
            dummyTail.next = temp;
            dummyTail = dummyTail.next;
            head2 = head2.next;
        }
        return dummy.next;
    }
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        if(K==0){
            return null;
        }
        Node result = arr[0];
        for(int i=1;i<K;i++){
            result = merge(result,arr[i]);
        }
        return result;
        //Time Complexity - O(N log k)
        //Space Complexity - O(N) N:total no. of nodes
        //https://www.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
        //https://leetcode.com/problems/merge-k-sorted-lists/
    }
    //Another Method
    public static LinkedListNode<Integer> createLL(ArrayList<Integer> list) {
        LinkedListNode<Integer> dummy = new LinkedListNode<>(-1);
        LinkedListNode<Integer> dummyTail = dummy;
        for (int i = 0; i < list.size(); i++) {
            LinkedListNode<Integer> temp = new LinkedListNode<>(list.get(i));
            dummyTail.next = temp;
            dummyTail = dummyTail.next;
        }
        return dummy.next;
    }

    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        int k = listArray.length;
        if (k == 0) return null;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            LinkedListNode<Integer> temp = listArray[i];
            while (temp != null) {
                list.add(temp.data);
                temp = temp.next; // Move to the next node
            }
        }
        Collections.sort(list);
        return createLL(list);
        //Time Complexity - O(N log N)
        //Space Complexity - O(N) where N is the total number of nodes across all lists.
        //https://www.codingninjas.com/studio/problems/merge-k-sorted-lists_992772
    }
}
