package stack.problems;

import java.util.Stack;

public class InsertAtBottomStack {
    public static void insertAtBottom(Stack<Integer>st,int element){
        if(st.empty()){
            st.push(element);
            return;
        }
        int temp = st.pop();
        insertAtBottom(st,element);
        st.push(temp);
    }

    public static void reverseStack(Stack<Integer>st){
        if(st.empty()){
            return;
        }
        int temp = st.pop();
        reverseStack(st);
        insertAtBottom(st,temp);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for(int i =1 ;i<=5;i++){
            st.push(i);
        }
        //insertAtBottom(st,9);
        reverseStack(st);
        while (!st.empty()){
            System.out.println(st.pop());
        }
    }
}
