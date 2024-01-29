package linkedList;

public class DoublyCircularLinkedList {
    int size=0;
    class Node{
        int data;
        Node next,prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }
    Node head;
    public void insert(int element,int data){
        Node temp = new Node(data);
        if(head==null){
            head = temp;
            head.next = head;
            head.prev = head;
            return;
        }
        Node curr = head;
        boolean found = false;
//        while(curr.data!=element){
//            curr = curr.next;
//        }
        do{
            if(curr.data==element){
                found = true;
                break;
            }
        }while (curr!=head);
        if(!found){
            System.out.println("Element not found!");
            return;
        }
        //Inserting new Node
        Node forward = curr.next;
        curr.next = temp;
        temp.prev = curr;
        temp.next = forward;
        forward.prev = temp;

        //Pointing head's prev to last node
        curr = head;
        while (curr.next!=head){
            curr = curr.next;
        }
        head.prev = curr;
    }

    public void delete(int element){
        if(head==null) {
            System.out.println("Empty Doubly Circular Linked List");
            return;
        }
        //Single node
        if(head.next==head){
            head=null;
            size--;
            return;
        }

        boolean found = false;
        Node curr = head;
        do{
           if(curr.data==element){
               found=true;
               return;
           }
           curr=curr.next;
        }while (curr != head);
        if (!found) {
            System.out.println("Element not found in the list");
            return;
        }
        //If the Node to be deleted is head
        if (curr == head) {
            head = head.next;
        }

        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
        size--;
    }

    public int getSize(){
        return size;
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
        System.out.println();
    }



    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        for(int i=0;i<6;i++){
            list.insert(i,i+1);
        }
        //list.delete(1);
        list.display();
    }
}
