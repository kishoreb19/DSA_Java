package queue;

public class DoublyEndedQueueImplementation {
    static class Deque{
        int size,front_q,rear_q;
        int arr[];
        public Deque(int n)
        {
            // Write your code here.
            this.size = n;
            arr = new int[size];
            front_q=rear_q=-1;
        }
        // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
        public boolean pushFront(int x)
        {
            // Write your code here.
            if(isFull()){
                return false;
            }
            if(front_q==-1){
                front_q=rear_q=0;

            }else if (front_q==0 && rear_q != size-1){
                front_q=size-1;

            }else{
                front_q--;

            }
            arr[front_q]=x;
            return true;
        }

        // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
        public boolean pushRear(int x)
        {
            // Write your code here.
            if(isFull()){
                return false;
            }
            if(front_q==-1){
                front_q=rear_q=0;

            }else if (rear_q==size-1 && front_q != 0){
                rear_q=0;

            }else{
                rear_q++;

            }
            arr[rear_q]=x;
            return true;
        }

        // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
        public int popFront()
        {
            // Write your code here.
            if(isEmpty()){
                return -1;
            }

            int temp = arr[front_q];
            arr[front_q]=-1;

            if(front_q==rear_q){
                front_q=rear_q=-1;
            }else if(front_q==size-1){
                front_q=0;
            }else{
                front_q++;
            }
            return temp;
        }

        // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
        public int popRear()
        {
            // Write your code here.
            if(isEmpty()){
                return -1;
            }

            int temp = arr[rear_q];
            arr[rear_q]=-1;

            if(front_q==rear_q){
                front_q=rear_q=-1;
            }else if(rear_q==0){
                rear_q=size-1;
            }else{
                rear_q--;
            }
            return temp;
        }

        // Returns the first element of the deque. If the deque is empty, it returns -1.
        public int getFront()
        {
            // Write your code here.
            if(isEmpty()){
                return -1;
            }else{
                return arr[front_q];
            }
        }

        // Returns the last element of the deque. If the deque is empty, it returns -1.
        public int getRear()
        {
            // Write your code here.
            if(isEmpty()){
                return -1;
            }else{
                return arr[rear_q];
            }
        }

        // Returns true if the deque is empty. Otherwise returns false.
        public boolean isEmpty()
        {
            // Write your code here.
            return (front_q==-1 );
        }

        // Returns true if the deque is full. Otherwise returns false.
        public boolean isFull()
        {
            // Write your code here.
            return ((front_q==0 && rear_q==size-1) || (front_q !=0 && rear_q==(front_q-1)%(size-1)));
        }
    }

    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.pushFront(1);
    }
}
