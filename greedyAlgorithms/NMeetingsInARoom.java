package greedyAlgorithms;

import java.util.Arrays;

public class NMeetingsInARoom {

    class Pair{
        int start, end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        Pair[] meetings = new Pair[n];
        for(int i=0; i<n; i++){
            meetings[i] = new Pair(start[i], end[i]);
        }

        Arrays.sort(meetings, (a, b) -> a.end - b.end);

        int prevEnd = meetings[0].end;
        int maxMeetings = 1;

        for(int i=1; i<n; i++){
            int currStart = meetings[i].start;
            int currEnd = meetings[i].end;

            if(currStart > prevEnd){
                maxMeetings++;
                prevEnd = currEnd;
            }
        }
        return maxMeetings;
        //Time  Complexity - O(nlogn)
        //Space Complexity - O(n)
    }
    //https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
}
