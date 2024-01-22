package linkedList;

public class CircularLinkedList {
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
    public static boolean isCircular(Node head) {
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
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        for (int i=0;i<=0;i++){
            list.insert(i,i+1);
        }
        list.delete(1);
        System.out.println(list.isCircular(list.head));
        list.display();
    }
}
