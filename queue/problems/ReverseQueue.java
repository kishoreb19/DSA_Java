package queue.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    //Using Recursion
    public static void reverse(Queue<Integer>q){
        if(q.isEmpty()){
            return;
        }
        int temp = q.poll();
        reverse(q);
        q.add(temp);
    }
    public static Queue<Integer> reverseUsingRecursion(Queue<Integer>q){
        reverse(q);
        return q;
//        Time  Complexity - O(N)
//        Space Complexity - O(1)
    }

    //Without Recursion Using Stack
    public static Queue<Integer> reverseUsingStack(Queue<Integer> q) {

        Queue<Integer>qe = new LinkedList<>();
        Stack<Integer>st = new Stack<>();
        while(!q.isEmpty()){
            st.push(q.poll());
        }
        while(!st.empty()){
            qe.add(st.pop());
        }
        return qe;
//        Time  Complexity - O(N)
//        Space Complexity - O(N)
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=5;i++){
            q.add(i);
        }

//        System.out.println(reverseUsingStack(q));
        reverseUsingRecursion(q);
        System.out.println(q);
    }
}
