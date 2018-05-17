// Instructions:
// Write code for matrix-matrix multiplication and matrix-vector multiplication

public class MatrixTool {

    public static double[] matrixVectorMult(double[][] A, double[] v) {
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

    public static double[][] matrixMult(double[][] A, double[][] B) {

        double[][] transposeB = new double[B[0].length][B.length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                transposeB[j][i] = B[i][j];
            }
        }
        double[][] result = new double[transposeB.length][A.length];
        for (int i = 0; i < transposeB.length; i++) {
            result[i] = matrixVectorMult(A, transposeB[i]);
        }
        return result;
    }


    public static void print(double[] x) {
        System.out.print("Vector:");
        for (int i = 0; i < x.length; i++) {
            System.out.printf(" %6.3f", x[i]);
        }
        System.out.println();
    }

    public static void print(double[][] A) {
        System.out.println("Matrix (" + A.length + "x" + A[0].length + "):");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.printf(" %6.3f", A[i][j]);
            }
            System.out.println();
        }
    }

    public static double dotProduct(double[] v, double[] u) {
        double result = 0;
        if ((u == null) || (v == null)) {
            result = -1;
        } else {
            if (u.length != v.length) {
                result = -1;
            } else {
                for (int i = 0; i < u.length; i++) {
                    result = result + u[i] * v[i];
                }
            }
        }
        return result;
    }

    public static double norm(double[] u) {
        double result = 0;
        if (u == null) {
            result = -1;
        } else {
            for (int i = 0; i < u.length; i++) {
                result = result + u[i] * u[i];
            }
            result = Math.sqrt(result);
        }
        return result;
    }

    public static double[] scalarProduct(double alpha, double[] v) {
        double[] result = new double[0];
        if (v == null) {
            result = v;
        } else {
            result = new double[v.length];
            for (int i = 0; i < v.length; i++) {
                result[i] = alpha * v[i];
            }
        }
        return result;
    }

    public static double[] proj(double[] v, double[] u) {
        double[] result;
        if ((u == null) || (v == null)) {
            result = null;
        } else {
            double udotv = dotProduct(u, v);
            double udotu = dotProduct(u, u);
            result = scalarProduct(udotv / udotu, u);
        }
        return result;
    }

    public static double[] add(double[] u, double[] v) {
        double[] w = new double[u.length];
        for (int i = 0; i < w.length; i++) {
            w[i] = u[i] + v[i];
        }
        return w;

    }

    public static double[] sub(double[] u, double[] v) {
        double[] w = new double[u.length];
        for (int i = 0; i < w.length; i++) {
            w[i] = u[i] - v[i];
        }
        return w;
    }
}
