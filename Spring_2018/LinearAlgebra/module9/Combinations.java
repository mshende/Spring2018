// Instructions:
// Write code in factorial() and then numCombinations()
// Calculate by hand numCombinations(5,k) for k=0,1,..,5.
// Compare with the computation.

public class Combinations {

    public static void main (String[] argv)
    {
	// Try k=0,1,2,3,4,5.
	int k = 5;
	int r = numCombinations (5,k);
	System.out.println (r);
    }

    static int numCombinations (int n, int k)
    {
	int numer = factorial(n);
	int denom = factorial(k)*factorial(n-k);
	// INSERT YOUR CODE HERE:
	return (numer/denom);
    }

    static int factorial (int n)
    {
	int prod = 1;
	while (n != 0) {
	    prod = prod*n;
	    n = n-1;
	}
	// INSERT YOUR CODE HERE:
	return prod;
    }

}
