import edu.gwu.lintool.*;
import java.util.Arrays;

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

    public ComplexNumber[] add (ComplexNumber[] u, ComplexNumber[] v) {
	if ((u==null) || (v==null)) {
	    System.out.println("one vector is null");
	    u = null;
	}
	else if (u.length != v.length) {
	    System.out.println("vector lengths don't match");
	    u = null;
	}
	else {
	    for (int i=0; i<u.length; i++) {
		System.out.println("u["+i+"]: real = "+u[i].re+"   im = "+u[i].im);
		System.out.println("v["+i+"]: real = "+v[i].re+"   im = "+v[i].im);
		u[i] = (ComplexNumber) u[i].add(v[i]);
		System.out.println("AFTER ADD -- u["+i+"]: real = "+u[i].re+"   im = "+u[i].im);

	    }
	}
	return u;
    }

    public double norm (ComplexNumber[] v) {
	double result = 0;
	if (v==null) {
	    result = -1;
	}
	else {
	    for (int i=0; i<v.length; i++) {
		result = result + v[i].magnitude();
	    }
	    result = Math.sqrt(result);
	}
	return result;
    }

    public ComplexNumber[] scalarProduct(ComplexNumber alpha, ComplexNumber[] v) {
	if (v == null) {
	    v = null;
	}
	else {
	    for (int i=0; i<v.length; i++) {
		v[i] = v[i].mult(alpha);
	    }
	}
	return v;
    }

    public ComplexNumber dotProduct(ComplexNumber[] u, ComplexNumber[] v) {
	if ((u==null) || (v==null)) {
	    u = null;
	}
	else if (u.length != v.length) {
	    u = null;
	}
	else {
	    for (int i=0; i<u.length; i++) {
		System.out.println("u["+i+"]: real = "+u[i].re+"   im = "+u[i].im);
		System.out.println("v["+i+"]: real = "+v[i].re+"   im = "+v[i].im);
		v[i] = v[i].conjugate();
		System.out.println("AFTER CONG -- v["+i+"]: real = "+v[i].re+"   im = "+v[i].im);
		u[i] = u[i].mult(v[i]);
		System.out.println("AFTER MULT -- u["+i+"]: real = "+u[i].re+"   im = "+u[i].im);

		if (i==0) {
		    u[0] = u[0];
		}
		else {
		    u[0] = u[0].add(u[i]);
		}
		System.out.println("AFTER ADD -- u[0]: real = "+u[0].re+"   im = "+u[0].im);

	    }
	}
	return u[0];
    }

    public ComplexNumber[][] add (ComplexNumber[][] A, ComplexNumber[][] B) {
	if ((A==null) || (B==null)) {
	    return null;
	}
	if ((A.length!=B.length) || (A[0].length!=B[0].length)) {
	    return null;
	}
	ComplexNumber[][] result = new ComplexNumber[A.length][A[0].length];
	for (int i=0; i<result.length; i++) {
	    for (int j=0; j<result[0].length; j++) {
		ComplexNumber c = ComplexNumber.makeComplexNumber(A[i][j].re+B[i][j].re, A[i][j].im+B[i][j].im);
		result[i][j] = c;
	    }
	}
// 	    for (int i=0; i<A.length; i++) {
// 		for (int j=0; j<A[0].length; j++) {
// 		    A[i][j] = A[i][j].add(B[i][j]);
// 		}
// 	    }
	return result;
    }

    public ComplexNumber[][] transpose (ComplexNumber[][] A, ComplexNumber[][] B) {
	if (A==null) {
	    A = null;
	}
	else {
	    for (int i=0; i<A.length; i++) {
		for (int j=0; j<A[0].length; j++) {
		    B[j][i] = A[i][j];
		}
	    }
	}
	return B;
    }

    public ComplexNumber[][] mult (ComplexNumber[][] A, ComplexNumber[][] B) {
	if ((A==null) || (B==null)) {
	    return null;
	}
	if (A.length != B[0].length) {
	    return null;
	}

	System.out.println("A: ");
	printComplexArray(A);
	System.out.println();
	System.out.println("B: ");
	printComplexArray(B);
	ComplexNumber[][] result = new ComplexNumber[A.length][B[0].length];
	for (int i=0; i<result.length; i++) {
	    for (int j=0; j<result[0].length; j++) {
		ComplexNumber c = ComplexNumber.makeComplexNumber(0, 0);
		result[i][j] = c;
//  		result[i][j].re = 0;
//  		result[i][j].im = 0;
	    }
	}
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<B[0].length; j++) {
		for (int k=0; k<A[0].length; k++) {
		    result[i][j] = result[i][j].add(A[i][k].mult(B[k][j]));
// 		    result[i][j].re += A[i][k].re*B[k][j].re - A[i][k].im*(-1)*B[k][j].im;
// 		    result[i][j].im += A[i][k].re*(-1)*B[k][j].im + A[i][k].im*B[k][j].re;
		}
	    }
	}
	System.out.println();
	System.out.println("Result: ");
	printComplexArray(result);
	return result;
    }

    public ComplexNumber[][] scalarProduct (ComplexNumber alpha, ComplexNumber[][] A) {
	if (A == null) {
	    return null;
	}
	ComplexNumber[][] result = A;
	for (int i=0; i<result.length; i++) {
	    for (int j=0; j<result[0].length; j++) {
		result[i][j].re = 0;
		result[i][j].im = 0;
	    }
	}
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<A[0].length; j++) {
		result[i][j].re = alpha.re*A[i][j].re - alpha.im*A[i][j].im;
		result[i][j].im = alpha.re*A[i][j].im + alpha.im*A[i][j].re;
	    }
	}
	return result;
    }

    public ComplexNumber[] matrixVectorMult (ComplexNumber[][] A, ComplexNumber[] v) {
	if ((A==null) || (v==null)) {
	    return null;
	}
	if (A[0].length != v.length) {
	    return null;
	}
	ComplexNumber[] result = new ComplexNumber[v.length];
	for (int i=0; i<result.length; i++) {
	    result[i] = ComplexNumber.makeComplexNumber(0,0);
	}
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<A[0].length; j++) {
		result[i] = result[i].add(A[i][j].mult(v[j]));
// 		result[i].re += A[i][j].re*v[j].re - A[i][j].im*v[j].im;
// 		result[i].im += A[i][j].re*v[j].im + A[i][j].im*v[j].re;
	    }
	}
	return result;
    }

    public ComplexNumber[][] hermitianTranspose(ComplexNumber[][] A) {
	if (A==null) {
	    return null;
	}
	ComplexNumber[][] result = new ComplexNumber[A[0].length][A.length];
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<A[0].length; j++) {
		result[j][i] = ComplexNumber.makeComplexNumber(A[i][j].re, (-1)*A[i][j].im);
	    }
	}
	return result;
    }

    public boolean areColumnsLI (double[][] A) {
	LinResult newResult = new LinResult();
	System.out.println("A = ");
	printArray(A);
	double[] b = new double[A.length];
	for (int i=0; i<b.length; i++) {
	    b[i] = 0;
	}
	newResult = computeRREF(A, b);
	boolean result = false;
	System.out.println("rank = "+newResult.rank);
	System.out.println("num rows = "+A.length);
	
	if (newResult.rank == A[0].length) {
	    result = true;
	}
	return result;
    }

    public double[] getColumn(double[][]A, int index) {
	double[] result = new double[A[index].length];
	for (int i=0; i<A[index].length; i++) {
	    result[i] = A[index][i];
	}
	return result;
    }

    public double[][] insertVectorInMatrix(double[][] A, double[] v, int index) {
	for (int i=0; i<A[index].length; i++) {
	    A[index][i] = v[i];
	}
	return A;
    }

    public LinResult gramSchmidt(double[][] A) {
	if (!areColumnsLI(A)) {
	    return null;
	}
	if (A==null) {
	    return null;
	}
	LinResult linResult = new LinResult();
	System.out.println("A = ");
	printArray(A);
	double[][]transA = transpose(A);
	System.out.println("transA = ");
	printArray(transA);
	linResult.V = new double[transA.length][transA[0].length];
	linResult.Q = new double[transA.length][transA[0].length];
	linResult.R = new double[transA.length][transA[0].length];
	for (int i=0; i<transA.length; i++) {
	    for (int j=0; j<transA[0].length; j++) {
		linResult.R[i][j] = 0;
	    }
	}
	double[] w0 = getColumn(transA, 0);
	double[] v0 = w0;
	linResult.R[0][0] = norm(v0);
	linResult.V = insertVectorInMatrix(linResult.V, v0, 0);
	double[] u0 = new double[v0.length];
	for (int i=0; i<v0.length; i++) {
	    u0[i] = v0[i] / norm(v0);
	}
	linResult.Q = insertVectorInMatrix(linResult.Q, u0, 0);
	for (int k=1; k<transA.length; k++) {
	    double[] wk = getColumn(transA, k);
	    double[] s = new double[wk.length];
	    for (int j=0; j<k; j++) {
		double[] vj = getColumn(linResult.V, j);
		double cjk = dotProduct(wk, vj) / dotProduct(vj, vj);
		double[] sj = scalarProduct(cjk, vj);
		s = add(s, sj);
		linResult.R[j][k] = cjk * norm(vj);
	    }
	    double[] vk = sub(wk, s);
	    linResult.V = insertVectorInMatrix(linResult.V, vk, k);
	    double[] uk = new double[vk.length];
	    for (int i=0; i<vk.length; i++) {
		uk[i] = vk[i] / norm(vk);
	    }
	    linResult.R[k][k] = norm(vk);
	    linResult.Q = insertVectorInMatrix(linResult.Q, uk, k);
	}
	linResult.V = transpose(linResult.V);
	linResult.Q = transpose(linResult.Q);
	return linResult;
    }

    public LinResult computeQR(double[][] A) {
	LinResult linResult = new LinResult();
	linResult = gramSchmidt(A);
	return linResult;
    }

    public void printVector(double[] v) {
	System.out.print("[");
	for (int i=0; i<v.length; i++) {
	    System.out.print("("+v[i]+")");
	}
	System.out.print("]");
	System.out.println();
    }

    private double[][] computeAugmentedMatrix(double[][] A, double[] b) {
	double[][] augmentedMat = new double[A.length][A[0].length+1];
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<A[0].length+1; j++) {
		if (j < A[0].length) {
		    augmentedMat[i][j] = A[i][j];
		}
		else {
		    augmentedMat[i][j] = b[i];
		}
	    }
	}
	return augmentedMat;
    }

    private double[][] computeIdentity(int n) {
	double[][] ident = new double[n][n];
	for (int i=0; i<n; i++) {
	    for (int j=0; j<n; j++) {
		if (i==j) {
		    ident[i][j] = 1;
		}
		else {
		    ident[i][j] = 0;
		}
	    }
	}
	return ident;
    }

    private int[] findNextPivot (int currentRow, int currentCol, double[][] A) {
	int[] result = new int[2];
	result[0] = A.length;
	result[1] = A[0].length;
	for (int j=currentCol; j<A[0].length; j++) {
	    for (int i=currentRow; i<A.length; i++) {
		if (A[i][j] != 0) {
		    result[0] = i;
		    result[1] = j;
		    return result;
		}
	    }
	}
	return result;
    }

    private double[][] swap(int r, int currentRow, double[][] mat) {
	double[][] result = new double[mat.length][mat[0].length];
	int diff = r - currentRow;
	for (int i=0; i<mat.length; i++) {
	    for (int j=0; j<mat[0].length; j++) {
		if (i==currentRow) {
		    result[i][j] = mat[i+diff][j]; 
		}
		else if (i==r) {
		    result[i][j] = mat[i-diff][j];
		}
		else {
		    result[i][j] = mat[i][j];
		}
	    }
	}
	return result;
    }

    private boolean[] fillBoolArray(int rank, boolean[] currArray) {
	boolean[] temp = new boolean[rank];
	if (currArray == null) {
	    temp[0] = true;
	}
	else {
	    for (int i=0; i<currArray.length; i++) {
		temp[i] = currArray[i];
	    }
	    temp[currArray.length] = true;
	}
	return temp;
    }

    private int[] fillIntArray(int rank, int value, int[] currArray) {
	int[] temp = new int[rank];
	if (currArray == null) {
	    temp[0] = value;
	}
	else {
	    for (int i=0; i<currArray.length; i++) {
		temp[i] = currArray[i];
	    }
	    temp[currArray.length] = value;
	}
	return temp;
    }


    private LinResult computeREF_helper (double[][] A, double[] b) {

	LinResult result = new LinResult();
	result.pivotRow = new int[A[0].length];
	for (int i=0; i<result.pivotRow.length; i++) {
	    result.pivotRow[i] = -1;
	}
	result.isPivotColumn = new boolean[A[0].length];
	result.b = b;
	result.A = A;
	double[][] augmentedMat = computeAugmentedMatrix(A, b);
// 	System.out.println("augmented matrix = ");
// 	printArray(augmentedMat);
	double[][] ident = computeIdentity(A.length);
	int currentRow = 0; 
	int currentCol = 0;
	int numPivots = 0;
	int[] pivot = findNextPivot(currentRow, currentCol, A);
	System.out.println("new pivot = ("+pivot[0]+", "+pivot[1]+")");	
	
	while ((pivot[0] < A.length) && (pivot[1] < A[0].length)) {
	    if (pivot[0] > currentRow) {
		augmentedMat = swap(pivot[0], currentRow, augmentedMat);
		ident = swap(pivot[0], currentRow, ident);
	    }
	    currentCol = pivot[1];
// 	    currentRow = r;
// 	    System.out.println("current col = "+currentCol);
// 	    System.out.println("is pivot col = "+result.isPivotColumn);
	    // need to dynamically change size of isPivotColumn
	    result.rank = result.rank + 1;
	    result.isPivotColumn[currentCol] = true;
// 	    result.isPivotColumn = fillBoolArray(result.rank, result.isPivotColumn);
// 	    result.isPivotColumn[currentCol] = true;
	    result.pivotRow[currentCol] = currentRow;
// 	    result.pivotRow = fillIntArray(result.rank, currentRow, result.pivotRow);
// 	    System.out.println("current row = "+currentRow+"   currentCol = "+currentCol);
	    double alpha = augmentedMat[currentRow][currentCol];
	    for (int j=0; j< augmentedMat[0].length; j++) {
		augmentedMat[currentRow][j]=augmentedMat[currentRow][j]/alpha;
		if (j < ident[0].length) {
		    ident[currentRow][j] = ident[currentRow][j] / alpha;
		}
	    }
	    for (int i=currentRow+1; i<augmentedMat.length; i++) {
		double scalar = augmentedMat[i][currentCol];
		for (int j=0; j<augmentedMat[0].length; j++) {
		    augmentedMat[i][j] = augmentedMat[i][j] - scalar * augmentedMat[currentRow][j];
		    if (j < ident[0].length) {
			ident[i][j] = ident[i][j] - scalar*ident[currentRow][j];
		    }
		}
	    }
	    currentRow = currentRow + 1;
	    currentCol = currentCol + 1;
	    pivot = findNextPivot(currentRow, currentCol, augmentedMat);
	    System.out.println("new pivot = ("+pivot[0]+", "+pivot[1]+")");
	}
// 	System.out.println("augmented matrix after row reducs = ");
// 	printArray(augmentedMat);
	result.ref = augmentedMat;
// 	System.out.println("ident after row reducs = ");
// 	printArray(ident);
	System.out.println("rank = "+result.rank);
	for (int i=0; i<result.pivotRow.length; i++) {
	    System.out.println("pivotRow =  "+result.pivotRow[i]);
	}
	for (int i=0; i<result.isPivotColumn.length; i++) {
	    System.out.println(i+" is pivot col = "+result.isPivotColumn[i]);
	}
	
	result.Ainv = ident;
	return result;
    }

    private LinResult computeRREF_helper (double[][] A, double[] b) {
	LinResult result = computeREF_helper(A, b);
	System.out.println("beginning rref steps");

	double[][] augmentedMat = new double[A.length][A[0].length+1];
	for (int i=0; i<result.ref.length; i++) {
	    for (int j=0; j<result.ref[0].length; j++) {
		augmentedMat[i][j] = result.ref[i][j];
	    }
	}
	System.out.println("REF = ");
	printArray(augmentedMat);
	System.out.println("inverse after ref = ");
	printArray(result.Ainv);
	int rp = 0;
	int cp = 0;
	for (int k=0; k<result.rank; k++) {
	    rp = k;
	    for (int i=0; i<result.pivotRow.length; i++) {
		if (result.pivotRow[i] == k) {
		    cp = i;
		}
	    }
// 	    cp = k;
	    for (int r=rp-1; r >= 0; r--) {
		double scalar = augmentedMat[r][cp];
		for (int j=cp; j<augmentedMat[0].length; j++) {
		    augmentedMat[r][j] = augmentedMat[r][j] - scalar*augmentedMat[rp][j];
		}
		for (int j=0; j<result.Ainv[0].length; j++) {
			result.Ainv[r][j] = result.Ainv[r][j] - scalar*result.Ainv[rp][j];		    		    
		}
	    }
	}
	System.out.println("rref = ");
	printArray(augmentedMat);
	System.out.println("inverse after rref = ");
	printArray(result.Ainv);
	System.out.println("rank = "+result.rank);
	System.out.println("number of rows = "+A.length);
	if (result.rank != A.length) {
	    result.Ainv = null;
	}
	else if (result.rank != A[0].length) {
	    result.Ainv = null;
	}
	result.rref = augmentedMat;
	return result;
    }

    public void printArray (double[][] A) {
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<A[0].length; j++) {
		System.out.print("["+A[i][j]+" ");
	    }
	    System.out.print("]");
	    System.out.println();
	}
    }

    private void printComplexArray (ComplexNumber[][] A) {
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<A[0].length; j++) {
		System.out.print("[("+A[i][j].re+", "+A[i][j].im+") ");
	    }
	    System.out.print("]");
	    System.out.println();
	}
    }


    private boolean contradictionHelper (double[][] A) {
	for (int i=0; i<A.length; i++) {
	    boolean zero = true;
	    for (int j=0; j <A[0].length-1; j++) {
		if (A[i][j] == 0) {
		    zero = zero && true;
		}
		else {
		    zero = zero && false;
		}
	    }
	    if ((zero == true) && (A[i][A[i].length-1] != 0)){
		return true;
	    }
	}
	return false;
    }

    public LinResult computeRREF (double[][] A, double[] b) {
	LinResult newResult = new LinResult();
	if ((A==null) || (b==null)) {
	    return null;
	}
	if (A.length != b.length) {
	    return null;
	}
	System.out.println("A = ");
	printArray(A);
	newResult = computeRREF_helper(A, b);
	return newResult;
    }

    public LinResult computeREF (double[][] A, double[] b) {
	LinResult newResult = new LinResult();
	if ((A==null) || (b==null)) {
	    return null;
	}
	if (A.length != b.length) {
	    return null;
	}
	newResult = computeREF_helper(A, b);
	return newResult;
    }

    public LinResult inverse (double[][] A) {
	System.out.println("A = ");
	printArray(A);
	double[] b = new double[A.length];
	if ((A==null) || (b==null)) {
	    return null;
	}
	LinResult newResult = computeRREF_helper(A, b);
	return newResult;
    }

    public LinResult solveFromRREF (double[][] A, double[] b) {
	System.out.println("A = ");
	printArray(A);
	LinResult result = computeRREF_helper(A, b);
	if (contradictionHelper(result.rref)) {
	    System.out.println("contradiction - no solution");
	    result.solutionExists = false;
	    result.isUniqueSolution = false;
	    result.x = null;
	}
	else if (result.rank < A.length) {
	    result.x = new double[A[0].length];
	    for (int i=0; i<result.rank; i++) {
		result.x[i] = result.rref[i][result.rref[0].length-1];
	    }
	    for (int i=result.rank; i<result.rref[0].length-1; i++) {
		result.x[i] = 0;
	    }
	    result.solutionExists = true;
	    if (result.rank == A[0].length) {
		result.isUniqueSolution = true;
	    }
	    else {
		result.isUniqueSolution = false;
	    }

	}	
	else if ((result.rank == A.length) && (result.rank == A[0].length)) {
	    result.solutionExists = true;
	    result.isUniqueSolution = true;
	    result.x = new double[A.length];
	    for (int i=0; i<A.length; i++) {
		result.x[i] = result.rref[i][result.rref[0].length - 1];
	    }
	}
	else if ((result.rank != A.length) && (result.rank == A[0].length)) {
	    //there are multiple solutions
	    result.solutionExists = true;
	    result.isUniqueSolution = false;
	    for (int i=0; i<A[0].length; i++) {
		result.x[i] = result.rref[i][result.rref[0].length-1];
	    }
	}
	else if ((result.rank == A.length) && (result.rank != A[0].length)) {
	    result.x = new double[A[0].length];
	    result.solutionExists = true;
	    result.isUniqueSolution = false;
	    int counter = 0;
	    for (int i=0; i<result.isPivotColumn.length; i++) {
		if (result.isPivotColumn[i]) {
		    result.x[i] = result.rref[counter][result.rref[0].length-1];
		    counter++;
		}
		else {
		    result.x[i] = 0;
		}
	    }
	}

	return result;
    }
    
    public LinResult solveFromREF(double[][] A, double[] b) {
	LinResult result = solveFromRREF(A, b);
	return result;
    }

} 