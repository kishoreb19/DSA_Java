package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementationQueue {
    static class Stack {
        Queue<Integer> q;
        public Stack() {
            // Implement the Constructor.
            q = new LinkedList<>();
        }

        public int getSize() {
            return q.size();
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }

        public void push(int element) {
            int size = getSize();
            q.add(element);
            //Rotate queue so that last element comes to first and first element goes to last
            for(int i=1;i<=size;i++){
                q.add(q.poll());
            }
        }

        public int pop() {
            if(isEmpty()) return -1;
            return q.poll();
        }

        public int top() {
            if(isEmpty()) return -1;
            return q.peek();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        for(int i=1;i<=5;i++){
            s.push(i);
        }
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
}
