package linkedList.problems;

public class ReverseLLInKGroups {
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
    public void insertAt(int index,int data){
        if(index>size || index<0){
            System.out.println("Invalid Index");
            return;
        }
        Node temp = new Node(data);
        Node currNode = head;
        for(int i=0;i<index-1;i++) {
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

        if(head.next == null){ //If only one node is present
            head=null;
            size--;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        size--;
    }
    public void display(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

//    public static Node kReverse(Node head, int k) {
//        // Write your code here.
//        if(head == null) {
//            return null;
//        }
//
//        //step1: reverse first k nodes
//        Node next = null;
//        Node curr = head;
//        Node prev = null;
//        int count= 0;
//
//        while(curr !=null && count<k) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//            count++;
//        }
//
//        //step2: Recursion dekhlega aage ka
//        if(next != null) {
//            head.next = kReverse(next,k);
//        }
//
//        //step3: return head of reversed list
//        return prev;
//    }

    public static boolean isGroupComplete(Node head, int k) {
        Node temp = head;
        int cnt = 0;
        while (temp != null && cnt < k) {
            temp = temp.next;
            cnt++;
        }
        if (cnt == k) {
            return true;
        }
        return false;
    }
    public static Node kReverse(Node head, int k) {
        // Write your code here.
        if (head == null) {
            return null;
        }
        if (isGroupComplete(head, k)) {
            Node prev = null;
            Node curr = head;
            Node next = null;
            int cnt = 0;
            while (curr != null && cnt < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cnt++;
            }
            if (next != null) {
                head.next = kReverse(next, k);
            }
            return prev;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseLLInKGroups list = new ReverseLLInKGroups();
        for(int i=1;i<=5;i++){
            list.addLast(i);
        }
        list.head = kReverse(list.head, 3);
        list.display();
    }
}
