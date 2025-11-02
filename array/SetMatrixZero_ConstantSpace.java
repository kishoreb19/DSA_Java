package array;

public class SetMatrixZero_ConstantSpace {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];//Keep track of 0 element rows
        int[] col = new int[n];//Keep track of 0 element cols

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    //Note the positions
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        //Set zeros at the marked positions
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
        //Time  Complexity - O(MxN)
        //Space Complexity - O(M+N)
    }

    //Most optimal solution
    public void setZeroes_ConstantSpace(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int col0 = matrix[0][0];// 1st col element

        // Mark or note positions of 0 elements
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){

                    matrix[i][0] = 0; //Row mark

                    if(j != 0){//Col Mark
                        matrix[0][j] = 0;
                    }else{
                        col0 = 0;
                    }
                }
            }
        }
        //Do not traverse 1st row and 1st col
        //You can traverse from end or from start, your choice
        for(int i=m-1; i>=1; i--){
            for(int j=n-1; j>=1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //Mark full row zero if 1st row element is zero
        if(matrix[0][0] == 0){
            for(int i = 0; i<n; i++){
                matrix[0][i] = 0;
            }
        }
        //Mark full col zero if 1st col element is zero
        if(col0 == 0){
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }
        //Time  Complexity - O(MxN)
        //Space Complexity - O(1)
    }
    //https://leetcode.com/problems/set-matrix-zeroes/
}