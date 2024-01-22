package linkedList.problems;

public class MiddleNode {
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
    public void display(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static int getlength(Node head){
        int count =0;
        Node curr = head;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        return count;
    }
    public static Node findMiddle(Node head)
    {
        // Write your code here.
        //For even return second middle node
        int mid = getlength(head)/2 +1;
        Node curr = head;
        for(int i=1;i<mid;i++){
            curr = curr.next;
        }
        return curr;
    }
    //Best Approach
    public static Node findMid(Node head) {
        //For even return second middle node
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    Node getMiddle(Node h) {

        //No need of returning second middle node incase of even
        // Base case
        if (h == null)
            return h;
        Node fastptr = h.next;
        Node slowptr = h;

        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null) {
            fastptr = fastptr.next;
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        return slowptr;
    }
    public static void main(String[] args) {
        MiddleNode list = new MiddleNode();
        for(int i=1;i<=6;i++){
            list.addLast(i);
        }
        list.display();
        System.out.println();
        Node mid = list.getMiddle(list.head);
        System.out.println("Middle Node: "+mid.data+"\nAddress: "+mid);
    }
}
