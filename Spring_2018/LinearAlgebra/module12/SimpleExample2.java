// Instructions:
// Write code in centerData() to center the data. Copy over your
// code for computing the mean.

public class SimpleExample2 {

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

        // Compute the mean again to check:
        mean = computeMean(X);
        linTool.print(mean);

    }

    static double[] computeMean(double[][] X) {
        int m = X.length;
        int n = X[0].length;
        double[] mean = new double[m];

	for (int i=0; i<m; i++) {
	    mean[i] = 0;
	}
	for (int k=0; k<n; k++) {
	    for (int i=0; i<m; i++) {
		mean[i] = mean[i] + X[i][k];
	    }
	}
	mean = MatrixTool.scalarProduct((double)1/n, mean);

        return mean;
    }

    static double[][] centerData(double[][] X, double[] mean) {
        int m = X.length;
        int n = X[0].length;

        double[][] Y = new double[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Y[i][j] = X[i][j] - mean[i];
            }
        }
        return Y;
    }

}
