package linkedList.problems;

public class MergeSortLL {
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
    public void display(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }
    //------------------------------------------------------------------------------------------------------------------
    public Node findMid(Node head)
    {
        // Base case
        if (head == null || head.next==null){
            return head;
        }
        Node fast = head.next;
        Node slow = head;

        // Move fast by two and slow ptr by one
        // Finally slow will point to middle node
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

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
    }

    public  Node mergeSort(Node head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Break linked list into two halves after finding mid
        Node mid = findMid(head);

        Node left = head;
        Node right = mid.next;
        mid.next = null;

        // Recursive calls to sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge both left and right halves
        Node result = merge(left, right);

        return result;
    }

    public static void main(String[] args) {
        MergeSortLL list = new MergeSortLL();
        list.addLast(8);
        list.addLast(5);
        list.addLast(9);
        list.addLast(2);
        list.addLast(0);
        list.addLast(1);

        list.display();
        list.head = list.mergeSort(list.head);
        list.display();

    }
}
