package linkedList.problems;

public class DetectRemoveLoop {
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
    Node tail = null;
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
        tail = temp;

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
//    public static boolean detectLoop(Node head){
//        if(head == null){
//            return false;
//        }
//        Map<Node, Boolean> map = new HashMap<>();
//        Node curr = head;
//        while (curr != null){
//            if(map.get(curr)){
//                return true;
//            }
//            map.put(curr,true);
//            curr = curr.next;
//        }
//        return false;
//    }
    //Floyd Cycle Detection (Tortoise and Hare Algorithm)
    public static Node detectLoop(Node head){
        if(head==null) return null;

        Node slow = head,fast = head;
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                return fast;
            }
        }
        return null;
    }
    public static Node getStartingNode(Node head){
        if(head==null) return null;

        Node intersection = detectLoop(head);
        if(intersection == null) return null;

        Node slow = head;
        while(slow!=intersection){
            slow = slow.next;
            intersection = intersection.next;
        }
        return intersection;
    }
    public static Node removeLoop(Node head){
        if(head == null){
            return null;
        }
        Node startingNode = getStartingNode(head);
        if(startingNode == null) return head;

        Node temp = startingNode;
        while (temp.next != startingNode){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    public static void main(String[] args) {
        DetectRemoveLoop list = new DetectRemoveLoop();
        for(int i=1;i<=5;i++){
            list.addLast(i);
        }
        list.tail.next = list.head.next;
        if(detectLoop(list.head)!=null){
            System.out.println("Loop is present");
        }
        if(getStartingNode(list.head)!=null){
            System.out.println("Present at : "+getStartingNode(list.head).data);
        }
        removeLoop(list.head);
        list.display();
    }
}