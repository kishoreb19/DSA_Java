package heaps.problems;

import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    static class LinkedListNode<Integer> {
        int data;
        LinkedListNode<Integer> next;

        public LinkedListNode(int data) {
            this.data = data;
        }
    }
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        // Write your code here.
        LinkedListNode<Integer> head = null, tail=null;
        int k = listArray.length;
        PriorityQueue<LinkedListNode<Integer>> pq = new PriorityQueue<>((a, b) -> a.data-b.data);

        for(int i=0;i<k;i++){
            pq.add(listArray[i]);
        }

        while(!pq.isEmpty()){
            LinkedListNode<Integer> min = pq.poll();
            if(head==null){
                head = tail = min;
            }else{
                tail.next = min;
                tail = tail.next;
            }
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        tail.next = null;
        return head;
        //Time Complexity - O((n*k)log k)
        //Space Complexity - O(k)
    }
}
