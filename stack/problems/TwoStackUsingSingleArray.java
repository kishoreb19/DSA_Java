package stack.problems;
public class TwoStackUsingSingleArray {

    int arr[];
    int top1,top2,size;

    public TwoStackUsingSingleArray(int s) {
        size = s;
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }

    // Push in stack 1.
    public void push1(int num) {
        // Write your code here
        if(top2-top1>1){
            top1++;
            arr[top1] = num;
        }
    }

    // Push in stack 2.
    public void push2(int num) {
        // Write your code here
        if(top2-top1>1){
            top2--;
            arr[top2] = num;
        }
    }

    // Pop from stack 1 and return popped element.
    public int pop1() {
        if(top1>=0){
            int x = arr[top1];
            top1--;
            return x;
        }else{
            return -1;
        }

    }

    // Pop from stack 2 and return popped element.
    public int pop2() {
        if(top2<=size-1){
            int x = arr[top2];
            top2++;
            return x;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("https://www.codingninjas.com/studio/problems/two-stacks_983634");
    }
}

