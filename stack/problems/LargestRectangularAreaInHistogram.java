package stack.problems;
import java.util.Stack;

public class LargestRectangularAreaInHistogram {
    public static int[] nextSmallerElement(int arr[]){
        Stack<Integer> stack = new Stack<>();
        stack.add(-1); int n = arr.length;
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            int curr = arr[i];
            //Finding smaller element in the stack
            while(stack.peek()!=-1 && arr[stack.peek()]>=curr){
                stack.pop();
            }
            ans[i] = stack.peek();
            //Pushing Index
            stack.push(i);
        }
        return ans;
    }
    public static int[] previousSmallerElement(int arr[]){
        Stack<Integer> stack = new Stack<>();
        stack.add(-1); int n = arr.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            int curr = arr[i];
            //Finding smaller element in the stack
            while(stack.peek()!=-1 && arr[stack.peek()]>=curr){
                stack.pop();
            }
            ans[i] = stack.peek();
            //Pushing Index
            stack.push(i);
        }
        return ans;
    }
    public static int largestHistogramArea(int heights[]){
        int nextSmallerElement[] = nextSmallerElement(heights);
        int previousSmallerElement[] = previousSmallerElement(heights);
        int n = heights.length;
        int area = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int length = heights[i];
            //Important Condition
            if(nextSmallerElement[i]==-1){
                nextSmallerElement[i]=n;
            }

            int breadth = nextSmallerElement[i] - previousSmallerElement[i] - 1;
            int newArea = length*breadth;
            area = Math.max(area,newArea);
        }
        return area;
        //Time Complexity O(n)
    }

    public static void main(String[] args) {
        System.out.println(largestHistogramArea(new int[]{2,1,5,6,2,3}));
    }
}
