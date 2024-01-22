package linkedList.problems;

public class Add2Numbers {
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
    public static void display(Node t){
        while(t != null){
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }
    //------------------------------------------------------------------------------------------------------------------
    static Node reverse(Node head){
        if(head==null || head.next == null){
            return head;
        }
        Node chotahead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return chotahead;
    }
    //Function to add two numbers represented by linked list.
     Node addTwoLists(Node first, Node second){
        Node firstRev = reverse(first);
        Node secondRev = reverse(second);

        int carry = 0;
        Node newNode = null;
        Node head = null;
        while(firstRev!=null || secondRev !=null || carry != 0){

            int val1 =0, val2=0;
            if(firstRev != null){
                val1 = firstRev.data;
            }
            if(secondRev != null){
                val2 = secondRev.data;
            }

            int sum = carry+val1+val2;
            int digit = sum%10;
            //Creating Node and adding it to newNode
            Node temp = new Node(digit);

            if(newNode==null){
                newNode = temp;
                head = temp;
            }else{
                newNode.next = temp;
                newNode = temp;
            }

            carry = sum/10;

            if(firstRev != null){
                firstRev = firstRev.next;
            }
            if(secondRev != null){
                secondRev = secondRev.next;
            }
        }
        return reverse(head);
    }
    public static void main(String[] args) {
        Add2Numbers first = new Add2Numbers();
        first.addLast(4);
        first.addLast(5);
        Add2Numbers second = new Add2Numbers();
        second.addLast(9);
        second.addLast(5);
        second.addLast(5);
        Node result = first.addTwoLists(first.head,second.head);
        display(result);
    }
}
