package stack.problems;

import java.util.Stack;

public class MinimumBracketReversal {
    public static int minimumBracketReversal(String str){
        if(str.length()%2 != 0){
            return -1;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='{'){
                st.push(ch);
            }else{
                //Closing bracket
                if(!st.empty() && st.peek()=='{'){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }
        //Now the stack contains only invalid expressions
        int a =0; int b=0;
        while (!st.empty()){
            if(st.peek()=='{'){
                b++;
            }else{
                a++;
            }
            st.pop();
        }
        return (a+1)/2 + (b+1)/2;
    }

    public static void main(String[] args) {
        System.out.println(minimumBracketReversal("{{"));
    }
}
