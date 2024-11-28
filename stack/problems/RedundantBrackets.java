package stack.problems;

import java.util.Stack;

public class RedundantBrackets {
    public static boolean findRedundantBrackets(String s){
        // Write your code here.
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='+' || c=='-' || c=='*' || c=='/'){
                st.push(c);
            }
            if(c==')'){
                boolean isRedundant = true;
                while(st.peek() != '('){
                    char top = st.peek();
                    if(top=='+' || top=='-' || top=='*' || top=='/'){
                        isRedundant = false;
                    }
                    st.pop();
                }
                st.pop();
                if(isRedundant){
                    return true;
                }
            }
        }
        return false;
    }
    //Another method
    public static boolean duplicateParanthesis(String s) {
        // Write your code here
        Stack<Character>st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==')'){
                int count = 0; //Count of operators inside '(' and ')'
                while(st.peek()!='('){
                    st.pop();
                    count++;
                }
                st.pop();
                if(count==0){//If no operators were present inside () means they are redundant bracket
                    return true;
                }
            }else{
                if(c=='(' || c=='+' || c=='-' || c=='*' || c=='/'){//Only add the operators and (
                    st.add(c);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findRedundantBrackets("(a+b)"));
        System.out.println(findRedundantBrackets("(a+c*b)+(c))"));
        System.out.println("https://www.codingninjas.com/studio/problems/redundant-brackets_975473?leftPanelTab=0%3Fsource%3Dyoutube&campaign=Lovebabbarcodestudio&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbarcodestudio");
        System.out.println("https://www.codingninjas.com/studio/problems/duplicate-parenthesis_2663296");
    }
}
