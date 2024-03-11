package extraQuestions.stack;

import java.util.Stack;

public class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> st = new Stack<>();
        st.push((long)-1);
        long[] ans = new long[n];
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans[i] = (long)-1; // No greater element found
            } else {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }

        return ans;
    }
    //https://www.geeksforgeeks.org/problems/next-greater-element/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab
}
