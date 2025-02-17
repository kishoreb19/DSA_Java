package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaximalRectangle {

    ArrayList<Integer> prevSmaller(int[] heights) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        st.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ans.add(st.peek());
            st.push(i);
        }
        return ans;
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }
    ArrayList<Integer> nextSmaller(int[] heights) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        st.push(heights.length);
        for (int i = heights.length - 1; i >= 0; i--) {
            while (st.peek() != heights.length && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ans.add(st.peek());
            st.push(i);
        }
        Collections.reverse(ans);
        return ans;
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }
    public int largestRectangleArea(int[] heights) {
        ArrayList<Integer> prev = prevSmaller(heights);
        ArrayList<Integer>next = nextSmaller(heights);
        int area = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int p = prev.get(i);
            int n = next.get(i);
            int l = heights[i];
            int tempArea = l*(n-p-1);
            area = Math.max(area,tempArea);
        }
        return area;
        //Time  Complexity - O(N)
        //Space Complexity - O(N)
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int max = 0;
        for(int i=0; i<n; i++){
            int k = 0;
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1'){
                    heights[k] += 1;
                }else{
                    heights[k] = 0;
                }
                k++;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
        //Time  Complexity - O(N*M)
        //Space Complexity - O(M)
    }
    //https://leetcode.com/problems/maximal-rectangle/
}
