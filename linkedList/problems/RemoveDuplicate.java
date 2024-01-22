package linkedList.problems;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicate{
    Node head;
    int size=0;
    class Node{
        int data;
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
//----------------------------------------------------------------------------------------------------------------------
    public Node removeDuplicateSorted(Node head){
        //For Sorted Linked List
        Node temp = head;
        while (temp != null){
            if((temp.next!=null) && temp.data == temp.next.data){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }
    public Node removeDuplicates_1(Node head) {
        if (head == null) return head;

        Node curr = head;
        while (curr != null) {
            Node temp = curr;
            while (temp.next != null) {
                if (curr.data==temp.next.data) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }
        return head;
        //Time Complexity - O(N^2)
        //Space Complexity - O(1)
    }

    //Using Map
    public Node removeDuplicates_2(Node head) {
        if(head==null) return null;

        Node curr = head;
        Node prev = null;
        Map<Integer,Boolean> visited = new HashMap<>();
        while(curr!=null){
            if(visited.containsKey(curr.data) && visited.get(curr.data)==true){
                prev.next = curr.next;

            }else{
                visited.put(curr.data,true);
                prev = curr;
            }
            curr = curr.next;

        }
        return head;
        //Time Complexity - O(N)
        //Space Complexity - O(N)
    }
    public static void main(String[] args) {
        RemoveDuplicate list = new RemoveDuplicate();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        list.addLast(4);
        list.addLast(5);
        list.addLast(5);
        list.addLast(6);
        list.addLast(6);
        list.addLast(10);
        System.out.print("Original : ");
        list.display();
        System.out.print("\nNew : ");
        list.removeDuplicates_2(list.head);
        list.display();
    }
}
