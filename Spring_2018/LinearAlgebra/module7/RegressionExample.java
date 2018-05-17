// Instructions:
// (1) First display the points by compiling and executing.
// (2) Un-comment the least-squares section, add code to
//     apply least-squares. Then compile and execute.

import edu.gwu.lintool.*;

public class RegressionExample {

    public static void main(String[] argv) {

        DuquetteLinTool linTool = new DuquetteLinTool();

        // The data:
        int n = 8;
        double[] x = {1, 1.5, 2, 3.6, 5, 6.2, 8.5, 9};
        double[] y = {3.6, 3.9, 3.9, 5.1, 5.2, 6.0, 7.4, 7.2};

        // Display the points.
        DrawTool.display();
        DrawTool.setXYRange(0, 10, 0, 10);
        for (int i = 0; i < n; i++) {
            DrawTool.drawPoint(x[i], y[i]);
        }

        // Put the data in a matrix:
        double[][] A = {
                {1, 1},
                {1.5, 1},
                {2, 1},
                {3.6, 1},
                {5, 1},
                {6.2, 1},
                {8.5, 1},
                {9.0, 1}
        };
        // The RHS vector b is just y
        double[] b = y;

    // INSERT YOUR CODE HERE for least squares
	// Compute the transpose of A:
	double[][] AT = linTool.transpose(A);

	// Multiply A by AT (with AT on the left)
	double[][] ATA = linTool.mult(AT, A);

	// Get the inverse of ATA:
	LinResult L = linTool.inverse (ATA);
	if (L.Ainv == null) {
	    System.out.println ("No inverse exists for ATA");
	    System.exit (0);
	}
	linTool.print(L.Ainv);

	// Compute approx solution x = ATA^-1 * A^T * b in two steps:
    double[] ATb = linTool.matrixVectorMult(AT, b);
    // Step 2: multiply the result on the left by ATA^-1
    double[] xhat = linTool.matrixVectorMult(L.Ainv, ATb);

    System.out.println("xhat[0]=" + xhat[0] + " xhat[1]=" + xhat[1]);

	// xhat[0] = m (slope)
	// xhat[1] = c (y-intercept)
	System.out.println ("xhat[0]=" + xhat[0] + " xhat[1]=" + xhat[1]);

	// Draw the line. Here drawLineFromEquation() expects the
	// line specified in ax+by+c format. To convert from y=mx+c,
	// observe that a=m, b=-1, c=c.
	DrawTool.setLineColor ("blue");
	DrawTool.drawLineFromEquation (xhat[0], -1, xhat[1]);

    }

}
