package linkedList.problems;

import java.util.HashMap;
import java.util.Map;

public class CheckCircularLL {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    void insert(int element,int data){
        if(head == null){//Empty List
            Node temp = new Node(data);
            head = temp;
            temp.next = temp;
        }else{//Assuming at least one element is present
            Node currNode = head;
            Node temp = new Node(data);
            while (currNode.data != element){
                currNode = currNode.next;
            }//Element found !
            temp.next = currNode.next;
            currNode.next = temp;
        }
    }

    void delete(int element){
        if(head==null){
            System.out.println("Empty Circular Linked List");
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr.data != element){
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = curr.next;
        //For Single Node
        if(curr==prev){
            head=null;
        }
        //>=2 Node
        if(head==curr){
            //When deleting first element
            //Since head is pointing to curr and after deleting curr head will point to null which will throw error
            head = prev;
            //We can point head anywhere as it is a Circular Linked List
        }
        curr.next = null;
    }
    void display(){
        //We will create another pointer 'currNode' and will print data and shift it till it meets head
        //In other words we will print and shift head till it returns to its original position
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }
        Node currNode = head;
        do{
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }while (currNode != head);
        //Used do-while loop because we need to run at least once (currNode = currNode.next) to shift currNode from pointing to tail.
        //as currNode = head and in do-while loop the condition is currNode != head.
        //read twice to understand.
    }
    public boolean isCircular(Node head) {
        // Write your code here.
        if(head == null){
            return true;
        }
        Node temp = head;
        do{
            temp = temp.next;
        }while(temp != null && temp != head);
        return temp==head;
    }
    public boolean isCircularUsingMap(Node head) {
        if (head == null) {
            return false; // An empty list is not circular.
        }

        Node temp = head;
        Map<Node, Boolean> visited = new HashMap<>();

        while (temp != null) {
            if (visited.containsKey(temp) && visited.get(temp)) {
                return true; // Cycle detected.
            } else {
                visited.put(temp, true);
                temp = temp.next;
            }
        }

        return false; // No cycle found.
    }
    public boolean isCircularUsingFloyd(Node head) {
        // If head is already NULL, then it is the circular linked list
        // with length zero.
        if (head == null) {
            return true;
        }
        // If next pointer of head is already NULL, then it the linear linked
        // list of length 1, hence we return false here.
        if (head.next == null) {
            return false;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            if(fast!=null){
                fast=fast.next;
            }
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        // After completing the traversal, if slow and fast pointers meet and
        // the node of meeting is node pointed by head, then linkedlist is circular.
        if (slow == fast && slow == head) {
            return true;
        }
        // If linkedlist is not circular, then return false.
        return false;
    }

    public static void main(String[] args) {
        CheckCircularLL list = new CheckCircularLL();
        for (int i=0;i<=5;i++){
            list.insert(i,i+1);
        }
        list.display();
        System.out.println();
        System.out.println("Using Two Pointer: "+list.isCircular(list.head));
        System.out.println("Using Map: "+list.isCircularUsingMap(list.head));
        System.out.println("Using Floyd Cycle Detection: "+list.isCircularUsingFloyd(list.head));
    }
}
