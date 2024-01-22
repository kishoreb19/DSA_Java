package queue.problems;

public class CircularTour {
    public static int tour(int petrol[], int distance[]){
        // Your code here
        int balance = 0;
        int kami = 0;
        int start = 0;
        int n = petrol.length;
        for(int i=0;i<n;i++){
            balance = balance + (petrol[i] - distance[i]);
            if(balance < 0){
                start = i+1;
                kami = kami + balance;
                balance =0;
            }
        }
        if(kami+balance >= 0){
            return start;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        int petrol[] = {4,6,7,4};
        int distance[] = {6,5,3,5};
        //Returns Index
        System.out.println(tour(petrol,distance));
        //https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1
    }
}
