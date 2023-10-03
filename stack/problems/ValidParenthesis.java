package stack.problems;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean validParenthesis(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='{'||c=='['||c=='('){
                st.push(c);
            }
            if(!st.empty()){
                if((c=='}' && st.peek()=='{') ||(c==']' && st.peek()=='[')||(c==')' && st.peek()=='(')){
                    st.pop();
                }
            }else{
                return false;
            }
        }
        if(st.empty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validParenthesis("[()]{}{[()()]()}"));
    }
}
