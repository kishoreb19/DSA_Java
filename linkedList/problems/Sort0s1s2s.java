package linkedList.problems;

import java.util.HashMap;
import java.util.Map;

public class Sort0s1s2s {
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
    }
    //------------------------------------------------------------------------------------------------------------------
    public static Node insertAtTail(Node tail, Node temp) {
        tail.next = temp;
        return temp;
        //We can't do temp = tail;
        //because its pass by value
        //not by pass by reference
    }

    public Node sortList(Node head) { //Best Approach
        // Write your code here
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        // Creating separate LinkedLists for zeros, ones, and twos
        Node temp = head;
        while (temp != null) {
            int value = temp.data;
            if (value == 0) {
                zeroTail = insertAtTail(zeroTail, temp);
                //Now zeroTail is pointing to recently added 0's node
            } else if (value == 1) {
                oneTail = insertAtTail(oneTail, temp);
            } else if (value == 2) {
                twoTail = insertAtTail(twoTail, temp);
            }
            temp = temp.next;
        }

        // Merge all the zeros, ones, and twos LinkedLists
        if (oneHead.next != null) {
            //If 1s list is not empty
            zeroTail.next = oneHead.next;
        } else {//If 1s list is empty
            zeroTail.next = twoHead.next;
        }
        //Merging 1s list with 2s list
        oneTail.next = twoHead.next;
        //pointing 2s next to null
        twoTail.next = null;
        //Updating head
        this.head = zeroHead.next;
        return head;
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }

    //Alternative method(Not preferred but) by replacing the data value
    public static Node sortListAlternative(Node head) {
        // Write your code here
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        Node temp = head;
        while(temp!=null){
            int val = temp.data;
            if(val==0){
                zeroCount++;
            }else if(val==1){
                oneCount++;
            }else{
                twoCount++;
            }
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            if(zeroCount!=0){
                temp.data = 0;
                temp=temp.next;
                zeroCount--;
            }else if(oneCount!=0){
                temp.data = 1;
                temp=temp.next;
                oneCount--;
            }else{
                temp.data = 2;
                temp=temp.next;
                twoCount--;
            }
        }
        return head;
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }

    public  Node sortListUsingMap(Node head) {
        // Write your code here
        Node temp = head;
        Map<Integer,Integer> map = new HashMap<>();
        while(temp!=null){
            int val = temp.data;
            if(!map.containsKey(val)){
                map.put(val,1);
            }else{
                map.replace(val,map.get(val)+1);
            }
            temp = temp.next;
        }

        int zeroCount = map.get(0);
        int oneCount = map.get(1);
        int twoCount = map.get(2);

        Node newList = new Node(-1);
        Node tail = newList;
        //Creating new 0's nodes and adding it to newList
        for(int i=1;i<=zeroCount;i++){
            Node newNode = new Node(0);
            tail.next = newNode;
            tail = newNode;
        }
        //Creating new 1's nodes and adding it to newList
        for(int i=1;i<=oneCount;i++){
            Node newNode = new Node(1);
            tail.next = newNode;
            tail = newNode;
        }
        //Creating new 2's nodes and adding it to newList
        for(int i=1;i<=twoCount;i++){
            Node newNode = new Node(2);
            tail.next = newNode;
            tail = newNode;
        }

        return newList.next;
        //Time Complexity - O(N)
        //Space Complexity - O(1)
    }



    public static void main(String[] args) {
        Sort0s1s2s list = new Sort0s1s2s();
        int[] arr = {1, 0, 2, 1, 0, 2, 1};
        for(int i : arr){
            list.addLast(i);
        }
        list.display();
        Node newNode = list.sortList(list.head);
        System.out.println();
        list.display();
    }
}