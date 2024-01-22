package queue.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {
    public static Queue<Integer> reverseFirstK(Queue<Integer>q, int k){
        Queue<Integer>qe = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        int n = q.size();
        for(int i=1;i<=k;i++){
            st.push(q.poll());
        }
        while (!st.empty()){
            q.add(st.pop());
        }
        //Till now -> 4 5 3 2 1
        //For first n-k elements
        for(int i=1;i<=n-k;i++){
            q.add(q.poll());
        }
        //Now -> 3 2 1 4 5
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer>q = new LinkedList<>();
        for(int i=1;i<=5;i++){
            q.add(i);
        }
        System.out.println(q);
        System.out.println(reverseFirstK(q,3));
    }
}
