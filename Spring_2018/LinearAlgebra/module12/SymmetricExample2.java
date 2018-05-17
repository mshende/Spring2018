// Instructions:
// Create a rank=1 symmetric matrix
//
// Note: you will need lintool in your CLASSPATH

import edu.gwu.lintool.*;

public class SymmetricExample2 {

    public static void main (String[] argv)
    {
	// Symmetric A, 3x3, rank=1
	double[][] A = {{0.5, 1, 0.5},
			{1, 2, 1},
			{0.5, 1, 0.5}};

	LinResult L = LinToolLibrary.computeEigenvaluesAndVectors (A);

	// The eigenvalues.
	LinUtil.print ("lambda", L.lambda);
    }


}
