package extraQuestions.linkedList;

public class TwoDMatrix {
    static class Node
    {
        int data;
        Node right,down;

        Node(int data){
            this.data = data;
            right = null;
            down = null;
        }
    }
    static Node construct(int arr[][]) {
        int rows = arr.length;
        int cols = arr[0].length;

        // Create a 2D array of Node to store references to the created nodes
        Node[][] nodes = new Node[rows][cols];

        // Create all nodes in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j] = new Node(arr[i][j]);
            }
        }

        // Set the right and down pointers
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j + 1 < cols) {
                    nodes[i][j].right = nodes[i][j+1];
                }
                if (i + 1 < rows) {
                    nodes[i][j].down = nodes[i+1][j];
                }
            }
        }

        // Return the head of the linked grid
        return nodes[0][0];
    }

    //https://www.geeksforgeeks.org/problems/linked-list-matrix/1
}
