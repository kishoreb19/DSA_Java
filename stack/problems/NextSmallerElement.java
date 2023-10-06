package stack.problems;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {
    public static ArrayList<Integer> nextSmallerElement(int arr[]){
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(-1); int n = arr.length;
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            int curr = arr[i];
            //Finding smaller element in the stack
            while(stack.peek()>=curr){
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(curr);
        }
        for (int i = 0; i < n; i++) {
            al.add(ans[i]);
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println(nextSmallerElement(new int[]{2,1,4,3}));
    }
}
