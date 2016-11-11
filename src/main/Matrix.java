package main;

/**
 * @author Лобанов Михаил
 */

public class Matrix {
    private double matrix[][];

    public int getRowCount() {

        return matrix.length;
    }


    public int getColumnCount() {

        return matrix[0].length;
    }

    public double[][] getMatrix() {

        return matrix;
    }

    public Matrix(double[][] matr) {
        if (matr != null) {
            matrix = matr.clone();
        } else {
            matrix = null;
        }
    }

    /*
    Получить элемент
     */
    public double getElement(int numberRow, int numberColumn) {

        return matrix[numberRow][numberColumn];
    }

    /*
    Задать элемент
     */
    public void putElement(int numberRow, int numberColumn, double element) {
        matrix[numberRow][numberColumn] = element;
    }

    /*
    Сумма матриц
     */
    public Matrix sumMatrix(Matrix matr) {
        double sumResult[][];
        Matrix sumMatr = null;
        if ((getMatrix() != null) && (matr.getMatrix() != null) &&
                (getRowCount() == matr.getRowCount()) && (getColumnCount() == matr.getColumnCount())) {
            sumResult = new double[getRowCount()][getColumnCount()];
            for (int rowNumber = 0; rowNumber < getRowCount(); rowNumber++) {
                for (int columnNumber = 0; columnNumber < getColumnCount(); columnNumber++) {
                    sumResult[rowNumber][columnNumber] = getElement(rowNumber, columnNumber)
                            + matr.getElement(rowNumber, columnNumber);
                }
            }
            sumMatr = new Matrix(sumResult);
        }
        return sumMatr;
    }

    /*
    Произведение матриц
     */
    public Matrix multiplyMatrix(Matrix matr) {
        double multiplyResult[][];
        Matrix multiplyMatr = null;
        if ((getMatrix() != null) && (matr.getMatrix() != null) &&
                (getColumnCount() == matr.getRowCount())) {
            multiplyResult = new double[getRowCount()][matr.getColumnCount()];
            for (int rowNumber = 0; rowNumber < getRowCount(); rowNumber++) {
                for (int columnNumber = 0; columnNumber < matr.getColumnCount(); columnNumber++) {
                    multiplyResult[rowNumber][columnNumber] = 0;
                    for (int scalar = 0; scalar < getColumnCount(); scalar++) {
                        multiplyResult[rowNumber][columnNumber] += getElement(rowNumber, scalar)
                                * matr.getElement(scalar, columnNumber);
                    }
                }
            }
            multiplyMatr = new Matrix(multiplyResult);
        }
        return multiplyMatr;
    }

    /*
    Вычисление определителя
     */
    public Double hasDeterminant() {
        if ((getMatrix() != null) && (getRowCount() == getColumnCount())) {
            int N = getRowCount();
            double[][] matr = new double[N][N];
            double denom = 1;
            int exchanges = 0;

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    matr[i][j] = matrix[i][j];
                }
            }
            for (int i = 0; i < N - 1; ++i) {
                int maxN = i;
                double maxValue = Math.abs(matr[i][i]);
                for (int j = i + 1; j < N; ++j) {
                    double value = Math.abs(matr[j][i]);
                    if (value > maxValue) {
                        maxN = j;
                        maxValue = value;
                    }
                }
                if (maxN > i) {
                    double[] temp = matr[i];
                    matr[i] = matr[maxN];
                    matr[maxN] = temp;
                    ++exchanges;
                } else if (maxValue == 0) {
                    return maxValue;
                }
                double value1 = matr[i][i];
                for (int j = i + 1; j < N; ++j) {
                    double value2 = matr[j][i];
                    matr[j][i] = 0;
                    for (int k = i + 1; k < N; ++k) {
                        matr[j][k] = (matr[j][k] * value1 - matr[i][k] * value2) / denom;
                    }
                }
                denom = value1;
            }
            if (exchanges % 2 == 1) {
                return -matr[N - 1][N - 1];
            } else {
                return matr[N - 1][N - 1];
            }
        } else {
            return null;
        }
    }
}