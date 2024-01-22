package linkedList.problems;

public class MergeSortedLinkedLists {
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
    public void display(Node head){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public  Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        Node ans = new Node (-1);
        Node tail = ans;

        // Merge 2 sorted linked lists
        while (left != null && right != null) {
            if (left.data < right.data) {
                tail.next = left;
                tail = left;
                left = left.next;
            } else {
                tail.next = right;
                tail = right;
                right = right.next;
            }
        }

        while (left != null) {
            tail.next = left;
            tail = left;
            left = left.next;
        }

        while (right != null) {
            tail.next = right;
            tail = right;
            right = right.next;
        }

        ans = ans.next;
        return ans;
        //Time Complexity - O(M+N)
        //Space Complexity - O(1)
    }
}
