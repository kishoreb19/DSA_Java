package linkedList.problems;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenMultiLevelLL {
    class Node {
        int data;
        Node next;
        Node child;

        public Node(int data) {
            this.data = data;
        }
    }
    public Node flattenMultiLinkedListWithQueue(Node head) {
        // Write you code here.
        if(head==null) return null;
        Queue<Node> q = new LinkedList<>();
        Node newList = new Node(-1);
        Node tail = newList;
        while(head!=null){
            if(head.child!=null){
                q.add(head.child);
            }
            tail.next = head;
            tail = tail.next;
            head = head.next;
            if(head==null && !q.isEmpty()){
                head = q.poll();
            }
        }
        return newList.next;
        //Time Complexity - O(N)
        //Space Complexity -O(N)
    }

    static Node moveTailToEnd(Node head){
        while(head.next!=null){
            head = head.next;
        }
        return head;
    }

    public Node flattenMultiLinkedListWithoutQueue(Node head) {
        // Write you code here.
        Node dummy = new Node(-1);
        Node dummyTail = dummy;
        Node tail = head;
        Node curr = head;
        while(curr!=null){
            tail = moveTailToEnd(tail);
            if(curr.child!=null){
                tail.next = curr.child;
                tail = moveTailToEnd(tail);
            }
            dummyTail.next = curr;
            dummyTail = curr;
            curr=curr.next;
        }
        return dummy.next;
        //Time Complexity - O(N^2)
        //Space Complexity -O(N)
    }
    //https://www.codingninjas.com/studio/problems/flatten-the-multi-level-linked-list_839810
}
