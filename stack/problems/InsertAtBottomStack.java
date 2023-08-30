package stack.problems;

import java.util.Stack;

public class InsertAtBottomStack {
    static Stack<Integer> insertAtBottom(Stack<Integer>s, int x){
        if(s.empty()){
            s.add(x);
            return s;
        }
        int t = s.pop();
        insertAtBottom(s,x);
        s.add(t);
        return s;
    }
    static Stack<Integer> reverseStack(Stack<Integer>s){
        if(s.empty()){
            return new Stack<>();
        }
        int t = s.pop();
        reverseStack(s);

        return insertAtBottom(s,t);

    }

    public static void main(String[] args) {
        //        Stack<Integer>s = new Stack<>();
//        for(int i =1;i<=5;i++){
//            s.add(i);
//        }
//
//        Stack<Integer> s1 = reverseStack(s);
//        while (!s1.empty()){
//            System.out.println(s1.peek());
//            s1.pop();
//        }
    }
}
