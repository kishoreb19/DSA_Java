package stack;
public class StackImplementationArray {
    public static class Stack{
        int arr[]; int top; int capacity;
        Stack(int capacity){
            this.capacity = capacity;
            arr = new int[capacity];
            top = -1;
        }

        public void push(int data){
            if(capacity-top>1){
                //Or top<capacity-1
                //If space is available
                top++;
                arr[top] = data;
            }else{
                System.out.println("Overflow !");
            }
        }

        public int pop(){
            if(top>=0){
                //If at least one single element is present
                int element = arr[top];
                top--;
                return element;
            }else{
                System.out.println("Underflow !");
                return -1;
            }
        }

        public int peek(){
            if(top>=0){
                //If at least one single element is present
                return arr[top];
            }else{
                return -1;
            }
        }

        public int size(){
            return top+1;
        }
        public boolean empty(){
            if(top>=0){
                return false;
            }else{
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        for(int i =1;i<=5;i++){
            stack.push(i);
        }
        //Displaying the stack
        while (!stack.empty()){
            // or stack.size()>0
            System.out.println(stack.peek());
            stack.pop();
        }
    }
    //Time Complexity for every method here is O(1)
}
