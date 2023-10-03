package matrix;

import java.util.Scanner;

public class Matrix {
    public static int[][] input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();
        int matrix[][] = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
    public static int[][] multiplication(int matrix1[][],int matrix2[][]){
        //For Matrix 1
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        //For Matrix 2
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;
        int matrix[][] = new int[0][];
        if(columns1==rows2){
            matrix = new int[rows1][columns2];
            //Multiplication begins
            for(int i=0;i<rows1;i++){
                for(int j=0;j<columns2;j++){
                    for(int k=0;k<rows2;k++){
                        matrix[i][j]+= matrix1[i][k]*matrix2[k][j];
                    }
                }
            }
        }else{
            System.out.println("Not Possible");
        }
        return matrix;
    }

    public static int[][] addition(int matrix1[][],int matrix2[][]){
        //For Matrix 1
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        //For Matrix 2
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;
        int matrix[][] = new int[0][];
        for(int i=0;i<rows1;i++){
            for (int j=0;j<columns1;j++){
                matrix[i][j] = matrix1[i][j]+matrix2[i][j];
            }
        }
        return matrix;
    }

    public static void display(int matrix[][]){
        int rows = matrix.length;
        int columns = matrix[0].length;
        System.out.println("The Matrix: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix1[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int matrix2[][] ={{1,2,3},{4,5,6},{7,8,9}};
        display(multiplication(matrix1,matrix2));
    }
}
