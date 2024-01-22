package linkedList.problems;

public class SplitCircularLL {
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
    void display(Node head){
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
    public int getLength(Node head){
        Node temp = head;
        int count=0;
        do{
            count++;
            temp=temp.next;
        }while (temp!=head);
        return count;
    }
    public Node split(Node head){
        int len = getLength(head);
        int mid = len/2 + 1;
        Node head1 = head;
        for(int i=1;i<mid;i++){
            head1=head1.next;
        }
        Node temp = head1.next;
        Node head2 = temp;
        head1.next=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=head2;
        return head2;
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        SplitCircularLL list = new SplitCircularLL();
        for(int i=1;i<=10;i++){
            list.insert(i-1,i);
        }
        list.display(list.head);
        System.out.println();
        Node head1= list.head;
        Node head2 = list.split(list.head);
        System.out.print("First  Half: ");list.display(head1);
        System.out.println();
        System.out.print("Second Half: ");list.display(head2);

    }
}
