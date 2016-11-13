package test;

import main.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Лобанов Михаил
 */
public class MatrixTest {
    @Test
    public void getMatrix() throws Exception {
        double[][] matr = {{5, 6}, {7, 8}};
        Matrix matrix = new Matrix(matr);
        Matrix matrix2 = matrix.getMatrix();
    }

    @Test
    public void hasDeterminant3() throws Exception {
        double[][] matr = {{12, 1, 7}, {4, 8, 5}, {2, 4, 5}};
        Matrix matrix = new Matrix(matr);
        assertEquals(new Double(230), matrix.hasDeterminant());
    }

    @Test
    public void hasDeterminant2() throws Exception {
        double[][] matr = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(matr);
        assertEquals(new Double(-2), matrix.hasDeterminant());
    }

    @Test
    public void hasDeterminantNull() throws Exception {
        double[][] matr = null;
        Matrix matrix = new Matrix(matr);
        assertNull(matrix.hasDeterminant());
    }

    @Test
    public void multiplyMatrixNull() throws Exception {
        double[][] matr = {{1, 2}, {3, 4}};
        double[][] matr2 = {{1, 2}};
        Matrix matrix = new Matrix(matr);
        Matrix matrix2 = new Matrix(matr2);
        assertNull(matrix.multiplyMatrix(matrix2));
    }

    @Test
    public void multiplyMatrixRectangle() throws Exception {
        double[][] matr = {{1, 2}, {3, 4}, {5, 6}};
        double[][] matr2 = {{7, 8, 9}, {10, 11, 12}};
        double[][] matr3 = {{27, 30, 33}, {61, 68, 75}, {95, 106, 117}};
        Matrix matrix = new Matrix(matr);
        Matrix matrix2 = new Matrix(matr2);
        assertArrayEquals(matr3, matrix.multiplyMatrix(matrix2).getArray());
    }

    @Test
    public void multiplyMatrixSquare() throws Exception {
        double[][] matr = {{1, 2}, {3, 4}};
        double[][] matr2 = {{5, 6}, {7, 8}};
        double[][] matr3 = {{19, 22}, {43, 50}};
        Matrix matrix = new Matrix(matr);
        Matrix matrix2 = new Matrix(matr2);
        assertArrayEquals(matr3, matrix.multiplyMatrix(matrix2).getArray());
    }

    @Test
    public void sumMatrix() throws Exception {
        double[][] matr = {{1, 2}, {3, 4}};
        double[][] matr2 = {{5, 6}, {7, 8}};
        double[][] matr3 = {{6, 8}, {10, 12}};
        Matrix matrix = new Matrix(matr);
        Matrix matrix2 = new Matrix(matr2);
        assertArrayEquals(matr3, matrix.sumMatrix(matrix2).getArray());
    }

    @Test
    public void sumMatrixNull() throws Exception {
        double[][] matr = {{1, 2}, {3, 4}};
        double[][] matr2 = null;
        Matrix matrix = new Matrix(matr);
        Matrix matrix2 = new Matrix(matr2);
        assertNull(matrix.sumMatrix(matrix2));
    }
}