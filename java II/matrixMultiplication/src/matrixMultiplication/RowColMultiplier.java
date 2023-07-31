package matrixMultiplication;
/*
*Name: Jake Ardoin
Email: jardo16@lsu.edu
Project: PA=1 (Miltithreading)
Instructor: Feng Chen
Class: cs4103-sp21
LoginID: cs410302
*/
public class RowColMultiplier implements Runnable{
	int[] row;
    int[] col;
    int[][] res;
    int n;
    int m;

    public RowColMultiplier(int[] row, int[] col, int[][] res, int n, int m){
        this.row = row;
        this.col = col;
        this.res = res;
        this.n = n;
        this.m = m;
    }

    private int calculate(){
        int result = 0;
        int i = 0;

        while(i < row.length){
            result += row[i] * col[i];
            i++;
        };
        return result;
    }

    public void run(){
        this.res[n][m] = this.calculate();
    }
    

}
