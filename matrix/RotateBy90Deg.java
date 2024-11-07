package matrix;

public class RotateBy90Deg {
    static void reverse(int arr[]){
        int i = 0, j = arr.length-1;

        while(i<j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;j--;
        }
    }
    static void rotate(int mat[][]) {
        // Code Here
        int rows = mat.length;
        int cols = mat[0].length;
        //Convert into transpose matrix
        for(int i=0;i<rows;i++){
            for(int j=i;j<cols;j++){
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
        //Reverse the rows
        for(int i=0;i<rows;i++){
            reverse(mat[i]);
        }
        //Time Complexity - O(nxm)
        //Space Complexity - O(1)
        //https://www.geeksforgeeks.org/problems/rotate-by-90-degree0356/1
    }
}
