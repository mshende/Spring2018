// Instructions:
// Write code in computeMean() 

public class SimpleExample {

    public static void main(String[] argv) {
        MshendeLinTool linTool = new MshendeLinTool();

        double[][] X = {
                {1.0, 1.5, 0.5, 2.0, 1.5, 2.5},
                {2.5, 3.5, 3.0, 4.0, 4.5, 0.5},
                {-1.0, 0.5, 0, -0.5, 0, 1.0}
        };
        double[] mean = computeMean(X);
        linTool.printVector(mean);
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
        // INSERT YOUR CODE HERE:

        return mean;
    }

}
