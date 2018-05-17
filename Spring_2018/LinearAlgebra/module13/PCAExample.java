
import org.edisonwj.draw3d.*;
import edu.gwu.lintool.*;

public class PCAExample {

    public static void main (String[] argv)
    {
	// Data matrix: the columns are the 3-dim data values (such
	// as temp, pressure, wind-speed).
	double[][] D = {
	    {9.0, 8.1, 7.2, 8.5, 9.1},
	    {3.1, 2.2, 1.1, 2.3, 3.2},
	    {5.3, 5.4, 5.1, 5.0, 4.9},
	};

	// PCA #1: normalize.
	double[][] X = SVDStats.normalizeData (D);
	LinUtil.print ("X", X);
	// PCA #2: X*X^T
	double[][] XT = SVDStats.transpose (X);
	double[][] C = SVDStats.matrixMult (X, XT);
	// PCA #3: Eigenvectors of C.
	LinResult L = LinToolLibrary.computeEigenvaluesAndVectors (C);
	double[][] S = SVDStats.reverseColumns (L.S);
	double[][] ST = SVDStats.transpose (S);
	// PCA #4: Change coords.
	double[][] Y = SVDStats.matrixMult (ST, X);

	// Covariance of transformed data:
	double[][] YT = SVDStats.transpose (Y);
	double[][] C2 = SVDStats.matrixMult (Y, YT);

	// Print covariance to compare. Does it provide insight?
	LinUtil.print ("C", C);
	LinUtil.print ("C2", C2);
    }

}
