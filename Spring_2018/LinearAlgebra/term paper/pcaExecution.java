/**
 * Java Class to execute all parts of the PCA for the given example in the paper.
 */

import edu.gwu.lintool.*;

public class pcaExecution {

    public static void main(String[] args) {
        double[][] X = {{10, 4, 14, 8, 17, 12, 5, 18},
                {13, 1, 12, 10, 3, 5, 0, 14},
                {18, 12, 15, 3, 10, 6, 12, 0},
                {-3, 0, 19, 10, 2, 1, 17, 2}};

        // 1) Find the mean vector
        double[] mean = computeMean(X);
        System.out.println("Mean: ");
        print(mean);
        System.out.println();

        // 2) Center the data
        double[][] Xc = centerData(X, mean);
        System.out.println("Centered Data: ");
        print(Xc);
        System.out.println();

        // 3) Verify the centered data matrix
        double[] xcMean = computeMean(Xc);
        System.out.println("Verification Mean: ");
        print(xcMean);
        System.out.println();

        // 4) Compute the covariance matrix on the centered data
        double[][] C = computeCovarianceMatrix(X);
        System.out.println("Covariance Matrix: ");
        print(C);
        System.out.println();

        // 5) Get the eigenvector matrix
        LinResult L = LinToolLibrary.computeEigenvaluesAndVectors(C);
        double[][] S = L.S;
        System.out.println("Eigenvector Matrix: ");
        print(S);
        System.out.println();

        // 6) Sort columns of S by decreasing eigenvalue
        S = reverseColumns(L.S);
        System.out.println("Sorted Eigenvector Matrix: ");
        print(S);
        System.out.println();

        // 7) Change the coordinates of the data using the eigenvectors as the basis
        double[][] ST = transpose(S);
        double[][] Y = mult(ST, Xc);
        System.out.println("Change of Coordinates Matrix: ");
        print(Y);
        System.out.println();

        // 8) Convariance of Y should be the diagonal matrix
        double[][] YC = computeCovarianceMatrix(Y);
        System.out.println("Covariance Matrix of Change of Coordinates: ");
        print(YC);
        System.out.println();


    }

    private static double[] computeMean(double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        double[] mean = new double[m];

        for (int i = 0; i < m; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
            mean[i] = sum / n;
        }

        return mean;
    }

    private static double[][] centerData(double[][] matrix, double[] mean) {
        int m = matrix.length;
        int n = matrix[0].length;

        double[][] Y = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Y[i][j] = matrix[i][j] - mean[i];
            }
        }

        return Y;
    }

    private static double[][] computeCovarianceMatrix(double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        double[][] C = new double[m][m];

        for (int i = 0; i < n; i++) {
            double[][] tempC = new double[m][m];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    tempC[j][k] = matrix[j][i] * matrix[j][i];
                }
            }
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    C[j][k] += tempC[j][k];
                }
            }
        }
        C = scalarProduct((double) 1 / n, C);

        return C;
    }


    private static double[][] scalarProduct(double alpha, double[][] A) {
        if (A == null) {
            return null;
        }

        double[][] result = new double[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = alpha * A[i][j];
            }
        }

        return result;
    }

    private static double[][] reverseColumns(double[][] A) {
        double[][] B = new double[A.length][A[0].length];
        int numCols = A[0].length;
        for (int k = 0; k < numCols; k++) {
            // k-th col of B = numCols-1-k column of A;
            for (int i = 0; i < A.length; i++) {
                B[i][k] = A[i][numCols - 1 - k];
            }
        }
        return B;
    }

    private static double[][] mult(double[][] A, double[][] B) {
        //A.length = A Rows
        //A[n].length = A Columns
        //B.length = B Rows
        //B[n].length = B Columns
        if (A == null || B == null) {
            return null;
        }

        if (A[0].length != B.length) {
            return null;
        }

        double[][] result = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    private static double[][] transpose(double[][] A) {
        //A.length = A Rows
        //A[n].length = A Columns
        if (A == null) {
            return null;
        }

        double[][] result = new double[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }

    private static void print(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void print(double[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
}
