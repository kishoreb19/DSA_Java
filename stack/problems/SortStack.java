package stack.problems;

import java.util.Stack;

public class SortStack {
    public static void insertInSortedStack(Stack<Integer> st,int element){
        if(st.empty() || st.peek()<=element ){
            st.push(element);
            return;
        }
        int top = st.pop();
        insertInSortedStack(st, element);
        //Now the element is added to its right position in stack
        //Now add the top popped element back to stack
        st.push(top);

    }
    public static void sortStack(Stack<Integer> st){
        if(st.empty()){
            return;
        }
        int temp = st.pop();
        sortStack(st);
        //Now all the elements are sorted
        //Now add the popped top element back to the stack in sorted manner
        insertInSortedStack(st,temp);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for(int i =5 ;i>=1;i--){
            st.push(i);
        }
        sortStack(st);
        while (!st.empty()){
            System.out.println(st.pop());
        }
    }
}
