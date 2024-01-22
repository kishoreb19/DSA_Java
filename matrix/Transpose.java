package matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Transpose {

    public static int [][]input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix size m and n");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int matrix[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
    public static void transpose(int matrix[][]){
        for(int i = 0; i< matrix.length; i++){
            for(int j=0;j<matrix[0].length;j++){
                //Switch i and j for transpose
                System.out.print(matrix[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][] = input();
        transpose(arr);
    }
}
