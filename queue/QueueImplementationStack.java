package queue;

import java.util.Stack;

public class QueueImplementationStack {
    static class Queue {
        Stack<Integer> s;
        Queue() {
            s = new Stack<>();
        }

        void enQueue(int val) {
            Stack<Integer> temp = new Stack<>();
            //Rotate
            while(!s.isEmpty()){
                temp.push(s.pop());
            }
            s.push(val);
            while(!temp.isEmpty()){
                s.push(temp.pop());
            }
        }


        int deQueue() {
            if(isEmpty()) return -1;
            return s.pop();
        }

        int peek() {
            if(isEmpty()) return -1;
            return s.peek();
        }

        boolean isEmpty() {
            return s.isEmpty();
        }
    }

    public static void main(String[] args) {
        Queue q =  new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q.deQueue());
    }
}
