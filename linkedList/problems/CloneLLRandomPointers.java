package linkedList.problems;

import java.util.HashMap;

public class CloneLLRandomPointers {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //Clone a Linked List with Random Pointers
    public Node copyRandomList(Node head) {
        Node copyHead = null; //Head of duplicate list
        Node copyTail = copyHead;//Tail of duplicate list
        Node curr = head;//Head of original list

        //Creating duplicate list without random pointers
        while(curr!=null){
            Node temp = new Node(curr.val);//Create new Node
            if(copyHead==null){
                copyHead = temp;
                copyTail = copyHead;
            }else{
                copyTail.next = temp;
                copyTail = copyTail.next;
            }
            curr = curr.next;
        }
        //Resetting pointers
        copyTail = copyHead;
        curr = head;

        //Creating HashMap to map original nodes with duplicate nodes
        HashMap<Node,Node> map = new HashMap<>();
        while(curr!=null && copyTail!=null){
            map.put(curr,copyTail);
            curr = curr.next;
            copyTail = copyTail.next;
        }
        //Resetting pointers
        copyTail = copyHead;
        curr = head;

        //Adding random pointers from original list to duplicate list
        while(curr!=null && copyTail!=null){
            //Get random node for duplicate list from original list
            Node random = map.get(curr.random);
            copyTail.random = random;

            curr = curr.next;
            copyTail = copyTail.next;
        }
        return copyHead;
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }

    public Node copyRandomList_optimized(Node head) {

        if (head == null) return null;

        Node curr = head;
        //Creating deep copies of each node and interweave them with the original list
        while(curr!=null){
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }
        //Resetting pointer
        curr = head;

        //Assign random pointers to the copied nodes
        while(curr!=null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr=curr.next.next;
        }
        //Resetting pointer
        curr = head;

        //Separate the original list and the copied list
        Node copyHead = curr.next;
        Node copyTail = copyHead;

        while(curr!=null){
            Node next = curr.next.next;// Save the next original node
            curr.next = next;// Restore the original list's `next` pointer
            if(copyTail.next != null){
                copyTail.next = copyTail.next.next;// Link the copied list's `next` pointer
            }
            curr = next; // Move to the next original node
            copyTail = copyTail.next;// Move to the next copied node
        }
        //Return the duplicate list
        return copyHead;
        //Time  Complexity - O(N)
        //Space Complexity - O(1)
    }
}
