package linkedList.problems;

import linkedList.SinglyLinkedList;

public class Palindrome {
    Node head;
    int size=0;
    class Node{
        Integer data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    public void addLast(int data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
            return;
        }
        Node lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = temp;

    }
    public void display(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static int getLength(Node head){
    Node temp = head;
    int count=0;
    while(temp!=null){
        count++;
        temp=temp.next;
    }
    return count;
    }
    public static boolean isPalindrome(Node head) {
        // Write your code here!
        if (head == null || head.next == null) {
            return true; // An empty list or a list with a single node is a palindrome.
        }
        int length = getLength(head);
        int mid = length/2;
        Node temp1 = head;
        for(int i=1;i<mid;i++){
            temp1=temp1.next;
        }
        Node head1 = head;
        Node head2 = temp1.next;
        temp1.next=null;

        //Reverse second half
        Node prev=null;
        Node curr = head2;
        while(curr!=null){
            Node forward = curr.next;
            curr.next=prev;
            prev = curr;
            curr=forward;
        }

        //Now compare both halves
        while(head1!=null && prev!=null){
            if(!head1.data.equals(prev.data)){
                //Check datatype of data in Node class
                //thats why .equals() is used
                return false;
            }else{
                head1=head1.next;
                prev=prev.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome list = new Palindrome();
        list.addLast(1);
        //list.addLast(2);
//        list.addLast(2);
        list.addLast(0);
        System.out.println(isPalindrome(list.head));
    }
}
