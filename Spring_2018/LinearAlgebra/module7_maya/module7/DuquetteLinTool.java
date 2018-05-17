import edu.gwu.lintool.*;
import java.lang.Math;
import java.util.*;
import java.lang.Object;

public class DuquetteLinTool extends LinToolEmpty {

    /**
     * Assignment 1
     */

    // Vector operations:
    public double[] add(double[] u, double[] v) {
        if (u == null || v == null) {
            return null;
        }

        if (u.length != v.length) {
            return null;
        }

        double [] result = new double[u.length];
        for (int i = 0; i < u.length; i++) {
            result[i] = u[i] + v[i];
        }

        return result;
    }

    public double norm(double[] v) {
        if (v == null) {
            return -1;
        }

        double result = 0;
        for (int i = 0; i < v.length; i++) {
            result += Math.pow(v[i], 2);
        }

        return Math.sqrt(result);
    }

    public double dotProduct(double[] u, double[] v) {
        if (u == null || v == null) {
            return -1;
        }

        if (u.length != v.length) {
            return -1;
        }

        double result = 0;
        for (int i = 0; i < u.length; i++) {
            result += u[i] * v[i];
        }

        return result;
    }

    public double[] scalarProduct(double alpha, double[] v) {
        if (v == null) {
            return null;
        }

        double[] result = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            result[i] = alpha * v[i];
        }

        return result;
    }

    public boolean approxEquals(double[] u, double[] v, double errorTolerance) {
        if (u == null || v == null) {
            return false;
        }

        if (u.length != v.length) {
            return false;
        }

        double result = 0;
        for (int i = 0; i < u.length; i++) {
            double diff = u[i] - v[i];
            result += diff * diff;
        }

        if (result < errorTolerance) {
            return true;
        } else {
            return false;
        }
    }

    public double cosine(double[] u, double[] v) {
        if (u == null || v == null) {
            return -1;
        }

        if (u.length != v.length) {
            return -1;
        }

        double result = dotProduct(u, v) / (norm(u) * norm(v));
        return result;
    }

    // Matrix operations:
    public double[][] add(double[][] A, double[][] B) {
        if (A == null || B == null) {
            return null;
        }

        if (A.length != B.length || A[0].length != B[0].length) {
            return null;
        }

        double[][] result = new double[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }

    public double[][] scalarProduct(double alpha, double[][] A) {
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

    public double[][] mult(double[][] A, double[][] B) {
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

    public double[] matrixVectorMult(double[][] A, double[] v) {
        //A.length = A Rows
        //A[n].length = A Columns
        if (A == null || v == null) {
            return null;
        }

        if (A[0].length != v.length) {
            return null;
        }

        double[] result = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = dotProduct(A[i], v);
        }
        return result;
    }

    public double[] vectorMatrixMult(double[] v, double[][] A) {
        //A.length = A Rows
        //A[n].length = A Columns
        if (A == null || v == null) {
            return null;
        }

        if (A.length != v.length) {
            return null;
        }

        double[] result = new double [A[0].length];
        double[][] transposedA = transpose(A);
        for (int i = 0; i < transposedA.length; i++) {
            result[i] = dotProduct(transposedA[i], v);
        }

        return result;
    }

    public double[][] vectorLeftMult(double[] u, double[] v) {
        if (u == null |  v == null) {
            return null;
        }

        double[][] result = new double[u.length][v.length];
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < v.length; j++) {
                result[i][j] = u[i] * v[j];
            }
        }

        return result;
    }

    public double[][] transpose(double[][] A) {
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

    public double frobeniusNorm(double[][] A) {
        if (A == null) {
            return -1;
        }

        double result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result += Math.pow(A[i][j], 2);
            }
        }

        return Math.sqrt(result);
    }

    public boolean approxEquals(double[][] A, double[][] B, double errorTolerance) {
        if (A == null || B == null) {
            return false;
        }

        if (A.length != B.length || A[0].length != B[0].length) {
            return false;
        }

        double result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                double diff = A[i][j] - B[i][j];
                result += diff * diff;
            }
        }

        if (result < errorTolerance) {
            return true;
        } else {
            return false;
        }

    }

    public double[] getColumnAsVector(double[][] A, int col) {
        //A.length = A Rows
        //A[n].length = A Columns

        if (col > A[0].length) {
            return null;
        }

        double[] result = new double[A.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = A[i][col - 1];
        }

        return result;

    }

    public double[] getRowAsVector(double[][] A, int row) {
        //A.length = A Rows
        //A[n].length = A Columns

        if (row > A.length) {
            return null;
        }

        double[] result = new double[A[0].length];
        for (int i = 0; i < result.length; i++) {
            result[i] = A[row - 1][i];
        }

        return result;
    }


    /**
     * Assignment 2
     */

    //Solving Equations:
    public LinResult computeREF(double[][] A, double[] b) {
        if(A == null || b == null) {
            return null;
        }

        if(A.length != b.length) {
            return null;
        }

        LinResult linResult = computeREFHelper(A, b);

        return linResult;
    }

    public LinResult computeRREF(double[][] A, double[] b) {
        if(A == null || b == null) {
            return null;
        }

        if(A.length != b.length) {
            return null;
        }

        LinResult linResult = computeRREFHelper(A, b);

        return linResult;
    }

    public LinResult solveFromREF(double[][] A, double[] b) {
        if(A == null || b == null) {
            return null;
        }

        if(A.length != b.length) {
            return null;
        }

        LinResult linResult = computeRREFHelper(A, b);

        if(existsConradictionRow(linResult.ref)) {
            linResult.solutionExists = false;
            linResult.x = null;
            linResult.isUniqueSolution = false;
        } else if (existsAllZeroRows(linResult.ref) || (linResult.rank != A[0].length)) {
            if(linResult.rank != A[0].length) {
                linResult.solutionExists = true;
                linResult.isUniqueSolution = false;
                linResult.x = new double[A[0].length];
                for (int i = 0; i < linResult.x.length; i++) {
                    if (i < linResult.ref.length) {
                        linResult.x[i] = linResult.rref[i][linResult.ref[0].length - 1];
                    } else {
                        int range = (10 - 1) + 1;
                        linResult.x[i] = (int) (Math.random() * range) + 1;
                    }
                }
            } else {
                linResult.solutionExists = true;
                linResult.isUniqueSolution = true;
                linResult.x = new double[A[0].length];
                for (int i = 0; i < linResult.x.length; i++) {
                    if (i < linResult.ref.length) {
                        linResult.x[i] = linResult.rref[i][linResult.ref[0].length - 1];
                    } else {
                        int range = (10 - 1) + 1;
                        linResult.x[i] = (int) (Math.random() * range) + 1;
                    }
                }
            }
        } else {
            linResult.solutionExists = true;
            linResult.isUniqueSolution = true;
            linResult.x = new double[A[0].length];
            for (int i = linResult.x.length - 1; i >= 0; i--) {
                linResult.x[i] = linResult.rref[i][linResult.ref[0].length - 1];
            }
        }

        return linResult;
    }

    public LinResult solveFromRREF(double[][] A, double[] b) {
        if(A == null || b == null) {
            return null;
        }

        if(A.length != b.length) {
            return null;
        }

        LinResult linResult = computeRREFHelper(A, b);

        if(existsConradictionRow(linResult.rref)) {
            linResult.solutionExists = false;
            linResult.x = null;
            linResult.isUniqueSolution = false;
        } else if (existsAllZeroRows(linResult.rref) || (linResult.rank != A[0].length)) {
            if(linResult.rank != A[0].length) {
                linResult.solutionExists = true;
                linResult.isUniqueSolution = false;
                linResult.x = new double[A[0].length];
                for (int i = 0; i < linResult.x.length; i++) {
                    if (i < linResult.rref.length) {
                        linResult.x[i] = linResult.rref[i][linResult.rref[0].length - 1];
                    } else {
                        int range = (10 - 1) + 1;
                        linResult.x[i] = (int) (Math.random() * range) + 1;
                    }
                }
            } else {
                linResult.solutionExists = true;
                linResult.isUniqueSolution = true;
                linResult.x = new double[A[0].length];
                for (int i = 0; i < linResult.x.length; i++) {
                    if (i < linResult.rref.length) {
                        linResult.x[i] = linResult.rref[i][linResult.rref[0].length - 1];
                    } else {
                        int range = (10 - 1) + 1;
                        linResult.x[i] = (int) (Math.random() * range) + 1;
                    }
                }
            }
        } else {
            linResult.solutionExists = true;
            linResult.isUniqueSolution = true;
            linResult.x = new double[A[0].length];
            for (int i = 0; i < linResult.x.length; i++) {
                linResult.x[i] = linResult.rref[i][linResult.rref[0].length - 1];
            }
        }

        return linResult;
    }

    public LinResult inverse(double[][] A) {
        if(A == null) {
            return null;
        }

        double[] b = new double[A.length];
        LinResult linResult = computeRREFHelper(A, b);

        return linResult;
    }

    //Complex Vector Operations:
    public ComplexNumber[] add(ComplexNumber[] u, ComplexNumber[] v) {
        if(u == null || v == null) {
            return null;
        }

        if(u.length != v.length) {
            return null;
        }

        for(int i = 0; i < u.length; i++) {
            u[i].re = u[i].re + v[i].re;
            u[i].im = u[i].im + v[i].im;
        }

        return u;
    }

    public double norm(ComplexNumber[] u, ComplexNumber[] v) {
        if(u == null || v == null) {
            return -1;
        }

        if(u.length != v.length) {
            return -1;
        }

        double result = 0;
        for(int i = 0; i < u.length; i++) {
            result += ((Math.pow(u[i].re, 2) + Math.pow(u[i].im, 2)) + (Math.pow(v[i].re, 2) + Math.pow(v[i].im, 2)));
        }

        return Math.sqrt(result);
    }

    public ComplexNumber[] scalarProduct(ComplexNumber alpha, ComplexNumber[] v) {
        if (v == null) {
            return null;
        }

        for (int i = 0; i < v.length; i++) {
            v[i].re = alpha.re*v[i].re - alpha.im*v[i].im;
            v[i].im = alpha.re*v[i].im + alpha.im*v[i].re;
        }

        return v;
    }

    //Note: dot product is the Hermitian dot product:
    public ComplexNumber dotProduct(ComplexNumber[] u, ComplexNumber[] v) {
        if(u == null || v == null) {
            return null;
        }

        if(u.length != v.length) {
            return null;
        }

        ComplexNumber result = u[0];
        result.re = 0;
        result.im = 0;

        //Multipling the components of the vectors
        for(int i = 0; i < u.length; i++) {
            result.re += u[i].re*v[i].re - u[i].im*(-1 * v[i].im);
            result.im += u[i].re*(-1 * v[i].im) + u[i].im*v[i].re;
        }

        return result;
    }


    /**
     * Assignment 3
     */

    //Orthogonality:
    public boolean areColumnsLI (double[][] A) {
        if(A == null) {
            return false;
        }

        double[] b = new double[A.length];
        LinResult linResult = computeRREFHelper(A, b);

        if(linResult.rank != A[0].length) {
            return false;
        }

        return true;
    }

    public LinResult gramSchmidt (double[][] A) {
        LinResult linResult = new LinResult();
        if (A == null) {
            return null;
        }

        int n = A[0].length;

        if(areColumnsLI(A)) {
            linResult.V = new double[A.length][A[0].length];
            linResult.Q = new double[A.length][A[0].length];
            linResult.R = new double[A.length][A[0].length];

            double[] w0 = fetchColumn(A, 0);
            double[] v0 = w0;
            linResult.V = addVectorToMatrix(linResult.V, v0, 0);
            linResult.R[0][0] = norm(v0);

            double[] u0 = new double[v0.length];
            for(int i = 0; i < v0.length; i++) {
                u0[i] = v0[i] / norm(v0);
            }
            linResult.Q = addVectorToMatrix(linResult.Q, u0, 0);

            for(int k = 1; k < n; k++) {
                double[] wk = fetchColumn(A, k);
                double[] s = new double[wk.length];

                for(int j = 0; j < k; j++) {
                    double[] vj = fetchColumn(linResult.V, j);
                    double cjk = dotProduct(wk, vj) / dotProduct(vj, vj);
                    double[] sj = scalarProduct(cjk, vj);
                    s = add(s, sj);

                    linResult.R[j][k] = cjk * norm(vj);
                }

                double[] vk = sub(wk, s);
                linResult.V = addVectorToMatrix(linResult.V, vk, k);

                linResult.R[k][k] = norm(vk);

                double[] uk = new double[vk.length];
                for(int i = 0; i < vk.length; i++) {
                    uk[i] = vk[i] / norm(vk);
                }
                linResult.Q = addVectorToMatrix(linResult.Q, uk, k);

            }
        }

        return linResult;
    }


    public LinResult computeQR (double[][] A) {
        return gramSchmidt(A);
    }

    //Complex matrix operations:
    public ComplexNumber[][] add (ComplexNumber[][] A, ComplexNumber[][] B) {
        if (A == null || B == null) {
            return null;
        }

        if (A.length != B.length || A[0].length != B[0].length) {
            return null;
        }

        ComplexNumber[][] result = new ComplexNumber[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = ComplexNumber.makeComplexNumber((A[i][j].re + B[i][j].re), (A[i][j].im + B[i][j].im));
            }
        }

        return result;
    }

    public ComplexNumber[][] scalarProduct (ComplexNumber alpha, ComplexNumber[][] A) {
        if (A == null) {
            return null;
        }

        ComplexNumber[][] result = new ComplexNumber[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = ComplexNumber.makeComplexNumber((alpha.re * A[i][j].re), ((-1) * alpha.im * A[i][j].im));
            }
        }

        return result;
    }

    public ComplexNumber[][] mult (ComplexNumber[][] A, ComplexNumber[][] B) {
        if (A == null || B == null) {
            return null;
        }

        if (A[0].length != B.length) {
            return null;
        }

        ComplexNumber[][] result = new ComplexNumber[A.length][B[0].length];

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                result[i][j] = ComplexNumber.makeComplexNumber(0, 0);
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] = result[i][j].add(A[i][k].mult(B[k][j]));
                }
            }
        }

        return result;
    }

    public ComplexNumber[] matrixVectorMult (ComplexNumber[][] A, ComplexNumber[] v) {
        if (A == null || v == null) {
            return null;
        }

        if (A[0].length != v.length) {
            return null;
        }

        ComplexNumber[] result = new ComplexNumber[v.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = ComplexNumber.makeComplexNumber(0, 0);
            for(int j = 0; j < A[0].length; j++) {
                result[i] = result[i].add(A[i][j].mult(v[j]));
            }
        }

        return result;
    }

    public ComplexNumber[][] hermitianTranspose (ComplexNumber[][] A) {
        if (A == null) {
            return null;
        }

        ComplexNumber[][] result = new ComplexNumber[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[j][i] = ComplexNumber.makeComplexNumber((A[i][j].re), ((-1) * A[i][j].im));
            }
        }

        return result;
    }


    /**
     * Private Helper Methods
     */

    private LinResult computeREFHelper(double[][] A, double[] b) {
        LinResult linResult = new LinResult();
        linResult.A = A;
        linResult.b = b;

        linResult.isPivotColumn = new boolean[A[0].length];
        linResult.pivotRow = new int[A[0].length];
        for(int i = 0; i < linResult.pivotRow.length; i++) {
            linResult.pivotRow[i] = -1;
        }

        double[][] augementMatrix = computeAugmentedMatrix(A, b);
        double[][] identityMatrix = formIdentityMatrix(A[0].length);
        int currentRow = 0;
        int currentColumn = 0;

        int[] nextPivot = findNextPivot(A, currentRow, currentColumn);

        while((nextPivot[0] < A.length) && (nextPivot[1] < A[0].length)) {
            if(nextPivot[0] > currentRow) {
                augementMatrix = swap(augementMatrix, nextPivot[0], currentRow);
                identityMatrix = swap(identityMatrix, nextPivot[0], currentRow);
            }
            currentColumn = nextPivot[1];

            linResult.isPivotColumn[currentColumn] = true;
            linResult.rank += 1;
            linResult.pivotRow[currentColumn] = currentRow;

            double alpha = augementMatrix[currentRow][currentColumn];

            for(int j = 0 ; j < augementMatrix[0].length; j++) {
                augementMatrix[currentRow][j] = augementMatrix[currentRow][j] / alpha;
                if((j < identityMatrix[0].length) && (currentRow < identityMatrix.length)) {
                    identityMatrix[currentRow][j] = identityMatrix[currentRow][j] / alpha;
                }
            }

            for(int i = currentRow+1; i < augementMatrix.length; i++) {
                double beta = augementMatrix[i][currentColumn];
                for(int j = 0; j < augementMatrix[0].length; j++) {
                    augementMatrix[i][j] = augementMatrix[i][j] - beta*augementMatrix[currentRow][j];
                    if((j < identityMatrix[0].length) && (currentRow < identityMatrix.length) && (i < identityMatrix.length)) {
                        identityMatrix[i][j] = identityMatrix[i][j] - beta * identityMatrix[currentRow][j];
                    }
                }
            }

            currentRow++;
            currentColumn++;
            nextPivot = findNextPivot(augementMatrix, currentRow, currentColumn);
        }

        linResult.ref = augementMatrix;
        linResult.Ainv = identityMatrix;

        return linResult;
    }

    private LinResult computeRREFHelper(double[][] A, double[] b) {
        LinResult linResult = computeREFHelper(A, b);
        double[][] augementMatrix = new double[linResult.ref.length][linResult.ref[0].length];
        for(int i = 0; i < augementMatrix.length; i++) {
            for(int j = 0; j < augementMatrix[0].length; j++) {
                augementMatrix[i][j] = linResult.ref[i][j];
            }
        }

        int rp,cp;

        for(int i = 0; i < linResult.isPivotColumn.length; i++) {
            if(linResult.isPivotColumn[i]) {
                rp = linResult.pivotRow[i];
                cp = i;
                for (int r = rp - 1; r >= 0; r--) {
                    double beta = augementMatrix[r][cp];
                    for (int j = cp; j < augementMatrix[0].length; j++) {
                        augementMatrix[r][j] = augementMatrix[r][j] - beta * augementMatrix[rp][j];
                    }
                    for (int j = 0; j < linResult.Ainv[0].length; j++) {
                        linResult.Ainv[r][j] = linResult.Ainv[r][j] - beta * linResult.Ainv[rp][j];
                    }
                }
            }
        }

        linResult.rref = augementMatrix;

        if((linResult.rank != A.length) || (linResult.rank != A[0].length)) {
            linResult.Ainv = null;
        }

        return linResult;
    }

    private double[][] computeAugmentedMatrix(double[][] A, double[] b) {
        double[][] result = new double[b.length][A[0].length + 1];

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < (result[0].length - 1); j++) {
                result[i][j] = A[i][j];
            }
        }

        for(int i = 0; i < b.length; i++) {
            result[i][A[0].length] = b[i];
        }

        return result;
    }

    private double[][] formIdentityMatrix(int n) {
        double[][] identityMatrix = new double[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    identityMatrix[i][j] = 1;
                } else {
                    identityMatrix[i][j] = 0;
                }
            }
        }

        return identityMatrix;
    }

    private int[] findNextPivot(double[][] A, int currentRow, int currentColumn) {
        int r = A.length;
        int c = A[0].length;

        for(int j = currentColumn; j < A[0].length; j++) {
            for (int i = currentRow; i < A.length; i++) {
                if (A[i][j] != 0) {
                    r = i;
                    c = j;
                    return new int[]{r, c};
                }
            }
        }
        return new int[]{r, c};
    }

    private double[][] swap(double[][] matrix, int r, int currentRow) {
        double[][] result = new double[matrix.length][matrix[0].length];
        int diff = r - currentRow;

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                if(i == currentRow) {
                    result[i][j] = matrix[i+diff][j];
                } else if(i == r) {
                    result[i][j] = matrix[i-diff][j];
                } else {
                    result[i][j] = matrix[i][j];
                }
            }
        }

        return result;
    }

    private boolean existsConradictionRow(double[][] matrix) {
        double sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length - 1; j++) {
                sum += Math.abs(matrix[i][j]);
            }

            if ((sum == 0) && (matrix[i][matrix[0].length - 1] != 0)) {
                return true;
            }
            sum = 0;
        }
        return false;
    }

    private boolean existsAllZeroRows(double[][] matrix) {
        double sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                sum += Math.abs(matrix[i][j]);
            }
            if (sum == 0) {
                return true;
            }
            sum = 0;
        }
        return false;
    }

    private double[] fetchColumn(double[][] matrix, int columnIndex) {
        double[] column = new double[matrix.length];

        for(int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }

        return column;
    }

    private double[][] addVectorToMatrix(double[][] matrix, double[] vector, int columnIndex) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][columnIndex] = vector[i];
        }
        return matrix;
    }

    public double[] sub(double[] u, double[] v) {
        if (u == null || v == null) {
            return null;
        }

        if (u.length != v.length) {
            return null;
        }

        double [] result = new double[u.length];
        for (int i = 0; i < u.length; i++) {
            result[i] = u[i] - v[i];
        }

        return result;
    }

    public void print(double[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void print(ComplexNumber[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j].re + " + " + matrix[i][j].im + "i  ");
            }
            System.out.println();
        }
    }

    public void print(double[] vector) {
        for(int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    public void print(ComplexNumber[] vector) {
        for(int i = 0; i < vector.length; i++) {
            System.out.print(vector[i].re + " + " + vector[i].im + "i  ");
        }
        System.out.println();
    }

}