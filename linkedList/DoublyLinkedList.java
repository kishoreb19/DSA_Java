package linkedList;

public class DoublyLinkedList {
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

    Node head;
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
        Node currNode = head;
        if(head == null){
            head = temp;
            return;
        }
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = temp;
        temp.prev = currNode;
    }
    public void insertAt(int index,int data){
        if(index>size || index<0){
            System.out.println("Invalid Index");
            return;
        }
        if(index==0){
            addFirst(data);
        }
        Node temp = new Node(data);
        Node currNode = head;
        for(int i=0;i<index-1;i++) {
            currNode = currNode.next;
        }
        temp.next = currNode.next;
        temp.prev = currNode;
        currNode.next = temp;
    }

    public int getSize(){
        return size;
    }
    public void remove(int index){
        if(index>size || index<0){
            System.out.println("Invalid Index");
            return;
        }
        if(index==0){
            Node currNode = head;

            head = head.next;
            currNode.next.prev = null;
            currNode.next=null;
        }else{
            Node secondLast = head;
            Node currNode = head.next;
            for(int i=0;i<index-1;i++){
                currNode = currNode.next;
                secondLast = secondLast.next;
            }

            currNode.prev = null;
            secondLast.next = currNode.next;
//           System.out.println(currNode.next.prev.data);
//            currNode.next.prev = secondLast;
//            System.out.println(currNode.next.prev.data);
            currNode.next = null;
        }
    }
    public void display(){
        Node currNode = head;
        while (currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    //Reverse DLL
    public static Node reverseDLL(Node head)
    {
        // Write your code here.
        if(head==null || head.next==null){
            return head;
        }
        Node chotahead = reverseDLL(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;
        return chotahead;
    }

    public static void main(String[] args) {
        System.out.println("Doubly Linked List");
        DoublyLinkedList list = new DoublyLinkedList();
        for(int i=1;i<=5;i++){
            list.addLast(i);
        }
        //list.remove(0);
        list.insertAt(3,0);
        list.display();

    }
}
