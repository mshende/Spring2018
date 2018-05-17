// Instructions:
// Compile and execute

public class PowerMethodExample {

    public static void main(String[] argv) {
        MshendeLinTool linTool = new MshendeLinTool();

        double[][] A = {
                {5, -2},
                {0, 1}
        };

        // Now start with some initial vector u0
        double[] u0 = {1, 1};

        int numIterations = 10;

        // We'll also compute powers of A for illustration.
        double[][] A_power_k = copy(A);

        // Initialize:
        double[] u = {u0[0], u0[1]};

        for (int k = 1; k <= numIterations; k++) {
            u = linTool.matrixVectorMult(A, u);
            u = normalize(u);
            linTool.print(u);
            A_power_k = linTool.mult(A, A_power_k);
        }

        // Compute lambda = (Au dot u) / (u dot u)
        double[] y = linTool.matrixVectorMult(A, u);
        double lambda = linTool.dotProduct(y, u) / linTool.dotProduct(u, u);
        System.out.println("lambda=" + lambda);

        // Compare with A^k * u
        double[] x = linTool.matrixVectorMult(A_power_k, u0);
        linTool.printVector(x);
    }


    static double[] normalize(double[] x) {
        MshendeLinTool linTool = new MshendeLinTool();

        double normX = linTool.norm(x);
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = (1.0 / normX) * x[i];
        }
        return y;
    }

    static double[][] copy(double[][] A) {
        double[][] B = new double[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                B[i][j] = A[i][j];
            }
        }
        return B;
    }

}

