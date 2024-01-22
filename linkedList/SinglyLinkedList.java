package linkedList;

import java.util.HashMap;
import java.util.Map;

public class SinglyLinkedList {
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
    public void addFirst(int data){
        Node temp = new Node(data);
        if(head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
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
    public void insertAt(int index,int data){
        if(index>size || index<0){
            System.out.println("Invalid Index");
            return;
        }
        Node temp = new Node(data);
        Node currNode = head;
        for(int i=0;i<index-1;i++) {
            currNode = currNode.next;
        }
        temp.next = currNode.next;
        currNode.next = temp;
    }
    public void removeFirst(){
        if(head == null){
            System.out.println("Empty Linked List");
        }
        else{
            head = head.next;
            size--;
        }
    }
    public void removeLast(){
        if(head == null){
            System.out.println("Empty Linked List");
            return;
        }

        if(head.next == null){ //If only one node is present
            head=null;
            size--;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        size--;
    }
    public void display(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    public int getSize(){
        return size;
    }


    //Optional functions
        public  Node reverse(Node head){
        if(head==null || head.next == null){
            return head;
        }
        Node chotahead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return chotahead;
        //Time Complexity - O(N)
        //Space Complexity - O(N)
    }

    public static boolean detectLoop(Node head){
        if(head == null){
            return false;
        }
        Map<Node, Boolean> map = new HashMap<>();
        Node curr = head;
        while (curr != null){
            if(map.get(curr)){
                return true;
            }
            map.put(curr,true);
            curr = curr.next;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Singly Linked List");
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(detectLoop(list.head));
        list.display();
        System.out.println();
    }
}