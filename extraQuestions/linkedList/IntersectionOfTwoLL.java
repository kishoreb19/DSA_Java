package extraQuestions.linkedList;

public class IntersectionOfTwoLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        Node dummy = new Node(-1);
        Node dummyTail = dummy;
        while(head1!=null && head2 !=null){
            if(head1.data==head2.data){
                Node temp = new Node(head1.data);
                dummyTail.next = temp;
                dummyTail = dummyTail.next;
                head1 = head1.next;
                head2 = head2.next;
            }
            else if(head1.data < head2.data){
                head1 = head1.next;
            }
            else{
                head2 = head2.next;
            }
        }
        return dummy.next;
        //https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
        //https://www.youtube.com/watch?v=3cLRaWPiIxo
    }
}
