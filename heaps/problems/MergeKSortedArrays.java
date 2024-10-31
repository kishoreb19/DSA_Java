package heaps.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    static class Node{ //To keep track of next nodes
        int data,row,col;
        Node(int data, int row, int col){
            this.data = data;
            this.row = row;
            this.col = col;
        }
    }
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arr, int k)
    {
        // Write your code here.
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() { //Describes rule for sorting
            public int compare(Node a, Node b){
                return a.data - b.data;
            }
        });
        ArrayList<Integer>list = new ArrayList<>();

        for(int i=0;i<k;i++){ //Add first elements of k sorted arrays
            pq.add(new Node(arr.get(i).get(0),i,0));
        }

        while(!pq.isEmpty()){
            Node min = pq.poll();
            list.add(min.data);

            int i = min.row;
            int j = min.col;

            if(j+1 < arr.get(i).size()){//If next element is within range
                pq.add(new Node(arr.get(i).get(j+1),i,j+1));
            }
        }
        return list;
        //Time Complexity - O((n*k)log k)
        //Space Complexity - O(k)
        //https://www.naukri.com/code360/problems/merge-k-sorted-arrays_975379?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
    }
}
