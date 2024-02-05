package extraQuestions.linkedList;

import java.util.ArrayList;
import java.util.Collections;

public class SortBiotonicDLL {
    static class Node<T>{
        T data;
        Node<T> next,prev;
        Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static Node<Integer> createLL(ArrayList<Integer> list) {
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> dummyTail = dummy;
        for (int i = 0; i < list.size(); i++) {
            Node<Integer> temp = new Node<>(list.get(i));
            dummyTail.next = temp;
            temp.prev=dummyTail;
            dummyTail = dummyTail.next;
        }
        dummy.next.prev=null;
        return dummy.next;
    }
    public static Node<Integer> sortDLL(Node<Integer> head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.data);
            head=head.next;
        }
        Collections.sort(list);
        return createLL(list);
        //Time Complexity - O(N log N)
        //Space Complexity - O(N)
    }
    //Another Method
    static Node<Integer> reverse(Node<Integer>head){
        if(head==null || head.next==null){
            return head;
        }
        Node<Integer>curr = head;
        Node<Integer>prev = null;
        Node<Integer>forward = null;
        while(curr!=null){
            forward = curr.next;
            curr.next = prev;
            curr.prev = forward;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    static Node<Integer> getPeak(Node<Integer>head){
        if(head==null || head.next==null){
            return head;
        }
        while(head.next!=null && head.data<head.next.data){
            head = head.next;
        }
        return head;
    }

    static Node<Integer> merge(Node<Integer> head1, Node<Integer>head2){
        Node dummy = new Node(-1);
        Node dummyTail = dummy;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                Node<Integer> temp = new Node(head1.data);
                dummyTail.next = temp;
                temp.prev = dummyTail;
                dummyTail = dummyTail.next;
                head1=head1.next;
            }else{
                Node<Integer> temp = new Node(head2.data);
                dummyTail.next = temp;
                temp.prev = dummyTail;
                dummyTail = dummyTail.next;
                head2=head2.next;
            }
        }
        while(head1!=null){
            Node<Integer> temp = new Node(head1.data);
            dummyTail.next = temp;
            temp.prev = dummyTail;
            dummyTail = dummyTail.next;
            head1=head1.next;
        }
        while(head2!=null){
            Node<Integer> temp = new Node(head2.data);
            dummyTail.next = temp;
            temp.prev = dummyTail;
            dummyTail = dummyTail.next;
            head2=head2.next;
        }
        dummy = dummy.next;
        dummy.prev = null;
        return dummy;
    }

    public static Node<Integer> sortDLL_Another(Node<Integer> head) {
        // Write your code here.
        if(head==null || head.next==null){
            return head;
        }
        Node<Integer> peak = getPeak(head);
        Node<Integer> head1 = head;
        Node<Integer> head2 = peak.next;
        peak.next = null;
        if(head2!=null){
            head2.prev = null;
            head2 = reverse(head2);
        }
        return merge(head1,head2);
        //Time Complexity - O(N log N)
        //Space Complexity - O(N)
    }
    //https://www.codingninjas.com/studio/problems/sort-biotonic-dll_981293
}
