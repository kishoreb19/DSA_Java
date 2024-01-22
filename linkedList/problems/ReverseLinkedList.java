package linkedList.problems;

import linkedList.SinglyLinkedList;

/*
	Following is the structure of the Singly Linked List.
	class LinkedListNode<T>
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data)
        {
        	this.data = data;
    	}
	}
    https://www.codingninjas.com/studio/problems/reverse-the-singly-linked-list_799897
    Given a singly linked list of integers. Your task is to return the head of the reversed linked list.
    For example:
    The given linked list is 1 -> 2 -> 3 -> 4-> NULL. Then the reverse linked list is 4 -> 3 -> 2 -> 1 -> NULL and the head of the reversed linked list will be 4.
*/
public class ReverseLinkedList {
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
    public void display(Node head){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    // Using recursion
    public static Node reverseUsingRecursion(Node head){
        if(head==null || head.next == null){
            return head;
        }
        Node chotahead = reverseUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return chotahead;
        //Time Complexity - O(N)
        //Space Complexity - O(N)
    }
    public static Node reverseLinkedList(Node head)
    {
        // Write your code here!
        if(head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        for(int i=1;i<=5;i++){
            list.addLast(i);
        }
        list.display(list.head);
        System.out.println();
//        list.display(reverseLinkedList(list.head));
//        System.out.println();
        list.display(reverseUsingRecursion(list.head));

    }
}
