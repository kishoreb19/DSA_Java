import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Test {

    public static ArrayList<Integer> fun(int arr[]){
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer>stack = new Stack<>();
        stack.add(-1); int n = arr.length;
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            int curr = arr[i];
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
        System.out.println(fun(new int[]{2,1,4,3}));
    }
}
