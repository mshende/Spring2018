// Instructions:
// Copy over the matrixMult() and matrixVectorMult() code from
// previous exercises.
// NOTE: you need to have draw3d.jar in your classpath.

import org.edisonwj.draw3d.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.stage.*;


public class MatrixVector3DExample extends Application {

    String title = "Vector example";

    void drawingCommands () 
    {
	double[][] A = {
	    {3, 2, 1},
            {-2, 3, 5},
	    {0, 0, 3}
        };
	double[][] B = {
	    {-4, 1, 0},
            {1, 0, 1},
	    {3, -2, 1}
        };
	double[] x = {1, -1, 2};

	double[] y = matrixVectorMult (A, x);
	print (y);

	double[] z = matrixVectorMult (B, y);
	print (z);

	double[][] C = matrixMult (B, A);
	print (C);
	
	double[] z2 = matrixVectorMult (C, x);
	print (z2);

	d3.setDrawColor (Color.BLUE);
	d3.drawVector (x);
	d3.setDrawColor (Color.GREEN);
	d3.drawVector (y);
	d3.setDrawColor (Color.RED);
	d3.drawVector (z);
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

    //////////////////////////////////////////////////////////

    Draw3D d3;

    void preambleCommands ()
    {
	d3.setAmbientLight(false);
	d3.setPointLight(true);
	d3.setCumulate(false);
	d3.setSequencingOn();
	d3.setVectorRadius(1);
        d3.setArrowRadius(1);
    }

    public void start (Stage primaryStage) 
    {
	d3 = new Draw3D ();
	Scene scene = d3.buildScene ();
	preambleCommands ();
	drawingCommands ();
	d3.setStart ();
	primaryStage.setScene (scene);
	primaryStage.setTitle (title);
	primaryStage.show ();
    }

    public static void main (String[] argv)
    {
	launch (argv);
    }


}
