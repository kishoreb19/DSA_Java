package heaps.problems;

import java.util.PriorityQueue;

public class SmallestRangeFromKSortedArrays {
    static class Node {
        int data;
        int row, col;

        Node(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }
    }

    public static int kSorted(int[][] arr, int k, int n) {
        // Min-heap (Priority Queue)
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Add the first element from each row to the heap
        for (int i = 0; i < k; i++) {
            int data = arr[i][0];
            min = Math.min(min, data);
            max = Math.max(max, data);
            pq.add(new Node(data, i, 0));
        }

        int start = min, end = max;

        while (!pq.isEmpty()) {
            Node temp = pq.poll();

            min = temp.data;  // Get the minimum element

            // Update the smallest range if needed
            if (max - min + 1 < end - start + 1) {
                start = min;
                end = max;
            }

            // If there are more elements in the current row, push the next one
            if (temp.col + 1 < n) {
                int nextElement = arr[temp.row][temp.col + 1];
                max = Math.max(max, nextElement);  // Update max
                pq.add(new Node(nextElement, temp.row, temp.col + 1));
            } else {
                // One of the rows is exhausted, so we break out of the loop
                break;
            }
        }
        return (end - start + 1);  // Return the length of the smallest range
    }
    //Time Complexity - O(k*n*logk)
    //Space Complexity - O(k)
    //https://www.naukri.com/code360/problems/smallest-range-from-k-sorted-list_1069356?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
