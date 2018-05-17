// Instructions:
// Add or call your code for computing b(n,k,t)


import java.util.*;

public class DrawBernsteinParametric {

    public static void main (String[] argv)
    {
	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);

	// Four coefficients for x(t)
	double[] a = {1, 2, 3, 6};
	// Four coefficients for y(t)
	double[] b = {1, 5, 6, 2};

	// This is the "n" in b_{n,k}(t)
	int n = 3;

	double delT = 0.1;        // t-increment for drawing

	// First, we'll draw the line using DrawTool.
	ArrayList<Double> xValues = new ArrayList<Double> ();
	ArrayList<Double> yValues = new ArrayList<Double> ();

	for (double t=0; t<=1; t+=delT) {

	    // x(t) = a0*b(n,0,t) + a1*b(n,1,t) + a2*b(n,2,t) + a3*b(n,3,t)
	    // y(t) is similar, but with b0, b1, b2, b3.
	    double x = 0,  y = 0;
	    for (int k=0; k<=n; k++) {
		x += a[k] * bernstein(n,k,t);
		y += b[k] * bernstein(n,k,t);
	    }

	    xValues.add (x);
	    yValues.add(y);
	}

	// Draw the line.
	DrawTool.setLineColor ("blue");
	DrawTool.drawCurve (xValues, yValues);

    }

    static double bernstein (int n, int k, double t)
    {

	double b = numCombinations(n,k) * Math.pow (t, k) * Math.pow (1-t,n-k);
	return b;

	// INSERT YOUR CODE HERE:

    }

    static double numCombinations (int n, int k)
    {
	double numer = factorial(n);
	double denom = factorial(k)*factorial(n-k);
	return (numer/denom);

	// INSERT YOUR CODE HERE:
	
    }

    static double factorial (int n)
    {
	double prod = 1;
	while (n != 0) {
	    prod = prod*n;
	    n = n-1;
	}
	// INSERT YOUR CODE HERE:
	return prod;
    }

}