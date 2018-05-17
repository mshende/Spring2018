// Copy over your code for bernstein(n,k,t)
// Try n=3,5,10.

public class BernsteinApprox {

    public static void main (String[] argv)
    {
	Function F = new Function ("sin(2*pi t)/t");
	Function B = new Function ("Bernstein approx");

	double delT = 0.05;

	// Try n=3,5,10
	int n = 10;
	
	for (double t=delT; t<=1+delT; t+=delT) {

	    // Original function.
	    F.add (t, func(t));

	    // Bernstein approximation to func.
	    double b = 0;
	    for (int k=0; k<=n; k++) {
		// f(k/n) * b_{n,k}(t)
		b += func ( (double)k/n ) * bernstein (n,k,t);
	    }	    

	    B.add (t, b);
	}

	Function.show (F, B);
    }

    static double func (double t)
    {
	return Math.sin(2*Math.PI*t);
    }

    public static double bernstein (int n, int k, double t)
    {
	double b = numCombinations(n,k) * Math.pow (t, k) * Math.pow (1-t,n-k);
	return b;
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
