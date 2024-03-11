package extraQuestions.stack;

import java.util.Stack;

public class NextGreaterElement2 {
    static int[] nextGreaterElement(int n, int arr[]) {
        // code here
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            st.push(arr[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
    //https://www.geeksforgeeks.org/problems/next-greater-element-2/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab
}
