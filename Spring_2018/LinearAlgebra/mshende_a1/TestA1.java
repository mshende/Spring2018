import edu.gwu.lintool.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class TestA1 {

    public static void main (String[] argv)
    {
	// Make an instance of your ComplexNumber class. REPLACE
	// AliceComplex below with your version.
	MshendeComplex c = new MshendeComplex (3, 5);

	// This tests your implementation of complex numbers.
 	LinTest.testComplex (c); 
	
	// REPLACE the line below with your tool, and un-comment.
	MshendeLinTool lin = new MshendeLinTool ();
// 	double[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
// 	double[][] B = {{1.1, 2.2, 3.3}, {4.1, 5.2, 6.3}, {7.1, 8.2, 10}};
// 	double[] u = {1, 2, 3};
// 	double[] v = {3, 4};
// 	double errorTol = 0.8;
	//	double result = lin.approxEquals(A,B,errorTol);
	//	result = lin.approxEquals(u,v,errorTol);
// 	double result = lin.cosine(u,v);
// 	double[][] result = lin.vectorLeftMult(u,v);
// 	for (int i=0;i<result.length;i++) {
// 	    for (int j=0;j<result[0].length; j++) {
// 		System.out.println(result[i][j]);
// 	    }
// 	}
	//	System.out.println("the result = "+result);
	// Un-comment tests one by one until all are passed.
	LinTest.testVectorOperations (lin);
 	LinTest.testMatrixOperations (lin);
    }

}
