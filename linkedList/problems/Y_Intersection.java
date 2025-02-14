package linkedList.problems;

import java.util.HashSet;
import java.util.Set;

public class Y_Intersection {
    class Node {
        int data;
        Node next;
        Node(int d)  {
            data = d;
            next = null;
        }
    }

    // Function to find intersection point in Y shaped Linked Lists.

    int intersectPoint(Node head1, Node head2) {
        // code here
        Set<Node> set = new HashSet<>();

        while(head1!=null){
            if(set.contains(head1)){
                return head1.data;
            }
            set.add(head1);
            head1=head1.next;
        }

        while(head2!=null){
            if(set.contains(head2)){
                return head2.data;
            }
            set.add(head2);
            head2=head2.next;
        }
        return -1;
        //Time  Complexity - O(N+M)
        //Space Complexity - O(N+M)
    }

    int intersectPoint_Optimized(Node head1, Node head2) {
        // code here
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1!=null && temp2!=null){
            if(temp1==temp2){
                return temp1.data;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
            if(temp1==null && temp2==null){
                return -1;
            }
            if(temp1==null){
                temp1 = head2;
            }
            if(temp2==null){
                temp2 = head1;
            }
        }
        return -1;
        //Time  Complexity - O(N+M)
        //Space Complexity - O(1)
    }
    //https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
    //https://youtu.be/F7iGLGpGRUQ?si=4ZPDJ39-NNTm6rCk
}
