package linkedList.problems;



public class ReverseNodesInKGroups {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //Reverse the Linked List
    ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    //Checks if it is possible to reverse k nodes else returns null
    ListNode kPossible(ListNode head, int k){
        int c = 1;
        while(head!=null && c<k){
            head = head.next;
            c++;
        }
        return c==k ? head : null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode curr  = head,// Current node in traversal
                prev  = null,// Tail of the previous reversed group
                next  = null,// Pointer to the next group
                start = null;// New head of the reversed list

        while(curr!=null){
            ListNode possible = kPossible(curr,k);
            if(possible!=null){
                next = possible.next;
                possible.next=null;

                ListNode rev = reverse(curr);
                if(start==null){//Set start to the head of the first reversed group
                    start = rev;
                }
                if(prev!=null){ //Connect previous reverse group to new reverse group of nodes
                    prev.next = rev;
                }
            }else{
                if(prev!=null){
                    prev.next = curr;
                    break;
                }
            }
            prev = curr;
            curr = next;
        }
        return start;
    }
    //Time  Complexity - O((N/k)*k) = O(N)
    //Space Complexity - O(1)
    //https://leetcode.com/problems/reverse-nodes-in-k-group/
}
