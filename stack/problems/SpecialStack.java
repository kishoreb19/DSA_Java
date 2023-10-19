package stack.problems;

import java.util.*;

    public class SpecialStack {
        Stack<Integer> s = new Stack<>();
        int mini;
        void push(int data) {
            // Implement the push() function.
            if(s.empty()){
                s.push(data);
                mini = data;
                return;
            }
            if(data<mini){
                int val = 2*data - mini;
                s.push(val);
                mini = Math.min(data,mini);
            }else{
                s.push(data);
            }
        }

        void pop() {
            // Implement the pop() function.
            if(s.empty()){
                return;
            }
            int curr = s.peek();
            if(curr>mini){
                s.pop();
            }else{
                int val = 2*mini - curr;
                mini = val;
                s.pop();
            }
        }

        int top() {
            // Implement the top() function.
            if(s.empty()){
                return -1;
            }
            int curr = s.peek();
            if (mini > curr){
                return mini;
            }
            else{
                return curr;
            }
        }

        int getMin() {
            // Implement the getMin() function.
            if(s.empty()){
                return -1;
            }else{
                return mini;
            }
        }

        public static void main(String[] args) {
            SpecialStack specialStack = new SpecialStack();
            specialStack.push(5);
            specialStack.push(3);
            specialStack.push(8);
            specialStack.push(2);
            specialStack.push(4);

            specialStack.pop();
            specialStack.pop();
            specialStack.pop();

            System.out.println(specialStack.getMin());
            //Time Complexity : O(1)
        }

    }

