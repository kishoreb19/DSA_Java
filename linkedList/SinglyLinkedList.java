package linkedList;

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
            return;
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
    public void insertAt(int pos,int data){
        if(pos>size || pos<0){
            System.out.println("Invalid Position");
            return;
        }
        Node temp = new Node(data);
        Node currNode = head;
        for(int i=0;i<pos-1;i++) {
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
        size--;
        if(head.next == null){ //If only one node is present
            head=null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
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
    public static void main(String[] args) {
        System.out.println("Singly Linked List");
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(2);
        list.addLast(3);
        list.addFirst(1);
        list.insertAt(1,9);
        list.insertAt(3,7);
//        list.removeLast();
//        list.removeLast();
//        list.removeLast();

        list.display();
        System.out.println("\nSize : "+ list.getSize());
//        Node n = list.new Node(6);
//        System.out.println(n.data);
    }
}