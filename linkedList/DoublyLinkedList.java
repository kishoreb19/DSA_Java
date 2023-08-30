package linkedList;

public class DoublyLinkedList {
    Node head;
    int size = 0;
    class Node {
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
            size++;
        }
    }
    public void addFirst(int data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }
    public void addLast(int data){
        Node temp = new Node(data);
        Node obj = head;
        if(head == null){
            head = temp;
            return;
        }
        while(obj.next != null){
            obj = obj.next;
        }
        obj.next = temp;
        temp.prev = obj;
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
        temp.prev = currNode;
        currNode.next = temp;
    }
    public int getSize(){
        return size;
    }
    public void display(){
        Node currNode = head;
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Doubly Linked List");
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(8);
        list.insertAt(1,6);
        list.display();
        System.out.println("\nSize : " + list.getSize());


    }
}
