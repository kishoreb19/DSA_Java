package stack.problems;

import java.util.Stack;

public class DeleteMiddleElement {
    public static void deleteMiddleIterative(Stack<Integer> inputStack, int N) {
        // WRITE YOUR CODE HERE
        int mid = N/2;
        Stack<Integer> s = new Stack<>();
        for(int i=1;i<=mid;i++){
            int x = inputStack.pop();
            s.push(x);
        }
        inputStack.pop();
        for(int i=1;i<=mid;i++){
            inputStack.push(s.pop());
        }
    }
    public static void deleteMiddleRecursion(Stack<Integer> st, int count, int size){
        if(count==size/2){
            st.pop();
            return;
        }
        int num = st.pop();
        deleteMiddleRecursion(st, count+1, size);
        st.push(num);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(5);
        s.push(9);
        s.push(2);
        s.push(4);
        //deleteMiddleRecursion(s,0,s.size());
        //deleteMiddleIterative(s,s.size());
        while (!s.empty()){
            System.out.println(s.pop());
        }
    }
}
