package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int total = rows*cols;
        int count = 0;//Keeps count of elements we have printed

        int startingRow=0;
        int endingRow = rows-1;

        int startingCol = 0;
        int endingCol = cols-1;

        while(count<total){//mainly used to print the center elements
            for(int i=startingCol;count<total && i<=endingCol;i++){
                list.add(matrix[startingRow][i]);
                count++;
            }
            startingRow++;

            for(int i=startingRow;count<total && i<=endingRow;i++){
                list.add(matrix[i][endingCol]);
                count++;
            }
            endingCol--;

            for(int i=endingCol;count<total && i>=startingCol;i--){
                list.add(matrix[endingRow][i]);
                count++;
            }
            endingRow--;

            for(int i=endingRow;count<total && i>=startingRow;i--){
                list.add(matrix[i][startingCol]);
                count++;
            }
            startingCol++;
        }
        return list;
    }
    //https://leetcode.com/problems/spiral-matrix/
}
