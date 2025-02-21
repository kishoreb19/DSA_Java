package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class JobSequencingProblem {

    class Job{
        int id, profit, deadline;
        Job(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here
        int n = id.length;
        Job[] jobs = new Job[n];

        for(int i=0; i<n; i++){
            jobs[i] = new Job(id[i], deadline[i], profit[i]);
        }

        //1-based Indexing
        //Initialise with max deadline but in this case max deadline is id.length()
        int[] schedule = new int[n+1];
        Arrays.fill(schedule,-1);

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxProfit = 0;
        int jobCount = 0;

        for(int i=0; i<n; i++){
            int currId = jobs[i].id;
            int currDeadline = jobs[i].deadline;
            int currProfit = jobs[i].profit;

            for(int j = currDeadline; j>=1; j--){
                if(schedule[j] == -1){
                    schedule[j] = currId;
                    maxProfit += currProfit;
                    jobCount++;
                    break;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(jobCount, maxProfit));
        //Time  Complexity - O(n^2)
        //Space Complexity - O(n)
    }
    //https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
}
