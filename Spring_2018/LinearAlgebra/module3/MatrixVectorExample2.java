// Instructions:
// Write code in the matrixMult() method to compute the
// the product of two matrices. Also, copy over your code
// for matrixVectorMult() from MatrixVectorExample.java

public class MatrixVectorExample2 {

    public static void main (String[] argv)
    {
	double[][] A = {
	    {2, -3},
            {0, 1}
        };
	double[][] B = {
	    {1, 2},
            {0, -3}
        };
	double[] x = {2, 3};

	double[][] C = matrixMult (B, A);
	print (C);

	double[] z = matrixVectorMult (C, x);
	print (z);

	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);
	DrawTool.drawVector (x);
	DrawTool.setArrowColor ("green");
	DrawTool.drawVector (z);

    }


    static double[][] matrixMult (double[][] A, double[][] B)
    {

	double[][] transposeB = new double[B[0].length][B.length];
	for (int i=0; i<B.length; i++) {
	    for (int j=0; j<B[0].length; j++) {
		transposeB[j][i] = B[i][j];
	    }
	}
	double[][] result = new double[transposeB.length][A.length];
	for (int i=0; i<transposeB.length;i++) {
	    result[i] = matrixVectorMult(A, transposeB[i]);
	}

	// INSERT YOUR CODE HERE to compute A times B.
	// Here, A and B are just parameters and not the same
	// as the A and B matrices in main().
	return result;
    }

    static double[] matrixVectorMult (double[][] A, double[] v)
    {
	double [] result = new double[v.length];
	for (int i=0; i<A.length; i++) {
	    double sum = 0;
	    for (int j=0; j < v.length; j++) {
		sum = sum + A[i][j] * v[j];
	    }
	    result[i] = sum;
	}
	return result;
    }


    static void print (double[] x)
    {
	System.out.print ("Vector:");
	for (int i=0; i<x.length; i++) {
	    System.out.printf (" %6.3f", x[i]);
	}
	System.out.println ();
    }

    static void print (double[][] A)
    {
	System.out.println ("Matrix (" + A.length + "x" + A[0].length + "):");
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<A[0].length; j++) {
		System.out.printf (" %6.3f", A[i][j]);
	    }
	    System.out.println ();
	}
    }

}
