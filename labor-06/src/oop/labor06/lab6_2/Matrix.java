package oop.labor06.lab6_2;

import java.util.Random;

public class Matrix {
    private double[][] data;
    private final int rows;
    private final int columns;

    public Matrix(int rows,int columns){
        this.data = new double[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }
    public Matrix(double[][] data){
        this.data = new double[data.length][data[0].length];
        this.rows = data.length;
        this.columns = data[0].length;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                this.data[i][j]=data[i][j];
            }
        }
    }
    public Matrix(Matrix matrix){
        this.data = new double[matrix.rows][matrix.columns];
        this.rows = matrix.rows;
        this.columns = matrix.columns;

        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j]=matrix.data[i][j];
            }
        }

    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void fillRandom(double inner, double upper){
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j] = random.nextDouble(inner,upper);
            }
        }
    }
    public static Matrix add(Matrix matrix1, Matrix matrix2){

        if(matrix1.rows == matrix2.rows && matrix1.columns == matrix2.columns){
            Matrix sum = new Matrix(matrix1);

            for (int i = 0; i < matrix1.rows; i++) {
                for (int j = 0; j < matrix1.columns; j++) {
                    sum.data[i][j] = matrix1.data[i][j]+matrix2.data[i][j];
                }
            }
            return sum;
        }
        else return null;
    }
    public static Matrix multiply(Matrix matrix1, Matrix matrix2){
        if(matrix1.columns == matrix2.rows){
            Matrix matrix = new Matrix(matrix1);

            for (int i = 0; i < matrix.rows; i++) {
                for (int j = 0; j < matrix.columns; j++) {

                    matrix.data[i][j] = 0;

                    for (int k = 0; k < matrix.columns; k++) {
                        matrix.data[i][j] += matrix1.data[i][k]*matrix2.data[k][j];
                    }
                }
            }
            return matrix;
        }
        else return null;
    }
    public static Matrix transpose(Matrix matrix){
        Matrix tmatrix = new Matrix(matrix.columns, matrix.rows);

        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                tmatrix.data[j][i] = matrix.data[i][j];
            }
        }
        return tmatrix;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}
