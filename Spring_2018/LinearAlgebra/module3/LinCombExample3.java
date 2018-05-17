// Instructions:
// Write code to systematically search over alpha, beta values.


public class LinCombExample3 {

    public static void main (String[] argv) 
    {
	double[] u = {1,4};
	double[] v = {3,2};
	double[] z = {7.5,10};
	double minFirst = Double.POSITIVE_INFINITY;
	double minSecond = Double.POSITIVE_INFINITY;
	double min_alpha = 0;
	double min_beta = 0;
	for (double alpha=0; alpha<=10; alpha+=0.1) {
	    for (double beta=0; beta<=10; beta+=0.1) {
		double [] result = add(scalarMult(alpha, u), scalarMult(beta, v));
		double first = (double)Math.round(result[0]*100000d) / 100000d;
		double second = (double)Math.round(result[1]*100000d) / 100000d;
		if ((first == z[0]) && (second == z[1])) {
		    min_alpha = alpha;
		    min_beta = beta;
		}
	    }
	}
	System.out.println("alpha = "+min_alpha+" and beta = "+min_beta);
    }

    static double[] add (double[] u, double[] v) {
	double resultX = u[0] + v[0];
	double resultY = u[1] + v[1];
	double[] result = {resultX, resultY};
	return result;
    }

    static double[] scalarMult (double alpha, double[] v) {
	double resultX = alpha*v[0];
	double resultY = alpha*v[1];
	double[] result = {resultX, resultY};
	return result;
    }
}
