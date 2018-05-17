import edu.gwu.lintool.*;

public class MshendeLinTool extends LinToolEmpty {
    
    public double[] add (double[] u, double[] v) {
	double [] result = new double[0];
	if (u==null) {
	    result = u;
	}
	else if (v==null) {
	    result = v;
	} 
	else {
	    if (u.length == v.length) {
		result = new double [u.length];
		for (int i=0; i < u.length; i++) {
		    result[i] = u[i] + v[i];
		}
	    }
	    else {
		result = null;
	    }
	}
	return result;
    }

    public double[] sub (double[] u, double[] v) {
	double [] result = new double[0];
	if (u==null) {
	    result = u;
	}
	else if (v==null) {
	    result = v;
	} 
	else {
	    if (u.length == v.length) {
		result = new double [u.length];
		for (int i=0; i < u.length; i++) {
		    result[i] = u[i] - v[i];
		}
	    }
	    else {
		result = null;
	    }
	}
	return result;
    }


    public double norm (double[] v) {
	double result = 0;
	if (v==null) {
	    result = -1;
	}
	else {
	    for (int i=0; i<v.length;i++) {
		result = result + v[i]*v[i];
	    }
	    result = Math.sqrt(result);
	}
	return result;
    }

    public double dotProduct (double[] u, double[] v) {
	double result = 0;
	if ((u==null) || (v==null)) {
	    result = -1;
	}
	else {			
	    if (u.length != v.length) {
		result = -1;
	    }
	    else {
		for (int i=0;i<u.length;i++) {
		    result = result + u[i]*v[i];
		}
	    }
	}
	return result;
    }

    public double[] scalarProduct (double alpha, double[] v) {
	double[] result = new double[0];
	if (v==null) {
	    result = v;
	}
	else {
	    result = new double[v.length];
	    for (int i=0;i<v.length;i++) {
		result[i] = alpha*v[i];
	    }
	}
	return result;
    }

    public double[][] add (double[][] A, double [][]B) {
	double[][] result = new double[A.length][A[0].length];
	if ((A==null) || (B==null)) {
	    result = null;
	}
	else if ((A.length != B.length) || (A[0].length != B[0].length)) {
	    result = null;
	}
	else {
	    for (int i=0;i<A.length;i++) {
		for (int j=0;j<A[0].length;j++) {
		    result[i][j] = A[i][j] + B[i][j];
		}
	    }
	}
	return result;
    }

    public double[][] sub (double[][] A, double [][]B) {
	double[][] result = new double[A.length][A[0].length];
	if ((A==null) || (B==null)) {
	    result = null;
	}
	else if ((A.length != B.length) || (A[0].length != B[0].length)) {
	    result = null;
	}
	else {
	    for (int i=0;i<A.length;i++) {
		for (int j=0;j<A[0].length;j++) {
		    result[i][j] = A[i][j] - B[i][j];
		}
	    }
	}
	return result;
    }

    public double[][] scalarProduct (double alpha, double[][] A) {
	double[][] result;
	if (A==null) {
	    result = null;
	}
	else {
	    result = new double[A.length][A[0].length];
	    for (int i=0; i<A.length; i++) {
		for (int j=0; j<A[0].length; j++) {
		    result[i][j] = alpha * A[i][j];
		}
	    }
	}
	return result;
    }

    public double[][] mult (double[][] A, double[][] B) {
	double[][] result;
	if ((A==null) || (B==null)) {
	    result = null;
	}
	else if (A[0].length != B.length) {
		result = null;
	}
	else {
	    result = new double[A.length][B[0].length];
	    double[][] transposeB = new double[B[0].length][B.length];
	    for (int i=0; i<B.length; i++) {
		for (int j=0; j<B[0].length; j++) {
		    transposeB[j][i] = B[i][j];
		}
	    }
	    for (int i=0; i<A.length; i++) {
		for (int j=0; j<transposeB.length; j++) {
		    result[i][j] = dotProduct(A[i], transposeB[j]);
		}
	    }
	}
	return result;
    }
    
    public double[] matrixVectorMult (double[][] A, double[] v) {
	double[] result = new double[A.length];
	if ((A==null) || (v==null)) {
	    result = null;
	}
	else if (A[0].length != v.length) {
	    result = null;
	}
	else {
	    double entry = 0;
	    for (int i=0; i<A.length; i++) {
		entry = dotProduct(A[i], v);
		result[i] = entry;
	    }
	}
	return result;
    }
    
    public double[] vectorMatrixMult (double[] v, double[][] A) {
	double[] result;
	if ((v==null) || (A==null)) {
	    result = null;
	}
	else if (v.length != A.length) {
	    result = null;
	}
	else {
	    double[][] transposeA = new double[A[0].length][A.length];
	    for (int i = 0; i<A.length; i++) {
		for (int j = 0; j<A[0].length; j++) {
		    transposeA[j][i] = A[i][j];
		}
	    }
	    result = new double[A[0].length];
	    for (int i=0; i<transposeA.length; i++) {
		result[i] = dotProduct(v, transposeA[i]);
	    }
	}
	return result;
    }

    public double[][] transpose (double[][] A) {
	double[][] transposeA;
	if (A==null) {
	    transposeA = null;
	}
	else {
	    transposeA = new double[A[0].length][A.length];
	    for (int i = 0; i<A.length; i++) {
		for (int j = 0; j<A[0].length; j++) {
		    transposeA[j][i] = A[i][j];
		}
	    }
	}
	return transposeA;
    }

    public double[] getColumnAsVector (double[][] A, int col) {
	double[] result;
	if (A==null) {
	    result = null;
	}
	else {
	    double[][] transposeA = transpose(A);
	    result = transposeA[col];
	}
	return result;
    }

    public double[] getRowAsVector (double[][] A, int row) {
	double[] result;
	if (A==null) {
	    result = null;
	}
	else {
	    result = A[row];
	}
	return result;
    }

    public double frobeniusNorm (double[][] A) {
	double result;
	if (A==null) {
	    result = -1;
	}
	else {
	    result = 0;
	    for (int i=0; i<A.length; i++) {
		for (int j=0; j<A[0].length; j++) {
		    result = result + A[i][j]*A[i][j];
		}
	    }
	    result = Math.sqrt(result);
	}
	return result;
    }
    
    public boolean approxEquals (double[] u, double[] v, double errorTolerance) {
	boolean result = false;
	if ((u==null) || (v==null)) {
	    result = false;
	}
	else {
	    double[] difference = sub(u,v);
	    double theNorm = norm(difference);
	    System.out.println("the norm is: "+theNorm);
	    if (Math.abs(theNorm) <= errorTolerance) {
		result = true;
	    }
	}
	return result;
    }

    public double cosine (double[] u, double[] v) {
	double result = 0;
	if ((u==null) || (v==null)) {
	    result = -1;
	}
	else {
	    double udotv = dotProduct(u,v);
	    double normu = norm(u);
	    double normv = norm(v);
	    result = udotv / (normu*normv);
	}
	return result;
    }

    public boolean approxEquals (double[][] A, double[][] B, double errorTolerance) {
	boolean result = false;
	if ((A==null) || (B==null)) {
	    result = false;
	}
	else {
	    double[][] difference = sub(A,B);
	    double theNorm = frobeniusNorm(difference);
	    System.out.println("the norm is: "+theNorm);
	    if (Math.abs(theNorm) <= errorTolerance) {
		result = true;
	    }
	}
	return result;
    }
    
    public double[][] vectorLeftMult (double[] u, double[] v) {
	double[][] result;
	if ((u==null) || (v==null)) {
	    result = null;
	}
	else {
	    result = new double[u.length][v.length];
	    for (int i=0;i<u.length;i++) {
		for (int j=0;j<v.length;j++) {
		    result[i][j] = u[i]*v[j];
		}
	    }
	}
	return result;
    }
} 