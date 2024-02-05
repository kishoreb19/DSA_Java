package extraQuestions.linkedList;

public class RemoveNthNodeFromLast {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  //--------------------------------------------------------------------------------------------------------------------
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode curr = head;
        ListNode prev = null;

        // Count the length of the linked list
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        // Calculate the position of the node to remove
        int x = len - n + 1;
        int c = 0;

        curr = head;

        // Traverse until reaching the node just before the one to remove
        while (curr != null && c < x-1) {
            prev = curr;
            curr = curr.next;
            c++;
        }

        // If the node to remove is the head, update head
        if (curr == head) {
            head = head.next;
        }

        // If the node to remove is found and it's not the head, remove it
        if (prev != null && curr != null) {
            prev.next = curr.next;
        }

        return head;
    }
}
