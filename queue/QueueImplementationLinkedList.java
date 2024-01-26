package queue;

public class QueueImplementationLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    int size=0;
    Node head,tail;
    public void push(int data){
        Node temp = new Node(data);
        if(head==null){
            head = tail = temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    public int pop(){
        if(head==null){
            System.out.println("Queue is empty!");
            return -1;
        }
        int element = head.data;
        if(head==tail){//Single Element
            head=tail=null;
        }else{
            head = head.next;
        }
        size--;
        return element;
    }

    public int front(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        return head.data;
    }

    public int rear(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        return tail.data;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public int size(){
        return size;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty !");
            return;
        }
        Node curr = head;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueImplementationLinkedList queue = new QueueImplementationLinkedList();
        for(int i=1;i<=5;i++){
            queue.push(i);
        }
        System.out.print("Front: "+queue.front()+" ");
        System.out.println("Rear: "+queue.rear());
        while (!queue.isEmpty()){
            System.out.print(queue.pop()+" ");
        }
        System.out.println();
        queue.display();
        System.out.println("Size: "+queue.size());
    }
}
