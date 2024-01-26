package stack;

public class StackImplementationLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next=null;
        }
    }
    int size=0;
    Node head,tail;

    public void push(int data){
        Node temp = new Node(data);
        if(head==null){
            head = temp;
            tail = temp;
        }else{
            tail.next = temp;
            tail = tail.next;
        }
        size++;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return -1;
        }
        int element = tail.data;
        if(head==tail){
            //Single element
            head=null;
            tail=null;
        }else{
            Node secondLast = head;
            while (secondLast.next != tail){
                secondLast = secondLast.next;
            }
            tail = secondLast;
            secondLast.next = null;
        }
        size--;
        return element;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return -1;
        }
        return tail.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return;
        }
        Node curr = head;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackImplementationLinkedList stack = new StackImplementationLinkedList();

        for(int i=1;i<=10;i++){
            stack.push(i);
        }
        stack.display();
        //Reverse Order
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
