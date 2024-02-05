package extraQuestions.linkedList;

public class ReverseDLL {
    static class Node{
        int data;
        Node next,prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node curr = head;
        Node prev = null;
        Node forward = null;
        while(curr!=null){
            forward = curr.next;
            curr.next = prev;
            curr.prev = forward;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
    //Using Recursion
    public static Node reverseDLL(Node head) {
        //Your code here
        if(head==null || head.next==null){
            return head;
        }
        Node chotaHead = reverseDLL(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next=null;

        return chotaHead;
    }
    //https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1
}
