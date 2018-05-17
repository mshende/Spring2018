// Instructions:
// Compile and execute.
//
// Note: you will need lintool.jar in your CLASSPATH

import edu.gwu.lintool.*;

public class SVDExample {

    public static void main (String[] argv)
    {
	double[][] A = {
	    {2,1,3,0,3},
	    {1,0,1,1,2},
	    {3,2,5,-1,4}
	};

	LinResult L = LinToolLibrary.computeSVDShortForm (A);
	MshendeLinTool linTool = new MshendeLinTool();
	double[][] U = L.U;
	double[][] Sigma = L.Sigma;
	double[][] V = L.V;
	double[][] VT = linTool.transpose (V);
	
	// Print all three:
	LinUtil.print ("U", U);
	LinUtil.print ("Sigma", Sigma);
	LinUtil.print ("VT", VT);

	// Confirm product A = U*Sigma*V^T
	double[][] B = linTool.mult (U, Sigma);
	double[][] C = linTool.mult (B, VT);
	LinUtil.print ("C", C);
    }

}
