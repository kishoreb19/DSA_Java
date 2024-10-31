package queue;

public class CircularQueueImplementation {
    static class CircularQueue{
        int arr[];
        int size,front_q,rear_q;
        CircularQueue(int size){
            this.size = size;
            arr = new int[size];
            front_q=rear_q=-1;
        }
        boolean enqueue(int data){
            if((front_q==0 && rear_q==size-1) || rear_q==front_q-1){ //(front_q!=0 && rear_q==(front_q-1)%(size-1))
                System.out.println("Queue is full !");
                return false;
            } else if (front_q==-1 && rear_q==-1) {
                //Single element push
                front_q++; rear_q++;
            } else if (rear_q==size-1 && front_q!=0) {
                //To maintain circular flow
                rear_q=0;
            }else{
                //Normal flow
                rear_q++;
            }
            arr[rear_q]=data;
            return true;
        }

        int dequeue(){
            if(front_q==-1&&rear_q==-1){
                System.out.println("Queue is empty !");
                return -1;
            }
            int temp = arr[front_q];
            arr[front_q]=-1;
            if (front_q==rear_q) {
                //Single element deletion
                front_q=rear_q=-1;
            } else if (front_q==size-1) {
                //To maintain circular flow
                front_q=0;
            }else{
                //Normal flow
                front_q++;
            }
            return temp;
        }
    }
}
