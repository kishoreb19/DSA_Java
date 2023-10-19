package queue;

public class QueueImplementationArray {
    static class Queue{
        int size, front_q, rear_q;
        int arr[];

        Queue(int size){
            this.size = size;
            arr = new int[size];
            front_q = 0; rear_q = 0;
        }

        void push(int data){
            if(rear_q ==size){
                System.out.println("Queue is full !");
            }else{
                arr[rear_q]=data;
                rear_q++;
            }
        }

        int pop(){
            int temp = arr[front_q];
            if(front_q == rear_q){
                return -1;
            }else{
                arr[front_q]=-1;
                front_q++;
                if(front_q == rear_q){
                    //So that spaces of deleted elements don't get wasted
                    front_q = rear_q = 0;
                }
            }
            return temp;
        }

        int front(){
            if(front_q == rear_q){
                return -1;
            }else{
                return arr[front_q];
            }
        }

        int rear(){
            if(front_q==rear_q){
                return -1;
            }else{
                return arr[rear_q-1];
            }
        }

        boolean isEmpty(){
            return front_q == rear_q;
        }

        int size(){
            return rear_q-front_q;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(6);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        queue.pop();
        queue.pop();
        queue.push(8);

        for(int i : queue.arr){
            System.out.println(i);
        }
        System.out.println("Queue Size: "+queue.size());
    }
    //Time Complexity for every method here is O(1)
}