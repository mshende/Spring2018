// Instructions
// Copy over your code for computing the mean, and centering the data.
// Write code in computeCovariance() to compute the covariance.

public class SimpleExample3 {

    public static void main(String[] argv) {
        MshendeLinTool linTool = new MshendeLinTool();

        double[][] X = {
                {1.0, 1.5, 0.5, 2.0, 1.5, 2.5},
                {2.5, 3.5, 3.0, 4.0, 4.5, 0.5},
                {-1.0, 0.5, 0, -0.5, 0, 1.0}
        };

        double[] mean = computeMean(X);
        linTool.printVector(mean);

        // Subtract the mean from each column.
        X = centerData(X, mean);
        linTool.printArray(X);

        // Compute the mean again to check:
        mean = computeMean(X);
        linTool.printVector(mean);

        // Covariance matrix:
        double[][] C = computeCovariance(X);
        linTool.printArray(C);
    }

    static double[] computeMean(double[][] X) {
        int m = X.length;
        int n = X[0].length;
        double[] mean = new double[m];

        // INSERT YOUR CODE HERE:
        for(int i = 0; i < m; i++) {
            double sum = 0;
            for(int j = 0; j < n; j++) {
                sum += X[i][j];
            }
            mean[i] = sum / n;
        }

        return mean;
    }

    static double[][] centerData(double[][] X, double[] mean) {
        int m = X.length;
        int n = X[0].length;

        double[][] Y = new double[m][n];

        // INSERT YOUR CODE HERE to put the centered data in Y
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Y[i][j] = X[i][j] - mean[i];
            }
        }

        return Y;
    }

    static double[][] computeCovariance(double[][] X) {
	MshendeLinTool linTool = new MshendeLinTool();
        int m = X.length;
        int n = X[0].length;
        double[][] C = new double[m][m];
        // INSERT YOUR CODE HERE:
        for(int i = 0; i < n; i++) {
	    double[][]tempC = new double[m][m];
            for(int j = 0; j < m; j++) {
		for (int k=0; k<m; k++) {
		    tempC[j][k] = X[j][i] * X[j][i];
		}
            }
	    for (int j=0; j<m; j++) {
		for (int k=0; k<m; k++) {
		    C[j][k] += tempC[j][k];
		}
	    }
        }
	linTool.printArray(C);
	C = linTool.scalarProduct((double)1/n, C);

        return C;
    }

}
